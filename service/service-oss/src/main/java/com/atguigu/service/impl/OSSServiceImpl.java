package com.atguigu.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.internal.OSSHeaders;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.StorageClass;
import com.atguigu.config.AliyunProperties;
import com.atguigu.service.OSSService;
import com.atguigu.servicebase.config.GuliException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @auther: zzzgyu
 */
@Service
@EnableConfigurationProperties(value = AliyunProperties.class)
public class OSSServiceImpl implements OSSService {

    @Resource
    AliyunProperties aliyunProperties;

    @Override
    public String upload(MultipartFile file) {
        OSS OSSClient = new OSSClientBuilder().build(aliyunProperties.getEndpoint(), aliyunProperties.getKeyid(), aliyunProperties.getKeysecret());
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            throw new GuliException(20002,"文件错误");

        }
        // 创建PutObjectRequest对象。
        String originalFilename = file.getOriginalFilename();
        String afterLast = StringUtils.substringAfterLast(originalFilename, ".");

        String replace = UUID.randomUUID().toString().replace("-", "");
        String fileObject = replace+"."+afterLast;
        PutObjectRequest putObjectRequest = new PutObjectRequest(aliyunProperties.getBucketname(),fileObject,inputStream);

        // 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
        metadata.setObjectAcl(CannedAccessControlList.PublicReadWrite);
        putObjectRequest.setMetadata(metadata);

        OSSClient.putObject(putObjectRequest);
        OSSClient.shutdown();
        return "http://image.allweing.cn/"+fileObject;

    }
}
