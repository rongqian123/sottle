package com.cmdi.sottle.utils;

import com.cmdi.sottle.entity.QuartzJob;
import com.cmdi.sottle.quartz.AbstractQuartzJob;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;

/*
 *信息描述，如：类实体名
 *@author Mr.Rong
 *@CreateDate
 */
@DisallowConcurrentExecution
public class QuartzDisallowConcurrentExecution extends AbstractQuartzJob {
    @Override
    protected void doExecute(JobExecutionContext context, QuartzJob job) throws Exception {
        JobInvokeUtil.invokeMethod(job);
    }
}
