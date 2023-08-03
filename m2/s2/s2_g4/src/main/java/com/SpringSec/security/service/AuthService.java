package com.SpringSec.security.service;

import com.SpringSec.security.payload.LoginDto;
import com.SpringSec.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
