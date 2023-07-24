package com.examly.springapp.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.repository.UserRepository;
import com.examly.springapp.model.UserModel;
import com.examly.springapp.tempmodel.LoginModel;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {

	@Autowired
	UserRepository userRepo;
	
}
