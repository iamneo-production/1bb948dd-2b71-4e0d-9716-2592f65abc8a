package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.repository.UserRepository;
import com.examly.springapp.model.UserModel;
import com.examly.springapp.tempmodel.UserTempModel;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SignupController {


}
