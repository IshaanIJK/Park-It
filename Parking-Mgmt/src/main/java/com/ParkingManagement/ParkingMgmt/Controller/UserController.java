package com.ParkingManagement.ParkingMgmt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ParkingManagement.ParkingMgmt.Entity.User;
import com.ParkingManagement.ParkingMgmt.Service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")    //portno of react
public class UserController {
	
	@Autowired
	private UserService userService;
	
	 @GetMapping("/login")
	    public List<User> getAllUser() {
		 System.out.println("chal gaya");
	        return userService.getUsers();
	    }
	 
	 @PostMapping("/signup")
	 public ResponseEntity<User> createUser(@RequestBody User user) {
	        User createdUser = userService.insertUser(user);
	        
	        return ResponseEntity.ok(createdUser);
	    }


}
