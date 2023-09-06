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

import com.ezen.movie.config.EmailService;
import com.ezen.movie.config.EmailServiceImpl;
import com.ezen.movie.service.main.MainDTO;
import com.ezen.movie.service.main.MainService;
import com.ezen.movie.service.store.StoreDTO;
import com.ezen.movie.service.store.StoreService;

@Controller
@RequestMapping(value = {"/main","/" } )
public class MainController {
	
	@Autowired
	private MainService menuService;
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/")
	public ModelAndView main() {
		
		ModelAndView mav = new ModelAndView("/main/main");
		
		List<MainDTO> menuList = menuService.menuList();
		System.err.println(menuList);
		
		mav.addObject("menuList",menuList);
		return mav;
		
	}
	
	@GetMapping("/loginForm")
	public ModelAndView loginForm() {
		
		ModelAndView mav = new ModelAndView("/main/member/login");
		return mav;
		
	}
	
	@GetMapping("/joinForm")
	public ModelAndView joinForm() {
		
		ModelAndView mav = new ModelAndView("/main/member/join");
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
	
	//메일인증로직
	@PostMapping("/mailAuth")
	@ResponseBody
    public String mailConfirm(@RequestParam String email) throws Exception {
		
        String code = emailService.sendSimpleMessage(email);
        return code;
    }

}
