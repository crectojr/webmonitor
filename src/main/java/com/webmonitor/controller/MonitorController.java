package com.webmonitor.controller;

import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webmonitor.model.UrlModel;
import com.webmonitor.model.WebModel;

@Controller
public class MonitorController {
	
	//test git commit only
	@RequestMapping("/")
	public ModelAndView homeController() {			
		
		 return new ModelAndView("index", "urlModel", new UrlModel());
	}
	
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute("urlModel")UrlModel urlModel, 
			ModelMap model) {

		final String uri = "http://localhost:8080/monitorweburl";

		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(urlModel);
			System.out.println(jsonInString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));		
		UrlModel result = restTemplate.postForObject(uri, urlModel, UrlModel.class);


		return new ModelAndView("webmonitorconfirmation", "urlModel",result);


	}
}
