package com.agecalculator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AgeController {
	
	@RequestMapping("/agecalc")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response)
	{
		String text = request.getParameter("age-calc");
		
		LocalDate l = LocalDate.parse(text);
		int m = Period.between(l, LocalDate.now()).getYears();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("result",m);
		return mv;
	}
}
