package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.FAQ;
import com.example.demo.model.FAQDTO;
import com.example.demo.repository.FAQRepository;
import com.example.demo.utitity.FAQConverter;

@Service
public class FAQServiceImpl implements FAQService{
   @Autowired
	private FAQRepository faqRepository;
   @Autowired
   FAQConverter faqconverter;
	@Override
	public FAQDTO createFAQ(FAQ faq) {
		// TODO Auto-generated method stub
		FAQ f= faqRepository.save(faq);
		return faqconverter.convertToFAQDTO(f);
	}

	@Override
	public List<FAQDTO> getAllFAQInfo() {
		// TODO Auto-generated method stub
		List<FAQ> faq= faqRepository.findAll();
		List<FAQDTO> dtos= new ArrayList<>();
		for(FAQ f:faq)
		{
			dtos.add(faqconverter.convertToFAQDTO(f));
		}
		
		
		return dtos;
	}

	@Override
	public FAQDTO getFAQById(int id) {
		// TODO Auto-generated method stub
		FAQ fa= faqRepository.findById(id).get();
		return faqconverter.convertToFAQDTO(fa);
		
	}
	
	@Override
	public String deleteFAQById(int id) {
		// TODO Auto-generated method stub
		faqRepository.deleteById(id);
		return "Enquiry deleted.";
	}

	@Override
	public FAQDTO updateFAQ(int id, FAQ faq) {
		// TODO Auto-generated method stub
		
		FAQ e1 = faqRepository.findById(id).get();
		e1.setEName(faq.getEName());
		e1.setEMobNo(faq.getEMobNo());
		e1.setEMsg(faq.getEMsg());
		e1.setCustomer(faq.getCustomer());
		e1.setDeveloper(faq.getDeveloper());
		FAQ f1= faqRepository.save(e1);
		return faqconverter.convertToFAQDTO(f1);
	}
	

}
