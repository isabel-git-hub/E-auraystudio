package com.example.AurayStudio.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.AurayStudio.dto.ImgmngDto;
import com.example.AurayStudio.dto.PaintDto;
import com.example.AurayStudio.service.PaintService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product/paint")
public class PaintController {
	private final PaintService paintservice;
	
	// 제품 목록 페이지
    @GetMapping("/registration")
    public String registration(Model model) {
        List<PaintDto>paints = paintservice.getAllPaints();
        model.addAttribute("paints", paints);
        return "product/paint/registration";
    }
    
 // 제품 추가
    @PostMapping("/add")
    public String addPaint(Model model, PaintDto paintdto, @RequestParam(value = "file", required = false) MultipartFile[] files) {
        // 경로를 외부 설정에서 불러오거나 하드코딩된 경로를 사용
        final String path = "C:\\Users\\admin\\Desktop\\AURAY code\\AurayStudio\\src\\main\\resources\\static\\img\\paint";
        System.out.println("length="+files.length);
        // Paint 정보 추가
        paintservice.addPaint(paintdto);

        // 파일 업로드 처리
        if (files != null && files.length > 0) {
            for (MultipartFile file : files) {
                try {
                    ImgmngDto imgdto = new ImgmngDto();
                    String org_file_name = file.getOriginalFilename();
                    String file_name = UUID.randomUUID().toString().substring(0,8) + "_" + org_file_name;

                    // ImgmngDto에 정보 설정
                    imgdto.setFile_path(path);
                    imgdto.setOrg_file_name(org_file_name);
                    imgdto.setFile_name(file_name);
                    imgdto.setY_no(paintdto.getY_no());

                    System.out.println(path + File.separator + file_name);
                    // 파일을 실제 저장 위치에 저장
                    File destinationFile = new File(path + File.separator + file_name);
                    file.transferTo(destinationFile);

                    // 이미지 정보 저장
                    paintservice.uploadImg(imgdto);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Paint 목록을 모델에 추가
        List<PaintDto> list = paintservice.getPaintList();
        model.addAttribute("list", list);

        return "redirect:/product/paint/registration";
    }
	
	  @GetMapping("/downloadImg/{y_no}") public ResponseEntity<Resource>
	  downloadImg(@PathVariable("y_no")String y_no) { 
		  try { 
			  ImgmngDto dto = paintservice.downloadImg(y_no); 
			  Path filePath = Paths.get(dto.getFile_path()).resolve(dto.getFile_name()).normalize();
			  Resource resource = new UrlResource(filePath.toUri()); 
			  if(resource.exists()) { 
				  String encodeFileName = URLEncoder.encode(dto.getOrg_file_name(),
						  StandardCharsets.UTF_8.toString()); 
				  String contentDisposition = "attachment; filename=\"" + encodeFileName + "\""; 
				  
				  return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
						  .header(HttpHeaders.CONTENT_TYPE, "application/octet-stream").body(resource); 
				  } 
				  else { 
					  return ResponseEntity.notFound().build(); 
				  } 
			  }
			  catch(IOException e) { 
				  e.printStackTrace(); 
				  return ResponseEntity.notFound().build(); 
		  } 
	  }
	 
    
    // 제품 삭제
    @GetMapping("/delete/{y_no}")
    public String deletePaint(@PathVariable("y_no") String y_no) {
        paintservice.deletePaint(y_no);  // y_no로 삭제
        return "redirect:/product/paint/registration";
    }
	
	// 페인트
	@GetMapping("/paint")
	public String Paint (Model model) {
		List<PaintDto> paints = paintservice.getPaintsByKKind("페인트") ;
		model.addAttribute("paints", paints);
		return "product/paint/paint";
	}
	
	@GetMapping ("/paint/{y_no}")
	public String PaintA (@PathVariable("y_no") String y_no , Model model) {
		model.addAttribute("paintA", paintservice.findByYNo(y_no)) ;
		return "product/paint/paint/PA_product" ;
	}
	
	// 방수 페인트
	@GetMapping("/waterproof")
	public String PaintWaterproof (Model model) {
		List<PaintDto> paints = paintservice.getPaintsByKKind("방수페인트") ;
		model.addAttribute("paints", paints) ;
		return "product/paint/waterproof" ;
	}
	
	@GetMapping ("/waterproof/{y_no}")
	public String PaintWaterproofA (@PathVariable("y_no") String y_no , Model model) {
		model.addAttribute("waterproofA", paintservice.findByYNo(y_no)) ;
		return "product/paint/waterproof/PB_product" ;
	}
	
	// 프라이머
	@GetMapping("/primer")
	public String PaintPrimer (Model model) {
		List<PaintDto> paints = paintservice.getPaintsByKKind("프라이머") ;
		model.addAttribute("paints", paints) ;
		return "product/paint/primer" ;
	}
	
	@GetMapping ("/primer/{y_no}")
	public String PaintPrimerA (@PathVariable("y_no") String y_no , Model model) {
		model.addAttribute("primerA", paintservice.findByYNo(y_no)) ;
		return "product/paint/primer/PC_product" ;
	}
	
	// 에폭시
	@GetMapping("/epoxy")
	public String PaintEpoxy (Model model) {
		List<PaintDto> paints = paintservice.getPaintsByKKind("에폭시") ;
		model.addAttribute("paints", paints) ;
		return "product/paint/epoxy" ;
	}
	
	@GetMapping ("/epoxy/{y_no}")
	public String PaintEpoxyA (@PathVariable("y_no") String y_no , Model model) {
		model.addAttribute("epoxyA", paintservice.findByYNo(y_no)) ;
		return "product/paint/epoxy/PD_product" ;
	}
	
	// 신나
	@GetMapping("/thinner")
	public String PaintThinner (Model model) {
		List<PaintDto> paints = paintservice.getPaintsByKKind("신나") ;
		model.addAttribute("paints", paints) ;
		return "product/paint/thinner" ;
	}
	
	@GetMapping ("/thinner/{y_no}")
	public String PaintThinnerA (@PathVariable("y_no") String y_no , Model model) {
		model.addAttribute("thinnerA", paintservice.findByYNo(y_no)) ;
		return "product/paint/thinner/PE_product" ;
	}
	
	// 탄성코트
	@GetMapping("/elastic")
	public String PaintElastic (Model model) {
		List<PaintDto> paints = paintservice.getPaintsByKKind("탄성코트") ;
		model.addAttribute("paints", paints) ;
		return "product/paint/elastic" ;
	}
	
	@GetMapping ("/elastic/{y_no}")
	public String PaintElasticA (@PathVariable("y_no") String y_no , Model model) {
		model.addAttribute("elasticA", paintservice.findByYNo(y_no)) ;
		return "product/paint/elastic/PF_product" ;
	}
}
