package com.demo.job.task;

import com.demo.job.annotation.TaskNode;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @description:
 * @author: jiangjie
 * @date: 2019/12/24
 */
@TaskNode(taskName = "普通任务2")
public class Demo2Task implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println("我是普通任务2");

    }
}
