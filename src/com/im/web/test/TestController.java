package com.im.web.test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	@Autowired
	private TestService service;
	
	@RequestMapping("/save.do")
	public String testSave(){
		service.save();
		return "save";
	}
	
	@RequestMapping("testRest")
	public String testRestGetMethod(){
		System.out.println("testRestGetMethod ....");
		return "success";
	}
	@RequestMapping(value="testRest",method=RequestMethod.POST)
	public String testRestPostMethod(){
		System.out.println("testRestPostMethod post invoke");
		return "success";
	}
	@RequestMapping(value="testRest/id",method=RequestMethod.PUT)
	public String testRestPut(@PathVariable("id")int id){
		System.out.println("testRestPostMethod post invoke");
		return "success";
	}
	public static void main(String[] args) {
		Map<String, Object> m = new HashMap<String, Object>();
		Hashtable<String, Object> m2 = new Hashtable<String, Object>();
		m.put("name", "binge");
		System.out.println(m.size());
		int hash = "name".hashCode();
		System.out.println(hash& 0x7FFFFFFF);
		ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>();
	}
}
