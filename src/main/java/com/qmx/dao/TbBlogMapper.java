package com.qmx.dao;

import com.qmx.pojo.TbBlog;

import java.util.List;

public interface TbBlogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbBlog record);

    int insertSelective(TbBlog record);

    TbBlog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbBlog record);

    int updateByPrimaryKey(TbBlog record);

    List<TbBlog> selectAll(Integer aid);

    int deleteAll(Integer aid);
}