package com.three.imanager.service;


import com.three.imanager.dao.StudentDao;
import com.three.imanager.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    @Autowired
    StudentDao studentDao;

    public List<Student> getStudents() {
        return studentDao.gets();
    }


    //插入学生信息
    public int insertStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    //查询
    public Student getStudentsById(int uid) {
        return studentDao.getsById(uid);
    }

    public Student getByStuId(int stuid) {
        return studentDao.getsByStuId(stuid);
    }

    public List<Student> getstudentsbySname(String name) {
        return studentDao.getsBySname(name);
    }

    public Student getStuUidBySname(String name){
        return studentDao.getsBySnameForUid(name);
    }


    public List<Student> getstudentsbySnameo(String likename) {
        return studentDao.getsBySnameo(likename);
    }


    //删除
    public void deleteStudent(int uid) {
        studentDao.deleteStudent(uid);
    }

    public void update(Student student) {
        studentDao.update(student);
    }
}
