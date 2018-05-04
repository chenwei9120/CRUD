package com.example.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.UserInfo;
import com.example.service.UserInfoService;

@RestController
public class UserInfoController {

	@Autowired
	UserInfoService userInfoService;
	
	@PostMapping("/findall")
	public CopyOnWriteArrayList<UserInfo> findAll() {
		return userInfoService.findAll();
	}
	
	@PostMapping("/del")
	public boolean delete(@RequestBody Map map) {
		long id = Long.parseLong(map.get("id").toString()) ;
		return userInfoService.delete(id);
	}
	
	@GetMapping("/query/{key}/{value}")
	public List<UserInfo> query(@PathVariable("key") String key, @PathVariable("value") Object value) {		
		return userInfoService.query(key, value);
	}
	
	@PostMapping("/update")
	public boolean update(@RequestBody UserInfo user) {
		return userInfoService.update(user.getId(), user);
	}

	@PostMapping("/create")
	public boolean Insert(@RequestBody UserInfo userInfo) {
		try {
			return userInfoService.insert(userInfo);
		} catch (Exception e) {
			return false;
		}
	}
}
