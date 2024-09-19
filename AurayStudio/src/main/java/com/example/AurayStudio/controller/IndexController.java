package com.example.AurayStudio.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.AurayStudio.dto.BathDto;
import com.example.AurayStudio.dto.Built_inDto;
import com.example.AurayStudio.dto.DoorDto;
import com.example.AurayStudio.dto.FilmDto;
import com.example.AurayStudio.dto.InnergateDto;
import com.example.AurayStudio.dto.ItemDto;
import com.example.AurayStudio.dto.ItemimgDto;
import com.example.AurayStudio.dto.KitchenDto;
import com.example.AurayStudio.dto.MouldingDto;
import com.example.AurayStudio.dto.TileDto;
import com.example.AurayStudio.dto.WallDto;
import com.example.AurayStudio.dto.WindowDto;
import com.example.AurayStudio.service.BathService;
import com.example.AurayStudio.service.Built_inService;
import com.example.AurayStudio.service.DoorService;
import com.example.AurayStudio.service.FilmService;
import com.example.AurayStudio.service.InnergateService;
import com.example.AurayStudio.service.ItemService;
import com.example.AurayStudio.service.KitchenService;
import com.example.AurayStudio.service.MouldingService;
import com.example.AurayStudio.service.TileService;
import com.example.AurayStudio.service.WallService;
import com.example.AurayStudio.service.WindowService;

import jakarta.servlet.http.HttpSession;

