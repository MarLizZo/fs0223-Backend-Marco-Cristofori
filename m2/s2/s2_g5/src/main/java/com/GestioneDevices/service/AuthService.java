package com.GestioneDevices.service;

import com.GestioneDevices.entity.User;
import com.GestioneDevices.payload.LoginDto;
import com.GestioneDevices.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    User register(RegisterDto registerDto);
    public boolean isMod(String username);
    public boolean isAdmin(String username);
    
}
