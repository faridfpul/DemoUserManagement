package com.miaww.demoapi.requestor;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miaww.demoapi.model.UserInfo;
import com.miaww.demoapi.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(tags = "User")
@RequestMapping(value = "/user")
public class UserRest {
	@Autowired
	private UserService userService;
	@ApiOperation(value = "Get All User")
	@RequestMapping(value = "/listAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<UserInfo>> getListAllUser(){
		List<UserInfo> list = new ArrayList<UserInfo>();
		list = userService.ListUser();
		if (list.isEmpty()) {
			return new ResponseEntity<List<UserInfo>>(list,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<UserInfo>>(list,HttpStatus.OK);
	}
	@ApiOperation(value = "Get All User")
	@RequestMapping(value = "/listusername", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<String>> getname(){
		List<String> list = new ArrayList<String>();
		list = userService.getuser();
		if (list.isEmpty()) {
			return new ResponseEntity<List<String>>(list,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<String>>(list,HttpStatus.OK);
	}
	@ApiOperation(value = "Get All Active User")
	@RequestMapping(value = "/listActive", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<UserInfo>> getListActiveUser(){
		List<UserInfo> list = userService.ListUserActive();
		if (list.isEmpty()) {
			return new ResponseEntity<List<UserInfo>>(list,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<UserInfo>>(list,HttpStatus.OK);
	}
	@ApiOperation(value = "Create User")
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> CreateUser(@RequestParam String username, @RequestParam String password, @RequestParam String email){
		String response = "User Created";
		try {
			userService.CreateUser(username, password, email);
		} catch (GenericJDBCException e) {
			response = e.getLocalizedMessage();
			return new ResponseEntity<String>(response,HttpStatus.CONFLICT);
		}
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	@ApiOperation(value = "Edit User")
	@RequestMapping(value = "/editAsAdmin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> EditAsAdmin(@RequestParam String userid, @RequestParam String password, @RequestParam String email, @RequestParam String status){
		String response = "User Edited";
		try {
			userService.EditUserAdmin(userid, password, email, status);
		} catch (GenericJDBCException e) {
			response = e.getLocalizedMessage();
			return new ResponseEntity<String>(response,HttpStatus.CONFLICT);
		}
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	@ApiOperation(value = "Edit User")
	@RequestMapping(value = "/edit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> Edit(@RequestParam String userid, @RequestParam String password, @RequestParam String email){
		String response = "User Edited";
		try {
			userService.EditUser(userid, password, email);
		} catch (GenericJDBCException e) {
			response = e.getLocalizedMessage();
			return new ResponseEntity<String>(response,HttpStatus.CONFLICT);
		}
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	@ApiOperation(value = "Delete User")
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> Delete(@RequestParam String userid){
		String response = "User Deleted";
		try {
			userService.DeleteUser(userid);;
		} catch (GenericJDBCException e) {
			response = e.getLocalizedMessage();
			return new ResponseEntity<String>(response,HttpStatus.CONFLICT);
		}
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
	
}
