package com.pikaqiu.notice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Description:
 *
 * @author 贞子
 * @date 2019/8/23 23:16
 */
@Setter
@Getter
@Entity
public class NoticeUser {

    @Id
    private Long id;
    private Long noticeId;
    private Long userId;
    private Boolean markRead;

}
