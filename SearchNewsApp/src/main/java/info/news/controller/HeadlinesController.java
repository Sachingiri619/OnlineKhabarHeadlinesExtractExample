package info.news.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import info.news.model.Headlines;
import info.news.service.HeadlinesService;

@Controller
public class HeadlinesController {
	
	@Autowired
	HeadlinesService headlinesService;
	
	@RequestMapping(value = "/search", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getList(Model model, @RequestParam("enterText")String enterText) {
		
		
			
		List<Headlines> listOfHeadlines = headlinesService.getAllHeadlines(enterText);
		model.addAttribute("headlines", new Headlines());
		model.addAttribute("listOfHeadlines", listOfHeadlines);
		return "shownews";
		
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getHome() {
		
		
		
		return "shownews";
		}
	
	
	

}
