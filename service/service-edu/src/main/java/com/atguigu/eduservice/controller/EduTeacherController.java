package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.service.EduTeacherService;
import com.atguigu.servicebase.config.GuliException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
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
    @ApiOperation(value = "查询所有老师")
    public R query() {
        List<EduTeacher> list = eduTeacherService.list(null);
        System.out.println(list);
        return R.ok().data("item",list);
    }

    @DeleteMapping("{id}")
    public R deleteTeacherById(@PathVariable("id") String id) {
        boolean b = eduTeacherService.removeById(id);
        System.out.println("=====================");
        if (b) {
            return R.ok();
        }else {
            return R.error();
        }
    }

    @GetMapping("{page}/{limit}")
    @ApiOperation(value = "分页老师列表")
    public R pageList(
            @ApiParam(name = "page",value = "当前页",required = true)
            @PathVariable("page") Long page,
            @ApiParam(name = "limit",value = "每页数",required = true)
            @PathVariable("limit") Long limit) {
        HashMap<String,Object> pageResult = this.eduTeacherService.pageList(page,limit);

        return R.ok().data(pageResult);
    }


    @ApiOperation(value = "新增讲师")
    @PostMapping
    @Transactional
    public R save(@ApiParam(name = "eduteacher",value = "讲师对象",required = true) @RequestBody EduTeacher eduTeacher) {
        boolean save = this.eduTeacherService.save(eduTeacher);
        if (save) {
            return R.ok();
        }else {
            return R.error();
        }
    }

    @ApiOperation(value = "通过id查询讲师")
    @GetMapping("{id}")
    public R queryTeacherById( @PathVariable("id") String id) {
        EduTeacher eduTeacher = this.eduTeacherService.getById(id);
        try {
            int i=1/0;
        } catch (Exception e) {

            throw new GuliException(2009,"错误,自定义异常");
        }
        if (eduTeacher == null) {
            return R.error().message("没找到");
        }else {
            return R.ok().data("item", eduTeacher);
        }
    }

    @ApiOperation(value = "通过id修改教师")
    @PutMapping("{id}")
    public R updataTeacherById(@PathVariable("id") String id,@RequestBody EduTeacher eduTeacher) {
        eduTeacher.setId(id);
        boolean b = this.eduTeacherService.updateById(eduTeacher);
        if (b) {
            return R.ok();
        }else {
            return R.error();
        }

    }
}

