package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.FAQ;
import com.example.demo.model.FAQDTO;
import com.example.demo.service.FAQService;
import com.example.demo.utitity.FAQConverter;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/faq")
@Validated
public class FAQController {
	@Autowired
	private FAQService faqService;
	
	@Autowired
	FAQConverter faqconverter;
	
	@PostMapping("/createFAQ")
	ResponseEntity<FAQDTO> createFAQ(@Valid @RequestBody FAQDTO faqDto) {
		final FAQ faq=faqconverter.convertToFAQEntity(faqDto);
		return new ResponseEntity<FAQDTO>(faqService.createFAQ(faq),HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllFAQs")
	public List<FAQDTO> getAllFAQInfo(){
		return faqService.getAllFAQInfo();
	}
	
	@GetMapping("/getFAQById/{eid}")
	public FAQDTO getFAQById(@PathVariable("eid") int id) {
		return faqService.getFAQById(id);
	}
	
	@DeleteMapping("/deleteFAQById/{eid}")
	public String deleteFAQById(@PathVariable("eid") int id)
	{
		faqService.deleteFAQById(id);
		return "FAQ deleted.";
		
	}
	
	@PutMapping("/updateFAQ/{eid}")
	public FAQDTO updateFAQ(@PathVariable("eid") int id, @RequestBody FAQ faq) {
		return faqService.updateFAQ(id, faq);
		
	}


}
