package com.qmx.service;

import com.qmx.pojo.TbBlog;

import java.util.List;

/**
 * @author iBoy
 * @date 2019-08-02-12:57
 */
public interface BlogService {
    List<TbBlog> selectAll(Integer aid);

    boolean delete(Integer bid);

    boolean   deleteAll(Integer aid);

    TbBlog selectByPrimaryKey(Integer bid);
}
