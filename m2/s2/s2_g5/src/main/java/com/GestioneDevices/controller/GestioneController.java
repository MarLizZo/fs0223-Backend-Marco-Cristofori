package com.GestioneDevices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GestioneDevices.entity.Device;
import com.GestioneDevices.entity.Laptop;
import com.GestioneDevices.entity.Smartphone;
import com.GestioneDevices.entity.Tablet;
import com.GestioneDevices.entity.User;
import com.GestioneDevices.service.DeviceService;
import com.GestioneDevices.service.UserService;
import com.GestioneDevices.service.User_DeviceService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class GestioneController {
	
	@Autowired UserService u_svc;
	@Autowired DeviceService d_svc;
	@Autowired User_DeviceService ud_svc;
	
	@PostMapping("/assign")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public String assign(@RequestParam Long u, @RequestParam Long d) {
		User user = u_svc.getById(u);
		Device device = d_svc.getById(d);
		ud_svc.assignDeviceToUser(user, device);
		return "** Device " + device.getName() + " assigned to " + user.getUsername() + " **";
	}
	
	@GetMapping("/users")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Page<User>> getAllUsers(Pageable pageable) {
		Page<User> ls = u_svc.getUsersPagination(pageable);
		return new ResponseEntity<Page<User>>(ls, HttpStatus.OK);
	}
	
	@GetMapping("/devices")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Page<Device>> getAllDevices(Pageable pageable) {
		Page<Device> ls = d_svc.getAllDevicePaginated(pageable);
		return new ResponseEntity<Page<Device>>(ls, HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		return new ResponseEntity<User>(u_svc.getById(id), HttpStatus.OK);
	}
	
	@GetMapping("/device/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Device> getDevice(@PathVariable Long id) {
		return new ResponseEntity<Device>(d_svc.getById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> deleteUser(@PathVariable Long id) {
		User user = u_svc.getById(id);
		u_svc.deleteById(id);
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/device/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Device> deleteDevice(@PathVariable Long id) {
		Device d = d_svc.getById(id);
		d_svc.deleteById(id);
		return ResponseEntity.ok(d);
	}
	
	@PostMapping("/device/new/pc")
	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
	public ResponseEntity<Laptop> createDevice(@RequestBody Laptop pc) {
		return new ResponseEntity<Laptop>((Laptop) d_svc.saveDevice(pc), HttpStatus.CREATED);
	}
	
	@PostMapping("/device/new/sm")
	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
	public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone sm) {
		return new ResponseEntity<Smartphone>((Smartphone) d_svc.saveDevice(sm), HttpStatus.CREATED);
	}
	
	@PostMapping("/device/new/tb")
	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
	public ResponseEntity<Tablet> createSmartphone(@RequestBody Tablet tb) {
		return new ResponseEntity<Tablet>((Tablet) d_svc.saveDevice(tb), HttpStatus.CREATED);
	}
}



















