package com.neusoft.elmboot.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.neusoft.elmboot.po.Points;

@Mapper
public interface PointsMapper {
    @Select("select * from points where userId=#{userId} order by pointId")
    public List<Points> listPointsByOrderUserId(String userId);

    @Insert("insert into points values(#{pointId},#{userId},#{point},#{date},1)")
    public int savePoints(Points points);

    @Update("update points set point=#{point} where pointId=#{pointId}")
    public void updatePoints(Integer pointId, Integer point);

    @Delete("update points set valid=0 where pointId=#{pointId}")
    public void removePoints(Integer pointId);
}
