package com.miaww.demoapi.mapper;

import com.miaww.demoapi.model.RoleInfo;
import com.miaww.demoapi.model.RoleInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleInfoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table MIAWW.ROLE_INFO
	 * @mbg.generated  Sat Sep 14 01:53:01 ICT 2019
	 */
	long countByExample(RoleInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table MIAWW.ROLE_INFO
	 * @mbg.generated  Sat Sep 14 01:53:01 ICT 2019
	 */
	int deleteByExample(RoleInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table MIAWW.ROLE_INFO
	 * @mbg.generated  Sat Sep 14 01:53:01 ICT 2019
	 */
	int deleteByPrimaryKey(String roleId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table MIAWW.ROLE_INFO
	 * @mbg.generated  Sat Sep 14 01:53:01 ICT 2019
	 */
	int insert(RoleInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table MIAWW.ROLE_INFO
	 * @mbg.generated  Sat Sep 14 01:53:01 ICT 2019
	 */
	int insertSelective(RoleInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table MIAWW.ROLE_INFO
	 * @mbg.generated  Sat Sep 14 01:53:01 ICT 2019
	 */
	List<RoleInfo> selectByExample(RoleInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table MIAWW.ROLE_INFO
	 * @mbg.generated  Sat Sep 14 01:53:01 ICT 2019
	 */
	RoleInfo selectByPrimaryKey(String roleId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table MIAWW.ROLE_INFO
	 * @mbg.generated  Sat Sep 14 01:53:01 ICT 2019
	 */
	int updateByExampleSelective(@Param("record") RoleInfo record, @Param("example") RoleInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table MIAWW.ROLE_INFO
	 * @mbg.generated  Sat Sep 14 01:53:01 ICT 2019
	 */
	int updateByExample(@Param("record") RoleInfo record, @Param("example") RoleInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table MIAWW.ROLE_INFO
	 * @mbg.generated  Sat Sep 14 01:53:01 ICT 2019
	 */
	int updateByPrimaryKeySelective(RoleInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table MIAWW.ROLE_INFO
	 * @mbg.generated  Sat Sep 14 01:53:01 ICT 2019
	 */
	int updateByPrimaryKey(RoleInfo record);
}