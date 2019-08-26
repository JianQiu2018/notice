package com.pikaqiu.notice.service;

import com.pikaqiu.notice.dto.NoticeDto;
import com.pikaqiu.notice.entities.Notice;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Description:
 *
 * @author 贞子
 * @date 2019/8/23 23:15
 */
public interface NoticeService {

    Mono<String> publish(NoticeDto noticeDto);

    Mono<List<Notice>> getList();

}
