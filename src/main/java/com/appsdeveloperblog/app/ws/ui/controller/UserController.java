package com.appsdeveloperblog.app.ws.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.app.ws.exception.UserServiceException;
import com.appsdeveloperblog.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;
import com.appsdeveloperblog.app.ws.userservice.UserService;


@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {
	
	Map<String,UserRest> users;
	
	@Autowired
	UserService userService;

	@PostMapping( produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, 
			      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
			    )
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {

		UserRest returnValue = userService.createUser(userDetails);
		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}

	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			               @RequestParam(value = "limit", defaultValue = "50") int limit,
			               @RequestParam(value = "sort", required = false) String sort
			              ) {

		return "getUser() was called page: " + page + " limit: " + limit + " sort: " + sort;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		/*
		 * UserRest returnValue = new UserRest(); returnValue.setFirstName("Amit");
		 * returnValue.setLastName("Bhargava"); returnValue.setEmail("Test@test.com");
		 */
		
	//	String firstName = null;
	//	int length = firstName.length();
		
		if(true) throw new UserServiceException("A user service Exception is thrown");

		if (users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@PutMapping(path = "/{userId}",produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, 
		      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
	)
	public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails) 
	{
		UserRest storedUserDetails = users.get(userId);
		storedUserDetails.setFirstName(userDetails.getFirstName());
		storedUserDetails.setLastName(userDetails.getLastName());
		
		users.put(userId, storedUserDetails);
		
		return  storedUserDetails;
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity deleteUser(@PathVariable String id) 
	{
		users.remove(id);
		return ResponseEntity.noContent().build();
	}
}
