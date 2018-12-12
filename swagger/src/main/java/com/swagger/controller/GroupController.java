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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;

@RestController
@Api(tags = {"group management"}) 
public class GroupController {
	@GetMapping(path = "group/{id}")
	@ApiResponse(code = 404, message = "グループが見つからない")
	@ApiOperation(value = "グループを参照します", notes = "パラメータで指定したIDのグループリソースを参照します")
	public User getUser(@PathVariable @ApiParam(name="グループID", required=true) String id) throws ResourceNotFoundException {
		return new User(id, "group1");
	}

	@GetMapping(path = "groups")
	public List<User> getGroups() throws ResourceNotFoundException {
		return new ArrayList<User>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -2011028647387655919L;

			{
				add(new User("001", "group1"));
				add(new User("002", "group2"));
				add(new User("003", "group3"));
			}
		};
	}

	@PostMapping(path = "group")
	@ResponseStatus(HttpStatus.CREATED)
	public void createGroup(final @Valid @RequestBody Group group, final BindingResult bindingResult) {
	}
	
	@PutMapping(path = "group/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "New enrolment created sucses", reference = "aaaaa",
	                responseHeaders = @ResponseHeader(name = "Location", description = "The resulting URI of the newly-created enrolment", response = String.class))})
	public void updateGroup(@PathVariable String id, @Valid @RequestBody Group group, final BindingResult bindingResult) {
	}

	@DeleteMapping(path = "group/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteGroup(@PathVariable String id) {
	}

}
