package com.cmdi.sottle.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 *信息描述，如：类实体名
 *@author Mr.Rong
 *@CreateDate
 */
@Component("mroloaderJob")
public class MroloaderJob {

    private  final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void execute(String param) {









        logger.info("执行 Mysql Job，当前时间：{}，任务参数：{}", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), param);

    }
}
