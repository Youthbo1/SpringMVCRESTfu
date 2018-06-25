package com.fyb.controller;

import com.fyb.dao.CourseDAO;
import com.fyb.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * \Date: 2018/6/25
 * \
 * \Description:
 * \
 */
@Controller
public class CourseController {

    @Autowired
    private CourseDAO courseDAO;

    @PostMapping(value = "/add")
    public String add(Course course){
        courseDAO.add(course);
        return "redirect:/getAll";
    }

    @GetMapping(value = "/getAll")
    public ModelAndView getAll(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("courses",courseDAO.getAll());
        return modelAndView;
    }


    @GetMapping(value = "/getById/{id}")
    public ModelAndView getById(@PathVariable(value = "id") int id){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("edit");
        modelAndView.addObject("course",courseDAO.getById(id));
        return modelAndView;
    }

    @PutMapping(value = "update")
    public String update(Course course){
        courseDAO.update(course);
        return "redirect:/getAll";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id") int id){
        courseDAO.deleteById(id);
        return "redirect:/getAll";
    }
}
