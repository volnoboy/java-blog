package com.volnoboy.jb.annotation;

import com.volnoboy.jb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by volnoboy on 12/16/14.
 */
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

	@Autowired
	private UserRepository userRepository;


	@Override
	public void initialize(UniqueUsername uniqueUsername) {

	}

	@Override
	public boolean isValid(String userName, ConstraintValidatorContext constraintValidatorContext) {
		if (userRepository == null) {
			return true;
		}
		return userRepository.findByName(userName) == null;
	}
}
