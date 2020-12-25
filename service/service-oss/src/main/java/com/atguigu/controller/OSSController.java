package com.atguigu.controller;

import com.atguigu.commonutils.R;
import com.atguigu.service.OSSService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @auther: zzzgyu
 */

@RestController
@CrossOrigin
public class OSSController {

    @Autowired
    OSSService ossService;

    @PostMapping("upload")
    @ApiOperation(value = "文件上传")
    public R upload(MultipartFile file) {
        String upload = ossService.upload(file);

        return R.ok().data("url",upload).message("文件上传成功");
    }
}
