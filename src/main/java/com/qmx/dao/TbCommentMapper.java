package com.qmx.dao;

import com.qmx.pojo.TbComment;

import java.util.List;

public interface TbCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbComment record);

    int insertSelective(TbComment record);

    TbComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbComment record);

    int updateByPrimaryKey(TbComment record);

    List<TbComment> selectAll(Integer id);

    int deleteAll(Integer bid);
}