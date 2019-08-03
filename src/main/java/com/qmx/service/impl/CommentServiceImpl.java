package com.qmx.service.impl;

import com.qmx.dao.TbCommentMapper;
import com.qmx.pojo.TbComment;
import com.qmx.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author iBoy
 * @date 2019-08-02-12:59
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private TbCommentMapper tbCommentMapper;

    @Override
    public List<TbComment> selectAll(Integer id) {
        List<TbComment>list=tbCommentMapper.selectAll(id);
        return list;
    }

    @Override
    public boolean deleteAll(Integer bid) {
        if(tbCommentMapper.deleteAll(bid)!=0)
        {return true;
        }
        else{return false;
        }

    }

    @Override
    public boolean delete(Integer cid) {
        if(tbCommentMapper.deleteByPrimaryKey(cid)!=0){
            return true;
        }
        else{
            return false;
        }

    }
}
