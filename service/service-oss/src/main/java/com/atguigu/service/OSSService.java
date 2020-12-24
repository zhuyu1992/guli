package com.atguigu.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @auther: zzzgyu
 */

public interface OSSService {
    String upload(MultipartFile file);
}
