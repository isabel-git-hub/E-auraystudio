package com.example.AurayStudio.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.AurayStudio.dto.InnergateDto;
import com.example.AurayStudio.service.InnergateService;
import com.example.AurayStudio.service.PostService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

@Controller
@RequestMapping("/product/post")
public class PostController {

    private final PostService postservice;
    private final InnergateService innergateService;

    public PostController(PostService postservice, InnergateService innergateService) {
        this.postservice = postservice;
        this.innergateService = innergateService;
    }

    @GetMapping("/insert")
    public String insertPostForm(Model model, @RequestParam(value = "digitCount", defaultValue = "2") int digitCount) {
        InnergateDto innergateDto = new InnergateDto();
        String lastYno = innergateService.findLastYno(digitCount);
        innergateDto.setY_no(lastYno);
        model.addAttribute("innergate", innergateDto);
        return "product/post/insert";
    }

    @PostMapping("/insert")
    public String insertPost(@ModelAttribute @Validated InnergateDto innergateDto, 
                             BindingResult bindingResult, 
                             HttpServletRequest request, 
                             Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("innergate", innergateDto);
            model.addAttribute("message", "폼 유효성 검사를 통과하지 못했습니다.");
            return "product/post/insert";
        }

        try {
            Part filePart = request.getPart("y_img");
            if (filePart != null && filePart.getSize() > 0) {
                String fileName = getFileName(filePart);
                String filePath = request.getServletContext().getRealPath("/uploads/") + fileName;

                File saveFile = new File(filePath);
                int count = 1;
                while (saveFile.exists()) {
                    String newFileName = fileName.substring(0, fileName.lastIndexOf("."))
                            + "_" + count
                            + fileName.substring(fileName.lastIndexOf("."));
                    filePath = request.getServletContext().getRealPath("/uploads/") + newFileName;
                    saveFile = new File(filePath);
                    count++;
                }

                File directory = new File(request.getServletContext().getRealPath("/uploads/"));
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                try (InputStream fileContent = filePart.getInputStream();
                     FileOutputStream outputStream = new FileOutputStream(saveFile)) {
                    int read;
                    byte[] bytes = new byte[1024];
                    while ((read = fileContent.read(bytes)) != -1) {
                        outputStream.write(bytes, 0, read);
                    }
                }

                innergateDto.setY_img("/uploads/" + saveFile.getName()); // 업로드된 파일 경로를 DTO에 설정
            }

            postservice.saveInnergate(innergateDto);
            return "redirect:/product/innergate";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("innergate", innergateDto);
            model.addAttribute("message", "파일 업로드 중 오류가 발생했습니다.");
            return "product/post/insert";
        }
    }

    private String getFileName(Part filePart) {
        String contentDisposition = filePart.getHeader("content-disposition");
        String[] items = contentDisposition.split(";");
        for (String item : items) {
            if (item.trim().startsWith("filename")) {
                return item.substring(item.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
