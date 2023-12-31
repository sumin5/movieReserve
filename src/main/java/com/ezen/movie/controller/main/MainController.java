package com.ezen.movie.controller.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.movie.comm.AbstractController;
import com.ezen.movie.mapper.file.FileMapper;
import com.ezen.movie.service.file.FileDTO;

@Controller
@RequestMapping(value = {"/" } )
public class MainController extends AbstractController{
	
	@Autowired
	private FileMapper fileMapper;
	
	@GetMapping(value={"/","/main"})
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView("/main/main");
		
		FileDTO dto = new FileDTO();
		dto.setWildCard("movies");
		List<FileDTO> fileList = fileMapper.getListMain(dto);
		mav.addObject("fileList",fileList);
		return mav;
	}
	
	//스토어 메인화면 이동
	@GetMapping("/storeMain")
	public ModelAndView storeMain() {
		ModelAndView mav = new ModelAndView("/main/storeMain");
		return mav;
	}

}
