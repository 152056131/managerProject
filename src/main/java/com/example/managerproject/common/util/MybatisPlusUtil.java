package com.example.managerproject.common.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MybatisPlusUtil
 * @Description TODO
 * @Author kevin
 * @Date 2023/9/21 下午3:34
 * @Version 1.0
 */
@Configuration
public class MybatisPlusUtil {
    /**
     * @Description 分页拦截器
     * @Author kevin
     * @Date 2023/9/21 下午3:34
     * @Version 1.0
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return mybatisPlusInterceptor;
    }
}
