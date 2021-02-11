package com.example.authentication;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.authentication.models.User;
import com.example.authentication.repositories.UserRepository;



@DataJpaTest

public class AuthenticationTests {

//    @Autowired
//    private LoginService loginService;

	@Autowired
	private UserRepository userRepository;

    @Test
    public void whenFindByName_thenReturnUser() {
        // given

		User testUser = new User();
		testUser.setName("Briana");
		testUser.setEmail("briana@test.com");
		testUser.setPassword("password");
		userRepository.save(testUser);

        // when
		User found = userRepository.findByName(testUser.getName());

        // then

		assertEquals(found.getName(), testUser.getName());
    }





}
