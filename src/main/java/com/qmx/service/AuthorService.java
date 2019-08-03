package com.qmx.service;

import com.qmx.dao.TbAuthorMapper;
import com.qmx.pojo.TbAuthor;

import java.util.List;

/**
 * @author iBoy
 * @date 2019-08-01-20:04
 */
public interface AuthorService {
//    public  void  test();
//    TbAuthor selectByPrimaryKey(Integer id);

    List<TbAuthor> selectAll();

    boolean delete(Integer aid);
    boolean deleteAll(Integer bid);

    TbAuthor selectAuthoById(Integer id);

    boolean update(TbAuthor tbAuthor);
}
