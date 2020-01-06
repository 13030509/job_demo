package com.demo.job.task;

import com.demo.job.annotation.TaskNode;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

@TaskNode(taskName="普通任务1")
public class DemoTask implements Job {


    public void execute(JobExecutionContext context) {

        System.out.println("我是普通任务1");

    }
}
