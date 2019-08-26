package com.pikaqiu.notice.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Description:
 *
 * @author 贞子
 * @date 2019/8/23 23:19
 */
@Setter
@Getter
public class NoticeDto {

    private String title;
    private String content;
    private String moduleType;
    private Integer type;
    private String url;
    private Long[] userIds;

}
