package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;
import java.util.HashMap;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author zzzgy
 * @since 2020-12-08
 */
public interface EduTeacherService extends IService<EduTeacher> {

    HashMap<String, Object> pageList(Long page, Long limit);

    @Override
    boolean removeById(Serializable id);
}
