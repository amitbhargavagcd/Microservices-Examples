package com.appsdeveloperblog.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.app.ws.shared.Utils;
import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;
import com.appsdeveloperblog.app.ws.userservice.UserService;

@Service
public class UserServiceImpl implements UserService {

	Map<String, UserRest> users;
	Utils util;

	public UserServiceImpl() {
	}

	@Autowired
	public UserServiceImpl(Utils util) {

		this.util = util;
	}

	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {

		UserRest returnValue = new UserRest();
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		returnValue.setEmail(userDetails.getEmail());

		String userId = util.generateUserId();
		returnValue.setUserId(userId);
		if (users == null)
			users = new HashMap<String, UserRest>();

		users.put(userId, returnValue);

		return returnValue;
	}

}
