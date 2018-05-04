package com.example.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserInfoDao;
import com.example.model.UserInfo;

@Service
public class UserInfoService {
	
	@Autowired
	UserInfoDao userInfoDao;
	
	public CopyOnWriteArrayList<UserInfo> findAll() {
		return userInfoDao.findAll();
	}
	
	public List<UserInfo> query(String key, Object value) {
		return userInfoDao.query(key, value);
	}

	public boolean delete(long id) {
		return userInfoDao.delete(id);
	}
	
	public boolean insert(UserInfo userInfo) throws Exception  {
		return userInfoDao.insert(userInfo);		
	}
	
	public boolean update(long id, UserInfo userInfo) {
		return userInfoDao.update(id, userInfo);
	}
}
