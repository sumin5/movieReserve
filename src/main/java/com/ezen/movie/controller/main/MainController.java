package com.ezen.movie.controller.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.movie.comm.AbstractController;
import com.ezen.movie.config.EmailService;
import com.ezen.movie.config.EmailServiceImpl;
import com.ezen.movie.service.main.MainDTO;
import com.ezen.movie.service.main.MainService;
import com.ezen.movie.service.store.StoreDTO;
import com.ezen.movie.service.store.StoreService;

@Controller
@RequestMapping(value = {"/main","/" } )
public class MainController extends AbstractController{
	
	@Autowired
	private MainService menuService;
	
	@GetMapping("/")
	public ModelAndView main() {
		
		ModelAndView mav = new ModelAndView("/main/main");
		
		List<MainDTO> menuList = menuService.menuList();
		System.err.println(menuList);
		
		mav.addObject("menuList",menuList);
		return mav;
		
	}

	//스토어 메인화면 이동
	@GetMapping("/storeMain")
	public ModelAndView storeMain() {
		ModelAndView mav = new ModelAndView("/main/storeMain");
		return mav;
	}

}
