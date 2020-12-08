package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.mapper.EduTeacherMapper;
import com.atguigu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author zzzgy
 * @since 2020-12-08
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Resource
    EduTeacherMapper eduTeacherMapper;

    @Override
    public HashMap<String, Object> pageList(Long page, Long limit) {

        Page<EduTeacher> eduTeacherPage = new Page<>(page, limit);

        IPage<EduTeacher> eduTeacherIPage = eduTeacherMapper.selectPage(eduTeacherPage, null);

        List<EduTeacher> records = eduTeacherIPage.getRecords();


        long total = eduTeacherIPage.getTotal();


        HashMap<String, Object> hashMap = new HashMap<>();

        hashMap.put("total",total);
        hashMap.put("rows",records);
        return hashMap;
    }
}
