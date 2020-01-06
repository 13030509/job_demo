package com.demo.job.entity;

import lombok.Data;

/**
 * @description:
 * @author: jiangjie
 * @date: 2019/12/24
 */
@Data
public class JobAndTrigger {

	private String jobName;

	private String jobGroup;

	private String jobClassName;

	private String triggerName;

	private String triggerGroup;

	private String cronExpression;

	private String triggerState;

	private String prevFireTime;

    private String nextFireTime;
}
