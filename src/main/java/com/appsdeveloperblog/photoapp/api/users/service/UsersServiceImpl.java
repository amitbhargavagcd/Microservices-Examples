package com.appsdeveloperblog.photoapp.api.users.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.photoapp.api.users.data.UserEntity;
import com.appsdeveloperblog.photoapp.api.users.data.UsersRepository;
import com.appsdeveloperblog.photoapp.api.users.shared.UserDto;

@Service
public class UsersServiceImpl implements UsersService{

	UsersRepository userRepository;
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public UsersServiceImpl(UsersRepository userRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Override
	public UserDto createUser(UserDto userDetails) {
		 
		userDetails.setUserId(UUID.randomUUID().toString());
		userDetails.setEncrptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
	//	userEntity.setEncrptedPassword("TestEncryptedPassword");
		userRepository.save(userEntity);
		
		UserDto returnValue =  modelMapper.map(userEntity, UserDto.class);
		
		return returnValue;
	}

}
