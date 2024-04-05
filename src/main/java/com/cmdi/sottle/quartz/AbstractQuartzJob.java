package com.cmdi.sottle.quartz;


import com.cmdi.sottle.config.ScheduleConstants;
import com.cmdi.sottle.entity.QuartzJob;
import com.cmdi.sottle.utils.BeanUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Date;

/*
 *信息描述，如：类实体名
 *@author Mr.Rong
 *@CreateDate
 */


/**
 * 使用quartz框架
 */

public abstract class AbstractQuartzJob  implements Job {

    /**
     * 业务逻辑
     */

        private static final Logger log = LoggerFactory.getLogger(AbstractQuartzJob.class);

        /**
         * 线程本地变量
         */
        private static ThreadLocal<Date> threadLocal = new ThreadLocal<>();

        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            QuartzJob job = new QuartzJob();
            BeanUtils.copyBeanProp(job, context.getMergedJobDataMap().get(ScheduleConstants.TASK_PROPERTIES));
            try {
                before(context, job);
                if (job != null) {
                    doExecute(context, job);
                }
                after(context, job, null);
            } catch (Exception e) {
                log.error("任务执行异常  - ：", e);
                after(context, job, e);
            }
        }

        /**
         * 执行前
         *
         * @param context 工作执行上下文对象
         * @param job     系统计划任务
         */
        protected void before(JobExecutionContext context, QuartzJob job) {
            threadLocal.set(new Date());
        }

        /**
         * 执行后
         *
         * @param context 工作执行上下文对象
         * @param sysJob  系统计划任务
         */
        protected void after(JobExecutionContext context, QuartzJob sysJob, Exception e) {

        }

        /**
         * 执行方法，由子类重载
         *
         * @param context 工作执行上下文对象
         * @param job     系统计划任务
         * @throws Exception 执行过程中的异常
         */
        protected abstract void doExecute(JobExecutionContext context, QuartzJob job) throws Exception;
    }
