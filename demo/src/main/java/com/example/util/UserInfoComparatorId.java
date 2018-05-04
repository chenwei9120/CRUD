package com.example.util;

import java.util.Comparator;

import com.example.model.UserInfo;

public class UserInfoComparatorId implements Comparator<UserInfo> {

	@Override
	public int compare(UserInfo o1, UserInfo o2) {
		if(o1.getId() > o2.getId())
			return 1;
		else 
			return -1;
	}
}
