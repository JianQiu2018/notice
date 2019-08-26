package com.pikaqiu.notice.repository;

import com.pikaqiu.notice.entities.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description:
 *
 * @author 贞子
 * @date 2019/8/23 22:57
 */
public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
