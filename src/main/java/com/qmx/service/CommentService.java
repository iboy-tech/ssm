package com.qmx.service;

import com.qmx.pojo.TbComment;

import java.util.List;

/**
 * @author iBoy
 * @date 2019-08-02-12:59
 */
public interface CommentService {
    List<TbComment> selectAll(Integer bid);
    boolean deleteAll(Integer bid);
    boolean delete(Integer cid);
}
