package com.java.initializr.biz.job;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyJob {

    @XxlJob("demoJobHandler")
    public void demoJobHandler() throws Exception {
        XxlJobHelper.log("Hello, World!");
        log.info("demoJobHandler Hello, World!");
    }

    @XxlJob("shardingJobHandler")
    public void shardingJobHandler() throws Exception {

        int shardIndex = XxlJobHelper.getShardIndex();
        int shardTotal = XxlJobHelper.getShardTotal();

        log.info("分片参数：当前分片序号 = {}, 总分片数 = {}", shardIndex, shardTotal);
    }

    @XxlJob("paramJobHandler")
    public void paramJobHandler() throws Exception {
        String param = XxlJobHelper.getJobParam();
        if (StringUtils.isBlank(param)) {
            XxlJobHelper.log("param[" + param + "] invalid.");
            XxlJobHelper.handleFail();
            return;
        }
        log.info("param:{}", param);
    }

    @XxlJob(value = "lifecycleJobHandler", init = "init", destroy = "destroy")
    public void lifecycleJobHandler() throws Exception {
        XxlJobHelper.log("XXL-JOB, Hello World.");
    }

    public void init() {
        log.info("init");
    }

    public void destroy() {
        log.info("destroy");
    }
}

