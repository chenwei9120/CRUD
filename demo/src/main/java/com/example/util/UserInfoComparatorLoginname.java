package com.example.util;

import java.util.Comparator;

import com.example.model.UserInfo;

public class UserInfoComparatorLoginname implements Comparator<UserInfo> {

	@Override
	public int compare(UserInfo o1, UserInfo o2) {
		return o1.getLoginname().compareTo(o2.getLoginname());
	}

}
