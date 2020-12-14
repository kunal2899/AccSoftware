package com.accsoftware.rest.security;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accsoftware.rest.user.User;
import com.accsoftware.rest.user.UserService;

@CrossOrigin("http://localhost:4200")
@RestController
public class AuthController {

	@Autowired
	UserService us;
	
	@GetMapping("/user/basicauth")
	public AuthenticationBean getAuthentionMesage(Principal principal) {
		Optional<User> optUser = us.fetchByUsername(principal.getName());
		User user = optUser.get();
		AuthenticationBean ab = new AuthenticationBean(user.getId());
		return ab;
	}
}
