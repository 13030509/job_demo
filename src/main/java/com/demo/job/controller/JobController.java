package com.demo.job.controller;

import com.demo.job.service.IJobService;
import com.demo.job.vo.JobAddOrUpdateReqVo;
import com.demo.job.vo.JobOptReqVo;
import com.demo.job.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/job")
public class JobController {
    @Autowired
    private IJobService jobService;


    @ResponseBody
    @PostMapping(value = "/addjob")
    public Result addjob(@RequestBody JobAddOrUpdateReqVo jobAddOrUpdateReqVo) {

        return jobService.createJobAndTrigger( jobAddOrUpdateReqVo.getJobClassName(),
                jobAddOrUpdateReqVo.getJobName(),
                jobAddOrUpdateReqVo.getJobGroupName(),
                jobAddOrUpdateReqVo.getCronExpression());

    }


    @PostMapping(value = "/pausejob")
    public Result pausejob(@RequestBody JobOptReqVo jobOptReqVo) {
        return jobService.pauseJob(jobOptReqVo.getJobName(), jobOptReqVo.getJobGroupName());
    }


    @PostMapping(value = "/resumejob")
    public Result resumejob(@RequestBody JobOptReqVo jobOptReqVo) {
        return jobService.resumeJob(jobOptReqVo.getJobName(), jobOptReqVo.getJobGroupName());
    }


    @PostMapping(value = "/reschedulejob")
    public Result rescheduleJob(@RequestBody JobAddOrUpdateReqVo jobAddOrUpdateReqVo) {

        return jobService.rescheduleJob(
                jobAddOrUpdateReqVo.getJobName(),
                jobAddOrUpdateReqVo.getJobGroupName(),
                jobAddOrUpdateReqVo.getCronExpression());

    }

    @PostMapping(value = "/deletejob")
    public Result deletejob(@RequestBody JobOptReqVo jobOptReqVo) {
        return jobService.deleteJob(jobOptReqVo.getJobName(), jobOptReqVo.getJobGroupName());
    }

    @GetMapping(value = "/queryjob")
    public Result queryjob(@RequestParam(value = "pageNum") Integer pageNum, @RequestParam(value = "pageSize") Integer pageSize) {
        return jobService.getJobAndTriggerList(pageNum, pageSize);
    }


    @PostMapping(value = "/triggerjob")
    public Result triggerJobAtOnce(@RequestBody JobOptReqVo jobOptReqVo) {
        return jobService.triggerJobAtOnce(jobOptReqVo.getJobName(), jobOptReqVo.getJobGroupName());
    }

    @PostMapping(value = "/validateJobNameAndGroupName")
    public Result validateJobNameAndGroupName(@RequestBody JobOptReqVo jobOptReqVo) {
        return jobService.validateJobNameAndGroupName(jobOptReqVo.getJobName(), jobOptReqVo.getJobGroupName());
    }


}
