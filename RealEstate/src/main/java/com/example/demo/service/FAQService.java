package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.FAQ;
import com.example.demo.model.FAQDTO;

public interface FAQService {
	public FAQDTO createFAQ(FAQ faq);
	public List<FAQDTO> getAllFAQInfo();
	public FAQDTO getFAQById(int id);
	public String deleteFAQById(int id);
	public FAQDTO updateFAQ(int id, FAQ faq);

}
