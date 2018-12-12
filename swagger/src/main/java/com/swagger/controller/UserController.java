package com.swagger.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;

@RestController
public class UserController {
	@GetMapping(path = "user/{id}")
	@ApiResponse(code = 404, message = "Some Message")
	@ApiOperation(value = "ユーザリソースを参照します", notes = "パラメータで指定したIDのユーザリソースを参照します")
	public User getUser(@PathVariable String id) throws ResourceNotFoundException {
		return new User(id, "ichiro");
	}

	@GetMapping(path = "users")
	public List<User> getUsers() throws ResourceNotFoundException {
		return new ArrayList<User>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -2011028647387655919L;

			{
				add(new User("001", "ichiro"));
				add(new User("002", "jiro"));
				add(new User("003", "saburo"));
			}
		};
	}

	@PostMapping(path = "user")
	@ResponseStatus(HttpStatus.CREATED)
	public void createUser(final @Valid @RequestBody User user, final BindingResult bindingResult) {
	}

	@PutMapping(path = "user/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "New enrolment created sucses", reference = "aaaaa",
	                responseHeaders = @ResponseHeader(name = "Location", description = "The resulting URI of the newly-created enrolment", response = String.class))})
	public void updateUser(@PathVariable String id, @Valid @RequestBody User user, final BindingResult bindingResult) {
	}

	@DeleteMapping(path = "user/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable String id) {
	}

}
