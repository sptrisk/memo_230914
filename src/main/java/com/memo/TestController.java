package com.memo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.memo.post.mapper.PostMapper;


@Controller
public class TestController {
	
	@Autowired
	private PostMapper postMapper;
	
	
	
	@ResponseBody
	@GetMapping("/test1")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping("/test3")
	public String test3() {
		return "test/test";
	}
	
	@ResponseBody
	@GetMapping("/test4")
	public List<Map<String, Object>> test4() {
		return postMapper.selectPostList();
	}
}
