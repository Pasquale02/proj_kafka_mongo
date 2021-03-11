package com.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.domain.Post;

@Service
public class PostService {


	public Post postPost(String headerRequestId, Post bodyRequest) {

		Post post = new Post();
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = this.setHeaders(headerRequestId);
		HttpEntity<Post> entity = new HttpEntity<>(headers);
		
		try {
			ResponseEntity<Post> response = restTemplate.exchange("http://jsonplaceholder.typicode.com/posts",
					HttpMethod.POST, entity, Post.class);
			post = response.getBody();

		} catch (Exception e) {
			System.out.println("ecc");
		}

		return post;
	}

	private HttpHeaders setHeaders(String requester) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		headers.set("Content-type", "application/json");
		headers.set("requester", requester);
		headers.set("Accept-Charset", "utf-8");
		return headers;
	}
}
