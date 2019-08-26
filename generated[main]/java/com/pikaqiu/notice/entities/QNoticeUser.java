package com.pikaqiu.notice.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QNoticeUser is a Querydsl query type for NoticeUser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QNoticeUser extends EntityPathBase<NoticeUser> {

    private static final long serialVersionUID = -876011865L;

    public static final QNoticeUser noticeUser = new QNoticeUser("noticeUser");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath markRead = createBoolean("markRead");

    public final NumberPath<Long> noticeId = createNumber("noticeId", Long.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QNoticeUser(String variable) {
        super(NoticeUser.class, forVariable(variable));
    }

    public QNoticeUser(Path<? extends NoticeUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QNoticeUser(PathMetadata metadata) {
        super(NoticeUser.class, metadata);
    }

}

