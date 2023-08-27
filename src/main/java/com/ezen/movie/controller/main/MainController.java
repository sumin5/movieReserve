package com.ezen.movie.controller.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.movie.service.main.MainDTO;
import com.ezen.movie.service.main.MainService;
import com.ezen.movie.service.store.StoreDTO;
import com.ezen.movie.service.store.StoreService;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private MainService menuService;
	
	@Autowired
	private StoreService storeService;
	
	@GetMapping("/")
	public ModelAndView main() {
		
		ModelAndView mav = new ModelAndView("/main/main2");
		
		List<MainDTO> menuList = menuService.menuList();
		System.err.println(menuList);
		
		mav.addObject("menuList",menuList);
		return mav;
		
	}
	
	@GetMapping("/storeMain")
	public ModelAndView storeMain() {
		ModelAndView mav = new ModelAndView("/main/storeMain");
		
		List<StoreDTO> storeList = storeService.storeList();
		System.err.println(storeList);
		
		mav.addObject("storeList", storeList);
		return mav;
	}

}
