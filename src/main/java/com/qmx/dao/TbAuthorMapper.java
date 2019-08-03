package com.qmx.dao;

import com.qmx.pojo.TbAuthor;

import java.util.List;

public interface TbAuthorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbAuthor record);

    int insertSelective(TbAuthor record);

    TbAuthor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbAuthor record);

    int updateByPrimaryKey(Integer record);

    List<TbAuthor> selectAll();
}