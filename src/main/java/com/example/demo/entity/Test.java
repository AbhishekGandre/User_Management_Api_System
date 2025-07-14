package com.example.demo.entity;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;

public class Test {

	public static void main(String[] args) throws IOException, InterruptedException {
		Date date = new Date();

		System.out.println(date.toString());
		
		String url ="https://icanhazdadjoke.com";
		
		HttpClient client = HttpClient.newBuilder().build();
		
		HttpRequest request = HttpRequest.newBuilder().header("Accept", "application/json")
				.uri(java.net.URI.create(url))
				.GET()
				.build();
		
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		System.out.println(response.headers());
		
		
		
	}

}
