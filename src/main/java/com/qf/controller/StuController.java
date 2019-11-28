package com.qf.controller;

import com.qf.entity.Student;
import com.qf.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("stu")
public class StuController {
    @Autowired
    private IStuService stuService;

    @RequestMapping("getStuList")
    public String getStuList(Model model){
        List<Student> studentList=stuService.list();
        model.addAttribute("studentList",studentList);
        return "student";
    }

    @RequestMapping("delete")
    public String delete(int id){
        stuService.removeById(id);
        return "redirect:/stu/getStuList";
}

}
