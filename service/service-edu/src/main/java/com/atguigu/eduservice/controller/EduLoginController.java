package com.atguigu.eduservice.controller;

import com.atguigu.commonutils.R;
import com.atguigu.servicebase.config.GuliException;
import org.springframework.web.bind.annotation.*;

/**
 * @auther: zzzgyu
 */
@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin
public class EduLoginController {

    @PostMapping("/login")
    public R login() {
        return R.ok().data("token","admin");
    }

    @GetMapping("info")
    public R info() {
        return R.ok().data("roles","[admin]").data("name","zzgy").data("avatar",null);
    }

}
