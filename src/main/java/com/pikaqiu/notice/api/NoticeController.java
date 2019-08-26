package com.pikaqiu.notice.api;

import com.pikaqiu.notice.constants.Constants;
import com.pikaqiu.notice.dto.HttpResponse;
import com.pikaqiu.notice.dto.NoticeDto;
import com.pikaqiu.notice.entities.Notice;
import com.pikaqiu.notice.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Description:
 *
 * @author 贞子
 * @date 2019/8/23 22:54
 */
@Slf4j
@RestController
public class NoticeController {


    @Autowired
    private NoticeService noticeService;

    /**
     * @api {POST} /internal/api/notice/publish 发布消息通知
     * @apiGroup Notice
     * @apiUse GlobalErrorCode
     * @apiParam {String} title 标题
     * @apiParam {String} content 内容
     * @apiParam {Number} type 类型
     * @apiParam {String} url 外链
     */
    @PostMapping(value = Constants.URL_INTERNAL_PREFIX + Constants.URL_API_PREFIX + "/notice/publish")
    public Mono<HttpResponse<String>> publish(@RequestBody NoticeDto noticeDto) {
        if (log.isDebugEnabled()) {
            log.debug("Request /internal/api/notice/publish [POST].");
        }
        return noticeService.publish(noticeDto).map(data -> new HttpResponse<String>().setData(data));
    }

    /**
     * @api {GET} /internal/api/notice/publish 获取消息列表
     * @apiGroup Notice
     * @apiUse GlobalErrorCode
     */
    @GetMapping(value = Constants.URL_API_ADMIN_PREFIX + "/notice/getList")
    public Mono<HttpResponse<List<Notice>>> getList() {
        if (log.isDebugEnabled()) {
            log.debug("Request /api/admin/notice/getList [GET].");
        }
        return noticeService.getList().map(data -> new HttpResponse<List<Notice>>().setData(data));
    }

}
