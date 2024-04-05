package com.cmdi.sottle.mapper;

import com.cmdi.sottle.entity.QuartzJob;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;


/*
 *信息描述，如：类实体名
 *@author Mr.Rong
 */

@Mapper
@Repository
public interface QuartzJobMapper {

    /**
     * 查询所有调度任务
     *
     * @return 调度任务列表
     */
    public List<QuartzJob> selectJobAll();

    /**
     * 通过调度ID查询调度任务信息
     *
     * @param jobId 调度ID
     * @return 角色对象信息
     */

    public QuartzJob selectJobById(Long jobId);

    /**
     * 通过调度ID删除调度任务信息
     *
     * @param jobId 调度ID
     * @return 结果
     */

    public int deleteJobById(Long jobId);

    /**
     * 通过调度ID更新调度任务状态
     *
     * @param jobId 调度ID
     * @param status 调度状态
     * @return 结果
     */

    public int changeStatus(@Param("jobId") Long jobId, @Param("status") String status);


    /**
     * 通过调度ID更新调度任务状态
     *
     * @param job 调度ID
     * @return 结果
     */

    public int updateById(QuartzJob job);
    /**
     * 通过调度ID更新调度任务状态
     * @param job 调度ID
     * @return 结果
     */
    public int insert(QuartzJob job);

}