//@RequiredArgsConstructor
@Controller
public class IndexController {
	@Autowired
	private ItemService itemservice;
	@Autowired
	private KitchenService kitchenservice;
	@Autowired
	private Built_inService built_inservice;
	@Autowired
	private DoorService doorservice;
	@Autowired
	private InnergateService innergateservice;
	@Autowired
	private BathService bathservice;
	@Autowired
	private TileService tileservice;
	@Autowired
	private WindowService windowservice;
	@Autowired
	private MouldingService mouldingservice;
	@Autowired
	private WallService wallservice;
	@Autowired
	private FilmService filmservice;
	
	
	@GetMapping({"/", "/index"})
	public String indexPage(HttpSession session, Model model) {
		// 세션에서 사용자 정보 가져오기
        String loggedInUser = (String) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            model.addAttribute("greeting", "안녕하세요, " + loggedInUser + "님");
        }
		return "index";
	}
	
	@GetMapping("/company")
	public String companyForm() {
		return "company";
	}
	
	@GetMapping("/shop")
	public String shopPage (Model model) {
		return "/shop" ;
	}
	
	// 제품 목록 페이지
	@GetMapping("/mypage/registration")
	public String registration(Model model, 
	                           @RequestParam(value = "page", defaultValue = "1") Integer page, 
	                           @RequestParam(value = "size", defaultValue = "10") Integer size,
	                           @RequestParam(value = "category", required = false) String category) {
	    // 기본값을 명시적으로 확인 (null인 경우 대비)
	    if (size == null) size = 10;

	    List<ItemDto> items;
	    if (category != null && !category.isEmpty()) {
	    	items = itemservice.getAllItems();
	    } else {
	    	// 카테고리가 없으면 전체 데이터
	    	items = itemservice.getItemsWithPaging(page, size);
	    }

	    int totalItems = itemservice.getTotalItemCount();
	    int totalPages = (int) Math.ceil((double) totalItems / size);

	    // 페이지 그룹 계산
	    int pageGroupSize = 10;  // 한 페이지 그룹에 몇 개의 페이지를 보여줄지 설정
	    int currentGroup = (page - 1) / pageGroupSize;  // 현재 페이지 그룹
	    int startPage = currentGroup * pageGroupSize + 1;  // 시작 페이지 번호
	    int endPage = Math.min(startPage + pageGroupSize - 1, totalPages);  // 마지막 페이지 번호

	    // 페이징 정보 추가
	    model.addAttribute("items", items);
	    model.addAttribute("currentPage", page);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("startPage", startPage);
	    model.addAttribute("endPage", endPage);
	    model.addAttribute("hasPrevPage", currentGroup > 0);
	    model.addAttribute("hasNextPage", endPage < totalPages);
	    model.addAttribute("size", size);  // size 값을 모델에 추가하여 템플릿으로 전달

	    return "registration";  // registration.html로 이동
	}

	// 제품 목록 페이지
		@GetMapping("/mypage/kitchen")
		public String mykitchen(Model model, 
		                        @RequestParam(value = "page", defaultValue = "1") Integer page, 
		                        @RequestParam(value = "size", defaultValue = "10") Integer size,
		                        @RequestParam(value = "category", required = false) String category) {
		    // 기본값을 명시적으로 확인 (null인 경우 대비)
		    if (size == null) size = 10;

		    List<KitchenDto> kithchens;
		    if (category != null && !category.isEmpty()) {
		    	kithchens = kitchenservice.getAllKitchens();
		    } else {
		    	// 카테고리가 없으면 전체 데이터
		    	kithchens = kitchenservice.getKitchensWithPaging(page, size);
		    }

		    int totalKitchens = kitchenservice.getTotalKitchenCount();
		    int totalPages = (int) Math.ceil((double) totalKitchens / size);

		    // 페이지 그룹 계산
		    int pageGroupSize = 10;  // 한 페이지 그룹에 몇 개의 페이지를 보여줄지 설정
		    int currentGroup = (page - 1) / pageGroupSize;  // 현재 페이지 그룹
		    int startPage = currentGroup * pageGroupSize + 1;  // 시작 페이지 번호
		    int endPage = Math.min(startPage + pageGroupSize - 1, totalPages);  // 마지막 페이지 번호

		    // 페이징 정보 추가
		    model.addAttribute("kitchens", kithchens); // 수정된 부분
		    model.addAttribute("currentPage", page);
		    model.addAttribute("totalPages", totalPages);
		    model.addAttribute("startPage", startPage);
		    model.addAttribute("endPage", endPage);
		    model.addAttribute("hasPrevPage", currentGroup > 0);
		    model.addAttribute("hasNextPage", endPage < totalPages);
		    model.addAttribute("size", size);  // size 값을 모델에 추가하여 템플릿으로 전달

		    return "mypage/kitchen";  // registration.html로 이동
		}
		
		// 제품 목록 페이지
		@GetMapping("/mypage/built_in")
		public String mybuilt_in(Model model, 
				                 @RequestParam(value = "page", defaultValue = "1") Integer page,
				                 @RequestParam(value = "size", defaultValue = "10") Integer size,
				                 @RequestParam(value = "category", required = false) String category) {
			// 기본값을 명시적으로 확인 (null인 경우 대비)
			if (size == null)
				size = 10;

			List<Built_inDto> built_ins;
			if (category != null && !category.isEmpty()) {
				built_ins = built_inservice.getAllBuilt_ins();
			} else {
				// 카테고리가 없으면 전체 데이터
				built_ins = built_inservice.getBuilt_insWithPaging(page, size);
			}

			int totalBuilt_ins = built_inservice.getTotalBuilt_inCount();
			int totalPages = (int) Math.ceil((double) totalBuilt_ins / size);

			// 페이지 그룹 계산
			int pageGroupSize = 10; // 한 페이지 그룹에 몇 개의 페이지를 보여줄지 설정
			int currentGroup = (page - 1) / pageGroupSize; // 현재 페이지 그룹
			int startPage = currentGroup * pageGroupSize + 1; // 시작 페이지 번호
			int endPage = Math.min(startPage + pageGroupSize - 1, totalPages); // 마지막 페이지 번호

			// 페이징 정보 추가
			model.addAttribute("built_ins", built_ins); // 수정된 부분
			model.addAttribute("currentPage", page);
			model.addAttribute("totalPages", totalPages);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("hasPrevPage", currentGroup > 0);
			model.addAttribute("hasNextPage", endPage < totalPages);
			model.addAttribute("size", size); // size 값을 모델에 추가하여 템플릿으로 전달

			return "mypage/built_in";
		}
		
		// 제품 목록 페이지
		@GetMapping("/mypage/door")
		public String mydoor(Model model, 
				             @RequestParam(value = "page", defaultValue = "1") Integer page,
				             @RequestParam(value = "size", defaultValue = "10") Integer size,
				             @RequestParam(value = "category", required = false) String category) {
			// 기본값을 명시적으로 확인 (null인 경우 대비)
			if (size == null)
				size = 10;

			List<DoorDto> doors;
			if (category != null && !category.isEmpty()) {
				doors = doorservice.getAllDoors();
			} else {
				// 카테고리가 없으면 전체 데이터
				doors = doorservice.getDoorsWithPaging(page, size);
			}

			int totalDoors = doorservice.getTotalDoorCount();
			int totalPages = (int) Math.ceil((double) totalDoors / size);

			// 페이지 그룹 계산
			int pageGroupSize = 10; // 한 페이지 그룹에 몇 개의 페이지를 보여줄지 설정
			int currentGroup = (page - 1) / pageGroupSize; // 현재 페이지 그룹
			int startPage = currentGroup * pageGroupSize + 1; // 시작 페이지 번호
			int endPage = Math.min(startPage + pageGroupSize - 1, totalPages); // 마지막 페이지 번호

			// 페이징 정보 추가
			model.addAttribute("doors", doors); // 수정된 부분
			model.addAttribute("currentPage", page);
			model.addAttribute("totalPages", totalPages);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("hasPrevPage", currentGroup > 0);
			model.addAttribute("hasNextPage", endPage < totalPages);
			model.addAttribute("size", size); // size 값을 모델에 추가하여 템플릿으로 전달

			return "mypage/door";
		}
		
		// 제품 목록 페이지
		@GetMapping("/mypage/innergate")
		public String myinnergate(Model model, 
				             @RequestParam(value = "page", defaultValue = "1") Integer page,
				             @RequestParam(value = "size", defaultValue = "10") Integer size,
				             @RequestParam(value = "category", required = false) String category) {
			// 기본값을 명시적으로 확인 (null인 경우 대비)
			if (size == null)
				size = 10;

			List<InnergateDto> innergates;
			if (category != null && !category.isEmpty()) {
				innergates = innergateservice.getAllInnergates();
			} else {
				// 카테고리가 없으면 전체 데이터
				innergates = innergateservice.getInnergatesWithPaging(page, size);
			}

			int totalInnergates = innergateservice.getTotalInnergateCount();
			int totalPages = (int) Math.ceil((double) totalInnergates / size);

			// 페이지 그룹 계산
			int pageGroupSize = 10; // 한 페이지 그룹에 몇 개의 페이지를 보여줄지 설정
			int currentGroup = (page - 1) / pageGroupSize; // 현재 페이지 그룹
			int startPage = currentGroup * pageGroupSize + 1; // 시작 페이지 번호
			int endPage = Math.min(startPage + pageGroupSize - 1, totalPages); // 마지막 페이지 번호

			// 페이징 정보 추가
			model.addAttribute("innergates", innergates); // 수정된 부분
			model.addAttribute("currentPage", page);
			model.addAttribute("totalPages", totalPages);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("hasPrevPage", currentGroup > 0);
			model.addAttribute("hasNextPage", endPage < totalPages);
			model.addAttribute("size", size); // size 값을 모델에 추가하여 템플릿으로 전달

			return "mypage/innergate";
		}

		// 제품 목록 페이지
		@GetMapping("/mypage/bath")
		public String mybath(Model model, 
				             @RequestParam(value = "page", defaultValue = "1") Integer page,
				             @RequestParam(value = "size", defaultValue = "10") Integer size,
				             @RequestParam(value = "category", required = false) String category) {
			// 기본값을 명시적으로 확인 (null인 경우 대비)
			if (size == null)
				size = 10;

			List<BathDto> baths;
			if (category != null && !category.isEmpty()) {
				baths = bathservice.getAllBaths();
			} else {
				// 카테고리가 없으면 전체 데이터
				baths = bathservice.getBathsWithPaging(page, size);
			}

			int totalBaths = bathservice.getTotalBathCount();
			int totalPages = (int) Math.ceil((double) totalBaths / size);

			// 페이지 그룹 계산
			int pageGroupSize = 10; // 한 페이지 그룹에 몇 개의 페이지를 보여줄지 설정
			int currentGroup = (page - 1) / pageGroupSize; // 현재 페이지 그룹
			int startPage = currentGroup * pageGroupSize + 1; // 시작 페이지 번호
			int endPage = Math.min(startPage + pageGroupSize - 1, totalPages); // 마지막 페이지 번호

			// 페이징 정보 추가
			model.addAttribute("baths", baths); // 수정된 부분
			model.addAttribute("currentPage", page);
			model.addAttribute("totalPages", totalPages);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("hasPrevPage", currentGroup > 0);
			model.addAttribute("hasNextPage", endPage < totalPages);
			model.addAttribute("size", size); // size 값을 모델에 추가하여 템플릿으로 전달

			return "mypage/bath";
		}

		// 제품 목록 페이지
		@GetMapping("/mypage/tile")
		public String mytile(Model model, 
				             @RequestParam(value = "page", defaultValue = "1") Integer page,
				             @RequestParam(value = "size", defaultValue = "10") Integer size,
				             @RequestParam(value = "category", required = false) String category) {
			// 기본값을 명시적으로 확인 (null인 경우 대비)
			if (size == null)
				size = 10;

			List<TileDto> tiles;
			if (category != null && !category.isEmpty()) {
				tiles = tileservice.getAllTiles();
			} else {
				// 카테고리가 없으면 전체 데이터
				tiles = tileservice.getTilesWithPaging(page, size);
			}

			int totalTiles = tileservice.getTotalTileCount();
			int totalPages = (int) Math.ceil((double) totalTiles / size);

			// 페이지 그룹 계산
			int pageGroupSize = 10; // 한 페이지 그룹에 몇 개의 페이지를 보여줄지 설정
			int currentGroup = (page - 1) / pageGroupSize; // 현재 페이지 그룹
			int startPage = currentGroup * pageGroupSize + 1; // 시작 페이지 번호
			int endPage = Math.min(startPage + pageGroupSize - 1, totalPages); // 마지막 페이지 번호

			// 페이징 정보 추가
			model.addAttribute("tiles", tiles); // 수정된 부분
			model.addAttribute("currentPage", page);
			model.addAttribute("totalPages", totalPages);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("hasPrevPage", currentGroup > 0);
			model.addAttribute("hasNextPage", endPage < totalPages);
			model.addAttribute("size", size); // size 값을 모델에 추가하여 템플릿으로 전달

			return "mypage/tile";
		}

		// 제품 목록 페이지
		@GetMapping("/mypage/window")
		public String mywindow(Model model, 
				             @RequestParam(value = "page", defaultValue = "1") Integer page,
				             @RequestParam(value = "size", defaultValue = "10") Integer size,
				             @RequestParam(value = "category", required = false) String category) {
			// 기본값을 명시적으로 확인 (null인 경우 대비)
			if (size == null)
				size = 10;

			List<WindowDto> windows;
			if (category != null && !category.isEmpty()) {
				windows = windowservice.getAllWindows();
			} else {
				// 카테고리가 없으면 전체 데이터
				windows = windowservice.getWindowsWithPaging(page, size);
			}

			int totalWindows = windowservice.getTotalWindowCount();
			int totalPages = (int) Math.ceil((double) totalWindows / size);

			// 페이지 그룹 계산
			int pageGroupSize = 10; // 한 페이지 그룹에 몇 개의 페이지를 보여줄지 설정
			int currentGroup = (page - 1) / pageGroupSize; // 현재 페이지 그룹
			int startPage = currentGroup * pageGroupSize + 1; // 시작 페이지 번호
			int endPage = Math.min(startPage + pageGroupSize - 1, totalPages); // 마지막 페이지 번호

			// 페이징 정보 추가
			model.addAttribute("windows", windows); // 수정된 부분
			model.addAttribute("currentPage", page);
			model.addAttribute("totalPages", totalPages);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("hasPrevPage", currentGroup > 0);
			model.addAttribute("hasNextPage", endPage < totalPages);
			model.addAttribute("size", size); // size 값을 모델에 추가하여 템플릿으로 전달

			return "mypage/window";
		}

		// 제품 목록 페이지
		@GetMapping("/mypage/moulding")
		public String mymoulding(Model model, 
				             @RequestParam(value = "page", defaultValue = "1") Integer page,
				             @RequestParam(value = "size", defaultValue = "10") Integer size,
				             @RequestParam(value = "category", required = false) String category) {
			// 기본값을 명시적으로 확인 (null인 경우 대비)
			if (size == null)
				size = 10;

			List<MouldingDto> mouldings;
			if (category != null && !category.isEmpty()) {
				mouldings = mouldingservice.getAllMouldings();
			} else {
				// 카테고리가 없으면 전체 데이터
				mouldings = mouldingservice.getMouldingsWithPaging(page, size);
			}

			int totalMouldings = mouldingservice.getTotalMouldingCount();
			int totalPages = (int) Math.ceil((double) totalMouldings / size);

			// 페이지 그룹 계산
			int pageGroupSize = 10; // 한 페이지 그룹에 몇 개의 페이지를 보여줄지 설정
			int currentGroup = (page - 1) / pageGroupSize; // 현재 페이지 그룹
			int startPage = currentGroup * pageGroupSize + 1; // 시작 페이지 번호
			int endPage = Math.min(startPage + pageGroupSize - 1, totalPages); // 마지막 페이지 번호

			// 페이징 정보 추가
			model.addAttribute("mouldings", mouldings); // 수정된 부분
			model.addAttribute("currentPage", page);
			model.addAttribute("totalPages", totalPages);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("hasPrevPage", currentGroup > 0);
			model.addAttribute("hasNextPage", endPage < totalPages);
			model.addAttribute("size", size); // size 값을 모델에 추가하여 템플릿으로 전달

			return "mypage/moulding";
		}

		// 제품 목록 페이지
		@GetMapping("/mypage/wall")
		public String mywall(Model model, 
				             @RequestParam(value = "page", defaultValue = "1") Integer page,
				             @RequestParam(value = "size", defaultValue = "10") Integer size,
				             @RequestParam(value = "category", required = false) String category) {
			// 기본값을 명시적으로 확인 (null인 경우 대비)
			if (size == null)
				size = 10;

			List<WallDto> walls;
			if (category != null && !category.isEmpty()) {
				walls = wallservice.getAllWalls();
			} else {
				// 카테고리가 없으면 전체 데이터
				walls = wallservice.getWallsWithPaging(page, size);
			}

			int totalWalls = wallservice.getTotalWallCount();
			int totalPages = (int) Math.ceil((double) totalWalls / size);

			// 페이지 그룹 계산
			int pageGroupSize = 10; // 한 페이지 그룹에 몇 개의 페이지를 보여줄지 설정
			int currentGroup = (page - 1) / pageGroupSize; // 현재 페이지 그룹
			int startPage = currentGroup * pageGroupSize + 1; // 시작 페이지 번호
			int endPage = Math.min(startPage + pageGroupSize - 1, totalPages); // 마지막 페이지 번호

			// 페이징 정보 추가
			model.addAttribute("walls", walls); // 수정된 부분
			model.addAttribute("currentPage", page);
			model.addAttribute("totalPages", totalPages);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("hasPrevPage", currentGroup > 0);
			model.addAttribute("hasNextPage", endPage < totalPages);
			model.addAttribute("size", size); // size 값을 모델에 추가하여 템플릿으로 전달

			return "mypage/wall";
		}

		// 제품 목록 페이지
		@GetMapping("/mypage/film")
		public String myfilm(Model model, 
				             @RequestParam(value = "page", defaultValue = "1") Integer page,
				             @RequestParam(value = "size", defaultValue = "10") Integer size,
				             @RequestParam(value = "category", required = false) String category) {
			// 기본값을 명시적으로 확인 (null인 경우 대비)
			if (size == null)
				size = 10;

			List<FilmDto> films;
			if (category != null && !category.isEmpty()) {
				films = filmservice.getAllFilms();
			} else {
				// 카테고리가 없으면 전체 데이터
				films = filmservice.getFilmsWithPaging(page, size);
			}

			int totalFilms = filmservice.getTotalFilmCount();
			int totalPages = (int) Math.ceil((double) totalFilms / size);

			// 페이지 그룹 계산
			int pageGroupSize = 10; // 한 페이지 그룹에 몇 개의 페이지를 보여줄지 설정
			int currentGroup = (page - 1) / pageGroupSize; // 현재 페이지 그룹
			int startPage = currentGroup * pageGroupSize + 1; // 시작 페이지 번호
			int endPage = Math.min(startPage + pageGroupSize - 1, totalPages); // 마지막 페이지 번호

			// 페이징 정보 추가
			model.addAttribute("films", films); // 수정된 부분
			model.addAttribute("currentPage", page);
			model.addAttribute("totalPages", totalPages);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("hasPrevPage", currentGroup > 0);
			model.addAttribute("hasNextPage", endPage < totalPages);
			model.addAttribute("size", size); // size 값을 모델에 추가하여 템플릿으로 전달

			return "mypage/film";
		}
		
	// 제품 추가
	@PostMapping("/mypage/registration/add")
	public String addItem(Model model, ItemDto itemdto,
			@RequestParam(value = "file", required = false) MultipartFile[] files) {
		// 경로를 외부 설정에서 불러오거나 하드코딩된 경로를 사용
		final String path = "C:\\Users\\admin\\git\\E-auraystudio\\AurayStudio\\src\\main\\resources\\static\\img";
		System.out.println("length=" + files.length);
		// Paint 정보 추가
		itemservice.addItem(itemdto);

		// 파일 업로드 처리
		if (files != null && files.length > 0) {
			for (MultipartFile file : files) {
				try {
					ItemimgDto imgdto = new ItemimgDto();
					String org_file_name = file.getOriginalFilename();
					String file_name = UUID.randomUUID().toString().substring(0, 8) + "_" + org_file_name;

					// ImgmngDto에 정보 설정
					imgdto.setFile_path(path);
					imgdto.setOrg_file_name(org_file_name);
					imgdto.setFile_name(file_name);
					imgdto.setY_no(itemdto.getY_no());

					System.out.println(path + File.separator + file_name);
					// 파일을 실제 저장 위치에 저장
					File destinationFile = new File(path + File.separator + file_name);
					file.transferTo(destinationFile);

					// 이미지 정보 저장
					itemservice.uploadImg(imgdto);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// Paint 목록을 모델에 추가
		List<ItemDto> list = itemservice.getItemList();
		model.addAttribute("list", list);

		return "redirect:/mypage/registration";
	}
	
//	  @GetMapping("/mypage/registration/downloadImg/{y_no}") public ResponseEntity<Resource>
//	  downloadImg(@PathVariable("y_no")String y_no) { 
//		  try { 
//			  ItemimgDto dto = itemservice.downloadImg(y_no); 
//			  
//			  // dto가 null인 경우 기본 이미지나 예외 처리
//			  if (dto == null) {
//		            return ResponseEntity.notFound().build();
//		        }
//			  
//			  Path filePath = Paths.get(dto.getFile_path()).resolve(dto.getFile_name()).normalize();
//			  Resource resource = new UrlResource(filePath.toUri()); 
//			  if(resource.exists()) { 
//				  String encodeFileName = URLEncoder.encode(dto.getOrg_file_name(),
//						  StandardCharsets.UTF_8.toString()); 
//				  String contentDisposition = "attachment; filename=\"" + encodeFileName + "\""; 
//				  
//				  return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
//						  .header(HttpHeaders.CONTENT_TYPE, "application/octet-stream").body(resource); 
//				  } 
//				  else { 
//					  return ResponseEntity.notFound().build(); 
//				  } 
//			  }
//			  catch(IOException e) { 
//				  e.printStackTrace(); 
//				  return ResponseEntity.notFound().build(); 
//		  } 
//	  }
	 
	@GetMapping("/mypage/registration/downloadImg/{y_no}")
	public ResponseEntity<Resource> downloadImg(@PathVariable("y_no") String y_no) { 
	    try { 
	        ItemimgDto dto = itemservice.downloadImg(y_no); 
	        
	        // dto가 null인 경우 처리
	        if (dto == null) {
	            return ResponseEntity.notFound().build();
	        }

	        Path filePath = Paths.get(dto.getFile_path()).resolve(dto.getFile_name()).normalize();
	        Resource resource = new UrlResource(filePath.toUri()); 

	        if (resource.exists()) { 
	            String encodeFileName = URLEncoder.encode(dto.getOrg_file_name(), StandardCharsets.UTF_8.toString()); 
	            String contentDisposition = "attachment; filename=\"" + encodeFileName + "\""; 
	            return ResponseEntity.ok()
	                                 .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
	                                 .header(HttpHeaders.CONTENT_TYPE, "application/octet-stream")
	                                 .body(resource); 
	        } else { 
	            return ResponseEntity.notFound().build(); 
	        }
	    } catch (IOException e) { 
	        e.printStackTrace(); 
	        return ResponseEntity.notFound().build(); 
	    } 
	}

    
//    // 제품 삭제
//    @GetMapping("/mypage/registration/delete/{y_no}")
//    public String deletePaint(@PathVariable("y_no") String y_no) {
//        itemservice.deleteItem(y_no);  // y_no로 삭제
//        return "redirect:/registration";
//    }
	
	@GetMapping("/mypage/registration/delete/{y_no}")
	public String deleteItem(@PathVariable("y_no") String y_no) {
	    itemservice.deleteItem(y_no);  // y_no로 삭제
	    itemservice.deleteImg(y_no);
	    return "redirect:/mypage/registration";  // 페이징 리스트로 돌아가기
	}

}
