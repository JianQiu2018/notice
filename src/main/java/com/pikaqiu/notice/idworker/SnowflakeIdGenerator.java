package com.pikaqiu.notice.idworker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author 贞子
 * @date 2019/8/5 21:11
 */
@Slf4j
@Service(value = "idGenerator")
public class SnowflakeIdGenerator implements IdGenerator {

    @Value("${common.id.dataCenterId}")
    private long dataCenterId;
    @Value("${common.id.workId}")
    private long workId;

    @Autowired
    private IdWorker idWorker;

    @Override
    public long nextId() {
        return idWorker.getId();
    }

    @Bean
    IdWorker idWorker(){
        log.info("Initializing IdGenerator, workId={}, dataCenterId={}", workId, dataCenterId);
        return new IdWorker(workId, dataCenterId);
    }


}
