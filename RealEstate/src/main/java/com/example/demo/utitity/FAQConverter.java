package com.example.demo.utitity;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.demo.entities.FAQ;
import com.example.demo.model.FAQDTO;


@Component
public class FAQConverter {
	public FAQ convertToFAQEntity(FAQDTO faqDTO)
	{
		FAQ faq=new FAQ();
		if(faqDTO!=null)
		{
			BeanUtils.copyProperties(faqDTO, faq);
		}
		return faq;
	}
	
	//Convert Entity to DTO
	public FAQDTO convertToFAQDTO(FAQ  faq)
	{
		FAQDTO faqDTO=new FAQDTO();
		if(faq!=null)
		{
			BeanUtils.copyProperties(faq, faqDTO);
		}
		return faqDTO;
	}

}
