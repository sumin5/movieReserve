package com.ezen.movie.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.movie.test.MenuDTO;
import com.ezen.movie.test.MenuService;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private MenuService menuService;
	
	@GetMapping("/")
	public ModelAndView main() {
		
		ModelAndView mav = new ModelAndView("/main/main");
		
		List<MenuDTO> menuList = menuService.menuList();
		System.err.println(menuList);
		
		mav.addObject("menuList",menuList);
		return mav;
		
	}
	

}
