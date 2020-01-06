package com.demo.job.vo;

import lombok.Data;

/**
 * @description:
 * @author: jiangjie
 * @date: 2020/1/3
 */
@Data
public class JobAddOrUpdateReqVo {


    private String jobClassName;
    private String jobName;
    private String jobGroupName;
    private String cronExpression;

}
