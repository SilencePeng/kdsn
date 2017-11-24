package com.usping.kdsn.mapper;

import com.usping.kdsn.bean.User;
import com.usping.kdsn.bean.UserExample;
import com.usping.kdsn.bean.UserWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    long countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    int insert(UserWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    int insertSelective(UserWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    List<UserWithBLOBs> selectByExampleWithBLOBs(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    UserWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    int updateByExampleSelective(@Param("record") UserWithBLOBs record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    int updateByExampleWithBLOBs(@Param("record") UserWithBLOBs record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    int updateByPrimaryKeySelective(UserWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    int updateByPrimaryKeyWithBLOBs(UserWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Mon Nov 20 16:46:11 CET 2017
     */
    int updateByPrimaryKey(User record);

    List<User> selectAll();

    User selectByUserName(String username);


}