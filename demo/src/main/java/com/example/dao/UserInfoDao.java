package com.example.dao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

import com.example.model.UserInfo;
import com.example.util.UserInfoList;

@Repository
public class UserInfoDao {

	static final UserInfoList userInfoList = new UserInfoList();
	
	public CopyOnWriteArrayList<UserInfo> findAll() {
		return userInfoList.findAll();
	}
	
	//public ArrayList<UserInfo> query(UserInfo userInfo, boolean isSortedById) {
	public List<UserInfo> query(String key, Object value) {
		return userInfoList.query(key, value);
	}

	public boolean delete(long id) {
		return userInfoList.delete(id);
	}
	
	public boolean insert(UserInfo userInfo) throws Exception  {
		return userInfoList.insert(userInfo);		
	}
	
	public boolean update(long id, UserInfo userInfo) {
		return userInfoList.update(id, userInfo);
	}
}
