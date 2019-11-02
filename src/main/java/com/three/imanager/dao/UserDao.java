package com.three.imanager.dao;


import com.three.imanager.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    //插入用户信息
    @Insert("insert into user(username,password)values(#{username},#{password})")
    public int insertUser(User user);

    //查找用户信息
    @Select({"select username, password from user where username=#{username}"})
    public User getByName(@Param("username")String username);

}
