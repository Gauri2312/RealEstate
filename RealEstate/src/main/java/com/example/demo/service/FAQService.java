package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.FAQ;

public interface FAQService {
	public FAQ saveFAQInfo(FAQ faq);
	public List<FAQ> getAllFAQInfo();
	public FAQ getFAQById(int id);
	public String deleteFAQById(int id);
	public FAQ updateFAQ(int id, FAQ faq);

}
