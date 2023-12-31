package com.ezen.movie.controller.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.movie.comm.AbstractController;
import com.ezen.movie.service.main.MainDTO;
import com.ezen.movie.service.main.MainService;
import com.ezen.movie.service.store.StoreDTO;
import com.ezen.movie.service.store.StoreService;

@Controller
@RequestMapping("/store")
public class StoreController extends AbstractController{
	
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
	
	//팝콘 & 음료 페이지 이동
	@GetMapping("/popAndDrinkPage")
	public ModelAndView popAndDrinkPage() {
		ModelAndView mav = new ModelAndView();
		
		List<StoreDTO> popdrinkList = storeService.popdrinkList();
		System.out.println(popdrinkList);
		
		mav.addObject("popdrinkList", popdrinkList);
		return mav;
	}
	
	//스낵 페이지 이동
	@GetMapping("/snackPage")
	public ModelAndView snackPage() {
		ModelAndView mav = new ModelAndView("/store/snackPage");
		return mav;
	}
	
	//티켓 & 기프트카드 페이지 이동
	@GetMapping("/ticketAndCardPage")
	public ModelAndView ticketAndCardPage() {
		ModelAndView mav = new ModelAndView("/store/ticketAndCardPage");
		return mav;
	}

}