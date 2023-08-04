package com.GestioneDevices.service;

import com.GestioneDevices.payload.LoginDto;
import com.GestioneDevices.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
