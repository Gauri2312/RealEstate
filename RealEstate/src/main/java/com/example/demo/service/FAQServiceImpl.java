package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.FAQ;
import com.example.demo.repository.FAQRepository;

@Service
public class FAQServiceImpl implements FAQService{
   @Autowired
	private FAQRepository faqRepository;
	@Override
	public FAQ saveFAQInfo(FAQ faq) {
		// TODO Auto-generated method stub
		return faqRepository.save(faq);
	}

	@Override
	public List<FAQ> getAllFAQInfo() {
		// TODO Auto-generated method stub
		return faqRepository.findAll();
	}

	@Override
	public FAQ getFAQById(int id) {
		// TODO Auto-generated method stub
		return faqRepository.findById(id).orElseThrow();
	}
	
	@Override
	public String deleteFAQById(int id) {
		// TODO Auto-generated method stub
		faqRepository.deleteById(id);
		return "Enquiry deleted.";
	}

	@Override
	public FAQ updateFAQ(int id, FAQ faq) {
		// TODO Auto-generated method stub
		
		FAQ e1 = faqRepository.findById(id).get();
		e1.setEName(faq.getEName());
		e1.setEMobNo(faq.getEMobNo());
		e1.setEMsg(faq.getEMsg());
		e1.setCustomer(faq.getCustomer());
		e1.setDeveloper(faq.getDeveloper());
		return faqRepository.save(e1);
	}
	

}
