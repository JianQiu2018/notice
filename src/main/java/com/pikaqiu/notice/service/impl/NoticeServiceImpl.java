package com.pikaqiu.notice.service.impl;

import com.pikaqiu.notice.dto.NoticeDto;
import com.pikaqiu.notice.entities.Notice;
import com.pikaqiu.notice.entities.NoticeUser;
import com.pikaqiu.notice.idworker.IdGenerator;
import com.pikaqiu.notice.repository.NoticeRepository;
import com.pikaqiu.notice.repository.NoticeUserRepository;
import com.pikaqiu.notice.service.NoticeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author 贞子
 * @date 2019/8/23 23:15
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private IdGenerator idGenerator;

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private NoticeUserRepository noticeUserRepository;

    @Override
    public Mono<String> publish(NoticeDto noticeDto) {
        Long noticeId = idGenerator.nextId();
        Notice notice = new Notice();
        notice.setId(idGenerator.nextId());
        notice.setNoticeId(noticeId);
        BeanUtils.copyProperties(noticeDto, notice);
        notice.setCreateTime(LocalDateTime.now());

        //存入消息用户表
        List<NoticeUser> noticeUserList = new ArrayList<>();
        Long[] userIds = noticeDto.getUserIds();
        for (Long userId : userIds) {
            NoticeUser noticeUser = new NoticeUser();
            noticeUser.setId(idGenerator.nextId());
            noticeUser.setNoticeId(noticeId);
            noticeUser.setUserId(userId);
            noticeUser.setMarkRead(false);
            noticeUserList.add(noticeUser);
        }
        noticeUserRepository.saveAll(noticeUserList);
        return Mono.just(noticeRepository.save(notice).getId().toString());
    }

    @Override
    public Mono<List<Notice>> getList() {
        return Mono.just(noticeRepository.findAll());
    }
}
