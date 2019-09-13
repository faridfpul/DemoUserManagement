package com.miaww.demoapi.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miaww.demoapi.mapper.CustomMapper;
import com.miaww.demoapi.mapper.UserInfoMapper;
import com.miaww.demoapi.model.UserInfo;
import com.miaww.demoapi.model.UserInfoExample;

@Transactional
@Service
public class UserService {

	private UserInfoMapper userInfoMapper;

	private CustomMapper customMapper;
	
	public List<String> getListMenu(String username){
		return customMapper.getListMenu(username);
	}
	public String getLastId() {
		int a = Integer.parseInt(customMapper.getLastUserId())+1;
		return String.valueOf(a);
	}
	public void CreateUser(String username,String password, String email) {
		UserInfo record = new UserInfo();
		record.setUserId(getLastId());
		record.setUsername(username);
		record.setPassword(password);
		record.setEmail(email);
		record.setUserStatus("1");
		userInfoMapper.insert(record);
	}
	public void DeleteUser(String userid) {
		UserInfoExample example = new UserInfoExample();
		example.createCriteria().andUserIdEqualTo(userid);
		userInfoMapper.deleteByExample(example);
	}
	public List<UserInfo> ListUserActive() {
		List<UserInfo> list = new ArrayList<UserInfo>();
		UserInfoExample example = new UserInfoExample();
		example.createCriteria().andUserStatusEqualTo("1");
		try {
			list = userInfoMapper.selectByExample(example);
		} catch (Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public List<UserInfo> ListUser() {
		List<UserInfo> list = new ArrayList<UserInfo>();
		UserInfoExample example = new UserInfoExample();
		example.createCriteria().andUserIdIsNotNull();
		list = userInfoMapper.selectByExample(example);
		return list;
	}
	public List<String> getuser() {
		List<String> list = new ArrayList<String>();
		list = customMapper.getusername();
		return list;
	}
	public void EditUserAdmin(String userid, String password, String email, String status) {
		UserInfoExample example = new UserInfoExample();
		UserInfo record = new UserInfo();
		example.createCriteria().andUserIdEqualTo(userid);
		record.setPassword(password);
		record.setEmail(email);
		record.setUserStatus(status);
		userInfoMapper.updateByExampleSelective(record, example);
	}
	public void EditUser(String userid, String password, String email) {
		UserInfoExample example = new UserInfoExample();
		UserInfo record = new UserInfo();
		example.createCriteria().andUserIdEqualTo(userid);
		record.setPassword(password);
		record.setEmail(email);
		userInfoMapper.updateByExampleSelective(record, example);
	}
	public String Login(String username, String password) {
		if (customMapper.Login(username, password).equals("ok")) {
			return "Login Berhasil";
		} else {
			return "Login Gagal";
		}
	}
}
