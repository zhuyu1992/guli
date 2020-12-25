package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.vo.CourseInfoForm;
import com.atguigu.eduservice.service.EduCourseService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author zzzgy
 * @since 2020-12-25
 */
@RestController
@RequestMapping("/eduservice/course")
public class EduCourseController {

    @Autowired
    EduCourseService eduCourseService;


    /**
     * 查询课程所有信息
     * @return
     */
    @GetMapping
    @ApiOperation(value = "查询课程所有信息")
    public R queryAllCourseInfo() {
        List<EduCourse> list = this.eduCourseService.queryAllCourseInfo();
        if (CollectionUtils.isEmpty(list)) {
            return R.error();
        }
        return R.ok().data("items",list);
    }

    /**
     * 添加课程信息
     * @param courseInfoForm
     * @return
     */

    @PostMapping("addCourseInfo")
    @ApiOperation(value = "添加课程信息")
    public R addCourseInfo(@RequestBody CourseInfoForm courseInfoForm) {
       String id = eduCourseService.addCourseInfo(courseInfoForm);
        if (StringUtils.isNotEmpty(id)) {
            return R.ok().data("id", id);
        }
        return R.error();
    }

    /**
     * 根据id 删除课程信息
     * @param id
     * @return
     */
    @DeleteMapping("course-info/{id}")
    public R deleteCourseInfoById(@PathVariable("id") String id) {
       Boolean b = this.eduCourseService.deleteCourseInfoById(id);
        if (b) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 根据id查询回显课程数据
     * @param id
     * @return
     */
    @GetMapping("course-info/{id}")
    public R getCourseInfoById(@PathVariable("id") String id) {
       CourseInfoForm courseInfoForm = this.eduCourseService.getCourseInfoById(id);
        if (courseInfoForm == null) {
            return R.error().message("错误，查询失败");
        }
        return R.ok().data("item",courseInfoForm);
    }

    /**
     * 根据id 更新课程信息
     * @param courseInfoForm
     * @return
     */
    @PutMapping("course-info")
    public R updataCourseInfoById(@RequestBody CourseInfoForm courseInfoForm) {

        this.eduCourseService.uploadCourseInfoById(courseInfoForm);
        return R.ok();
    }

}

