package com.ht.scada.security.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * 作者: "薄成文"
 * 日期: 13-5-13 上午11:23
 * To change this template use File | Settings | File Templates.
 */
public class UserTags  extends AbstractPersistable<Integer> {
    private User user;
    /**
     * true 表示MajorTag，false 表示EndTag
     */
    private boolean tagType;
    private List<Integer> tagName;
}
