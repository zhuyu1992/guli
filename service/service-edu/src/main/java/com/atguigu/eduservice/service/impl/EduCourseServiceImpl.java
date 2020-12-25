package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.EduCourseDescription;
import com.atguigu.eduservice.entity.vo.CourseInfoForm;
import com.atguigu.eduservice.mapper.EduCourseDescriptionMapper;
import com.atguigu.eduservice.mapper.EduCourseMapper;
import com.atguigu.eduservice.service.EduCourseService;
import com.atguigu.servicebase.config.GuliException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author zzzgy
 * @since 2020-12-25
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Resource
    EduCourseMapper eduCourseMapper;

    @Resource
    EduCourseDescriptionMapper eduCourseDescriptionMapper;

    /**
     * 查询课程所有信息
     * @return
     */
    @Override
    public List<EduCourse> queryAllCourseInfo() {

        List<EduCourse> courseList = this.eduCourseMapper.selectList(null);
        return courseList;
    }

    //向数据库添加课程信息
    @Override
    public String addCourseInfo(CourseInfoForm courseInfoForm) {

        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoForm,eduCourse);
       int i = eduCourseMapper.insert(eduCourse);
        if (i != 1) {
            throw new GuliException(20002,"添加课程信息失败");
        }
        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        eduCourseDescription.setId(eduCourse.getId());
        eduCourseDescription.setDescription(courseInfoForm.getDescription());
        int insert = eduCourseDescriptionMapper.insert(eduCourseDescription);
        if (insert != 1) {
            throw new GuliException(20002,"添加课程详情失败");
        }

        return eduCourse.getId();
    }

    /**
     * 根据id 删除课程信息
     * @param id
     * @return
     */
    @Override
    public Boolean deleteCourseInfoById(String id) {
        int i = this.eduCourseMapper.deleteById(id);
        int i1 = this.eduCourseDescriptionMapper.deleteById(id);
        if (i == 1 && i1 == 1) {
            return true;
        }
        return false;

    }

    /**
     * 根据课程id查询课程
     * @param id
     * @return
     */
    @Override
    public CourseInfoForm getCourseInfoById(String id) {
        CourseInfoForm courseInfoForm = new CourseInfoForm();
        EduCourse eduCourse = this.eduCourseMapper.selectById(id);
        EduCourseDescription eduCourseDescription = this.eduCourseDescriptionMapper.selectById(id);
        if (eduCourse != null && eduCourseDescription != null) {
            BeanUtils.copyProperties(eduCourse,courseInfoForm);
            BeanUtils.copyProperties(eduCourseDescription,courseInfoForm);
            return courseInfoForm;
        }
        return null;
    }

    /**
     * 根据课程id 更新课程
     * @param courseInfoForm
     */
    @Override
    public void uploadCourseInfoById(CourseInfoForm courseInfoForm) {
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoForm,eduCourse);
        int i = this.eduCourseMapper.updateById(eduCourse);
        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        BeanUtils.copyProperties(courseInfoForm,eduCourseDescription);
        int i1 = this.eduCourseDescriptionMapper.updateById(eduCourseDescription);
        if (i != 1 || i1 != 1) {
            throw new GuliException(20002,"课程更新失败");
        }
    }
}
