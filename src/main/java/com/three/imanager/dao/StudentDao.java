package com.three.imanager.dao;


import com.three.imanager.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentDao {

    //获取全部学生信息
    @Select({"select uid, stuid, sname, birth, sex, cel, address from student"})
    public List<Student> gets();

    //插入学生信息
    @Insert("insert into student(stuid,sname,birth,sex,cel,address)values(#{stuid},#{sname},#{birth},#{sex},#{cel},#{address})")
    public int insertStudent(Student student);

    //按uid
    @Select({"select uid, stuid, sname, birth, sex, cel, address from student  where uid = #{uid}"})
    public Student getsById(@Param("uid") int uid);

    //按名字
    @Select({"select uid, stuid, sname, birth, sex, cel, address from student  where sname = #{sname}"})
    public List<Student> getsBySname(@Param("sname") String sname);

    //获取UID
    @Select({"select uid, stuid, sname, birth, sex, cel, address from student  where sname = #{sname}"})
    public Student getsBySnameForUid(@Param("sname") String sname);

    //模糊名字查询
    @Select({"select uid, stuid, sname, birth, sex, cel, address from patient where sname like '%${sname}%'"})
    public List<Student> getsBySnameo(@Param("sname") String sname);

    //按学号
    @Select({"select uid, stuid, sname, birth, sex, cel, address from student  where stuid = #{stuid}"})
    public Student getsByStuId(@Param("stuid") int stuid);

    //删除学生
    @Delete({"delete from student where uid=#{uid}"})
    public void deleteStudent(int uid);


    //更改
    @Update({"update student set stuid=#{stuid}, sname=#{sname}, birth=#{birth}, sex=#{sex}, cel=#{cel}, address=#{address} where uid=#{uid}"})
    public void update(Student student);
}
