package com.atguigu.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @auther: zzzgyu
 */

@ConfigurationProperties(prefix = "aliyun.oss.file")
public class AliyunProperties {

    private String endpoint;
    private String keyid;
    private String keysecret;
    private String bucketname;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getKeyid() {
        return keyid;
    }

    public void setKeyid(String keyid) {
        this.keyid = keyid;
    }

    public String getKeysecret() {
        return keysecret;
    }

    public void setKeysecret(String keysecret) {
        this.keysecret = keysecret;
    }

    public String getBucketname() {
        return bucketname;
    }

    public void setBucketname(String bucketname) {
        this.bucketname = bucketname;
    }
}
