package com.miaww.demoapi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CustomMapper {
	@Select("select d.menu_name from miaww.user_info a, miaww.role_info b,miaww.role_menu_map c, miaww.menu_info  " + 
			"where a.role_id=b.role_id  " + 
			"and a.username= #{username,  jdbcType=VARCHAR} " + 
			"and b.role_id= c.role_id " + 
			"and c.menu_id= d.menu_id " + 
			"and d.menu_status='1'")
	List<String> getListMenu(@Param("username")String username);
	
	@Select("select max(user_id) from miaww.user_info")
	String getLastUserId();
	@Select("select 'ok' from miaww.user_info where username = #{username,  jdbcType=VARCHAR} and "
			+ "password = #{password,  jdbcType=VARCHAR} and "
			+ "user_status = '1'")
	String Login(@Param("username")String username, @Param("password")String password);
	@Select("select username from miaww.user_info")
	List<String> getusername();
}
