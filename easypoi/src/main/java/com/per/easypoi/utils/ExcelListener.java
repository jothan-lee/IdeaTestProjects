package com.per.easypoi.utils;

import cn.afterturn.easypoi.cache.manager.POICacheManager;
import com.example.easypoi.utils.FileLoaderImpl;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;



/**
 * @Description: TODO 监听FileLoaderImpl
 * @Author: lys
 * @Date: 2020-09-12 14:11
 * @Version: 1.3.*
 */
@Component
public class ExcelListener implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        POICacheManager.setFileLoader(new FileLoaderImpl());
    }
}
