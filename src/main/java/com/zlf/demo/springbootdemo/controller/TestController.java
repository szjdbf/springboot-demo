package com.zlf.demo.springbootdemo.controller;

import cn.hutool.core.map.MapUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private DataSource dataSource;

    @GetMapping("/hello")
    public Object hello() {
        String html = restTemplate.getForObject("https://www.baidu.com", String.class);
        System.out.println(html);
        return MapUtil.builder("code", 0).build();
    }


    @GetMapping("/test")
    public void test() {
        String sql = "insert into image_data (accessUrl,resourcePath,customerId) values (" + "'test'" + " ," + "'test'" + "," + 1000 + ")";
        System.out.println(sql);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute(sql);
    }

}

@Data
class ImageData {
    private Long id;
    private String accessUrl;
    private String resourcePath;
    private Long customerId;
}