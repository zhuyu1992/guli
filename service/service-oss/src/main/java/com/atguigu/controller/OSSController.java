package com.atguigu.controller;

import com.atguigu.commonutils.R;
import com.atguigu.service.OSSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @auther: zzzgyu
 */

@RestController
public class OSSController {

    @Autowired
    OSSService ossService;

    @PostMapping
    public R upload(MultipartFile file) {
        String upload = ossService.upload(file);

        return R.ok().data("url",upload);
    }
}
