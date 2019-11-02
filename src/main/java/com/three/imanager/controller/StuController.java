package com.three.imanager.controller;


import com.three.imanager.entity.Student;
import com.three.imanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/stu")
public class StuController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/add")
    public String add(){
        return "add";
    }


    @GetMapping("/delete/{uid}")
    public String delStu(@PathVariable("uid") int uid) {
        studentService.deleteStudent(uid);
        return "redirect:/main";
    }


    @GetMapping("/update/{uid}")
    public String updateStu(@PathVariable("uid") int uid,Model model) {
        model.addAttribute("student",studentService.getStudentsById(uid));
        return "update";
    }

    @RequestMapping("/updates")
    public String updatesStu(HttpServletRequest request) throws ParseException {

        Student s = change(request);
        int uid = studentService.getStuUidBySname(s.getSname()).getUid();
        s.setUid(uid);
        System.out.println(s.toString());
        studentService.update(s);
        return "redirect:/main";
    }

    private Student change(HttpServletRequest request) throws ParseException {
        int stuid = Integer.parseInt(request.getParameter("stuid"));
        String sname = request.getParameter("sname");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date birth = format.parse(request.getParameter("birth"));
        String sex = request.getParameter("sex");
        String cel = request.getParameter("cel");
        String address = request.getParameter("address");
        if ("".equals(sname) || "".equals(sex) || "".equals(cel) || "".equals(address)) {
            return null;
        }
        Student student = new Student();
        student.setStuid(stuid);
        student.setSname(sname);
        student.setBirth(birth);
        student.setSex(sex);
        student.setCel(cel);
        student.setAddress(address);
        return student;
    }

    @RequestMapping("/addStudent")
    public String insertStudent(HttpServletRequest request, Model model) {
        try {
            Student student = change(request);
            if (student == null) {
                throw new RuntimeException("空，无法插入");
            }
            //判断学号是否已存在
            if (studentService.getByStuId(student.getUid()) != null) {
                throw new RuntimeException("已存在，插入失败");
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return "redirect:/main";
    }

}

