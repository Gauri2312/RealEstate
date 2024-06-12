package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entities.FAQ;
import com.example.demo.service.FAQService;

@RestController
@RequestMapping("/faq")
public class FAQController {
	@Autowired
	private FAQService faqService;
	
	@PostMapping("/add")
	public String add(@RequestBody FAQ faq) {
		faqService.saveFAQInfo(faq);
		return "FAQ Info Added.";
	}
	
	@GetMapping("/getAll")
	public List<FAQ> getAllFAQInfo(){
		return faqService.getAllFAQInfo();
	}
	
	@GetMapping("/getFAQById/{eid}")
	public FAQ getFAQById(@PathVariable("eid") int id) {
		return faqService.getFAQById(id);
	}
	
	@DeleteMapping("/deleteFAQById/{eid}")
	public String deleteFAQById(@PathVariable("eid") int id)
	{
		faqService.deleteFAQById(id);
		return "FAQ deleted.";
		
	}
	
	@PutMapping("/updateFAQ/{eid}")
	public FAQ updateFAQ(@PathVariable("eid") int id, @RequestBody FAQ faq) {
		return faqService.updateFAQ(id, faq);
		
	}


}
