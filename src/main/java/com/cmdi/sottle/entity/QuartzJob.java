package com.cmdi.sottle.entity;

/*
 *信息描述，如：类实体名
 *@author Mr.Rong
 *@CreateDate
 */

import java.io.Serializable;



public class QuartzJob implements Serializable {

    Long job_id;
    String job_name;
    String job_group;
    String invoke_target;
    String cron_expression;
    String misfire_policy;
    String concurrent;
    String status;
    String remark;
    String createtime;
    String updatetime;

    public Long getJobId() {
        return job_id;
    }

    public void setJobId(Long jobId) {
        this.job_id = jobId;
    }

    public String getJobName() {
        return job_name;
    }

    public void setJobName(String jobName) {
        this.job_name = jobName;
    }

    public String getJobGroup() {
        return job_group;
    }

    public void setJobGroup(String jobGroup) {
        this.job_group = jobGroup;
    }

    public String getInvokeTarget() {
        return invoke_target;
    }

    public void setInvokeTarget(String invokeTarget) {
        this.invoke_target = invokeTarget;
    }

    public String getCronExpression() {
        return cron_expression;
    }

    public void setCronExpression(String cronExpression) {
        this.cron_expression = cronExpression;
    }

    public String getMisfirePolicy() {
        return misfire_policy;
    }

    public void setMisfirePolicy(String misfirePolicy) {
        this.misfire_policy = misfirePolicy;
    }

    public String getConcurrent() {
        return concurrent;
    }

    public void setConcurrent(String concurrent) {
        this.concurrent = concurrent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}
