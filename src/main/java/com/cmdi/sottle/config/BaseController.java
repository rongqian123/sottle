package com.cmdi.sottle.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 *信息描述，如：类实体名
 *@author Mr.Rong
 *@CreateDate
 */
public class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * api 返回使用，状态
     */
    protected int success = 0;
    protected int error = 1;

}
