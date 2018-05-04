package com.example.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

import com.example.model.UserInfo;

public class UserInfoList {

	static final CopyOnWriteArrayList<UserInfo> listUserInfo = new CopyOnWriteArrayList<UserInfo>();
	static AtomicLong maxId = new AtomicLong();
	static Object lock = new Object();
	static {
		synchronized (lock) {
			listUserInfo.add(new UserInfo(1, "andy", "", "Andy"));
			listUserInfo.add(new UserInfo(2, "carl", "", "Carl"));
			listUserInfo.add(new UserInfo(3, "bruce", "", "Bruce"));
			listUserInfo.add(new UserInfo(4, "dolly", "", "Dolly"));
			maxId.set(4);
		}
	}

	public CopyOnWriteArrayList<UserInfo> findAll() {
		return listUserInfo;
	}

	public List<UserInfo> query(String key, Object value) {
		try
		{
			if(value == null || "\"\"".equals(value))
			{
				listUserInfo.sort(key.equals("id") ? new UserInfoComparatorId() : new UserInfoComparatorLoginname());
				return listUserInfo;
			} 
			ArrayList<UserInfo> list = new ArrayList<UserInfo>();
			for(UserInfo userInfo : listUserInfo)
			{
				Object objValue = GetObjectValueByKey(userInfo, key);
				if(value.equals(objValue.toString()))
					list.add(userInfo);
			}
			list.sort(key.equals("id") ? new UserInfoComparatorId() : new UserInfoComparatorLoginname());
			return list;
		}
		catch(Exception ex)
		{
			return null;
		}
	}

	public Object GetObjectValueByKey(UserInfo userInfo, String key)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Class<?> cls = userInfo.getClass();
		Field field = cls.getDeclaredField(key);
		field.setAccessible(true);
		return field.get(userInfo);
	}

	public boolean delete(long id) {
		UserInfo user = getUserById(id);
		if (user != null) {
			listUserInfo.remove(listUserInfo.indexOf(user));
		}
		return true;
	}

	public boolean insert(UserInfo userInfo) throws Exception {
		userInfo.setId(maxId.incrementAndGet());
		if (listUserInfo.contains(getUserByLoginname(userInfo.getLoginname())))
			throw new Exception("the user with loginname = " + userInfo.getLoginname() + " has existed");
		userInfo.setPassword(Encrypt.getSha1(userInfo.getPassword()));
		boolean result = listUserInfo.add(userInfo);
		return result;
	}

	public boolean update(long id, UserInfo userInfo) {
		UserInfo user = getUserById(id);
		if (user != null) {
			int index = listUserInfo.indexOf(user);
			listUserInfo.set(index, userInfo);
			return true;
		} else
			return false;
	}

	UserInfo getUserById(long id) {
		for (UserInfo userInfo : listUserInfo) {
			if (userInfo.getId() == id)
				return userInfo;
		}
		return null;
	}

	UserInfo getUserByLoginname(String loginname) {
		ArrayList<UserInfo> listResult = new ArrayList<UserInfo>();
		for (UserInfo userInfo : listUserInfo) {
			if (userInfo.getLoginname() == loginname) {
				listResult.add(userInfo);
				return userInfo;
			}
		}
		return null;
	}
}
