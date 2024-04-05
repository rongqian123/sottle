package com.cmdi.sottle;

import com.cmdi.sottle.config.ScheduleConfig;
import com.cmdi.sottle.entity.QuartzJob;
import com.cmdi.sottle.utils.FileextractorUtils;
import com.cmdi.sottle.utils.XmlparsingUtils;
import org.dom4j.DocumentException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.xml.sax.SAXException;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
class SottleApplicationTests {

    @Autowired
    private com.cmdi.sottle.mapper.QuartzJobMapper JobMapper;
    @Resource
    DataSource datasource;

    @Test
    void contextLoads() {
        QuartzJob jobList ;
        QuartzJob job=new QuartzJob();
        job.setConcurrent("测试");
        job.setStatus("测试任务1");
        jobList = JobMapper.selectJobById(2L);
        System.out.println(jobList.getJobId());
    }

    @Test
    void contextLoa() {
        System.out.println("数据源》》"+datasource.getClass());


        //AnnotationConfigApplicationContext tx = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);
        //DataSource roleBean = (DataSource) tx.getBean("dataSource");
        //System.out.println(roleBean);
    }


    @Test
    void contextLoadss() throws IOException {
        FileextractorUtils fileextractorUtils =new FileextractorUtils();
        fileextractorUtils.gzipextractorMethor();
        System.out.println("解压成功");
    }


    @Test
    void contextLoadsss() throws IOException, DocumentException, ParserConfigurationException, SAXException {
        XmlparsingUtils ss =new XmlparsingUtils();
        ss.xmlparsingSAXMethor();
        System.out.println("解压成功");
    }

}
