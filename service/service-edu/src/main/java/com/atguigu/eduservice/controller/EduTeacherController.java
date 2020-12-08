package com.atguigu.eduservice.controller;


import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author zzzgy
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {

    @Autowired
    EduTeacherService eduTeacherService;

    @GetMapping
    public List<EduTeacher> query() {
        List<EduTeacher> list = eduTeacherService.list(null);
        return list;
    }

    @DeleteMapping("{id}")
    public boolean deleteTeacherById(@PathVariable("id") String id) {
        boolean b = eduTeacherService.removeById(id);
        return b;
    }

}

