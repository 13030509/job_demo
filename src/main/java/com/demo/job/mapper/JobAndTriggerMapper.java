package com.demo.job.mapper;

import com.demo.job.entity.JobAndTrigger;

import java.util.List;

public interface JobAndTriggerMapper {

    List<JobAndTrigger> getJobAndTriggerDetails();

    void updateTriggerPreTriggerTime(Long time);

    Integer queryJobByNameAndGroupName(String jobName,String jobGroupName);
}
