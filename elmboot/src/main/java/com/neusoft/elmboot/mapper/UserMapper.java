package com.neusoft.elmboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.neusoft.elmboot.po.User;

@Mapper
public interface UserMapper {
    @Select("select * from user where userId=#{userId} and password=#{password}")
    public User getUserByIdByPass(User user);

    @Select("select count(*) from user where userId=#{userId}")
    public int getUserById(String userId);

    @Insert("insert into user values(#{userId},#{password},#{userName},#{userSex},null,1,0)")
    public int saveUser(User user);

    @Update("update user set totalPoints=totalPoints + #{totalPoints} where userId=#{userId}")
    public void updateTotalPoints(String userId, Integer totalPoints);

    @Select("select totalPoints from user where userId=#{userId}")
    public int getTotalPoints(String userId);

    @Update("update user set totalPoints=totalPoints - #{totalPoints} where userId=#{userId}")
    public void subTotalPoints(String userId, Integer totalPoints);
}
