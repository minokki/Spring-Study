package com.fastcampus.ch2;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionCotroller {

	@ExceptionHandler(NullPointerException.class)
	public String catcher1(Exception ex , Model model) {
		model.addAttribute("ex",ex);
		return "error";
	}
	
	//핸들러를 사용함으로서 try catch문을 없앨수잇
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //상태코드 500번으로 변경
	//ExceptionHandler를 사용했을 경우  적절한 상태코드를 보여주기위해 @ResponseStatus로 상태코드를 변경 해주어야한다.(같이사용) 
	public String catcher2(Exception ex, Model model) {
		model.addAttribute("ex",ex);
		return "error";
	}
	
	@RequestMapping("/ex") 
	public String main() throws Exception{
			throw new Exception("예외가 발생합니다");		
	}
	@RequestMapping("/ex2") 
	public String main2() throws Exception{
	
			throw new NullPointerException("예외가 발생합니다");
		}
		
	}

