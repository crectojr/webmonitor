package com.webmonitor.restcontroller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webmonitor.model.UrlModel;
import com.webmonitor.model.WebModel;


@RestController
public class WebMonitorUrl {
	
	
	private static final String AVAILABLE = "Available";
	private static final String UNAVAILABLE = "Unavailable";

	@RequestMapping("monitorweburl")
	public UrlModel monitorWebUrl(@RequestBody UrlModel urlModel, @RequestHeader(value="testheader") String testheader,
			@RequestHeader(value="Accept") String accept,
			@RequestHeader(value="Accept-Language") String acceptLanguage,
			@RequestHeader(value="Content-Type") String contentType,
			@RequestHeader(value="User-Agent", defaultValue="foo") String userAgent) {


		HttpURLConnection connection;
		for (WebModel webModel:urlModel.getWebModel()) {
			
			try {
				connection = (HttpURLConnection) new URL(webModel.getUrl()).openConnection();
				connection.setRequestMethod("GET");
				connection.setReadTimeout(15*1000);
				int responseCode = connection.getResponseCode();
				webModel.setStatus(AVAILABLE);
				webModel.setAvailable(responseCode==200);
				
			} catch (MalformedURLException e) {
				webModel.setAvailable(false);
				webModel.setStatus(UNAVAILABLE);
				webModel.setError(e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				webModel.setAvailable(false);
				webModel.setStatus(UNAVAILABLE);
				webModel.setError(e.getMessage());
				e.printStackTrace();
			}
		}	

		return urlModel;

	} 
}
