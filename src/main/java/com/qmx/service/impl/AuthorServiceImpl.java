package com.qmx.service.impl;

import com.qmx.dao.TbAuthorMapper;
import com.qmx.dao.TbBlogMapper;
import com.qmx.dao.TbCommentMapper;
import com.qmx.pojo.TbAuthor;
import com.qmx.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.apache.log4j.Logger;

/**
 * @author iBoy
 * @date 2019-08-01-20:05
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private TbAuthorMapper tbAuthorMapper;
    @Autowired
    private TbBlogMapper tbBlogMapper;
    @Autowired
    private TbCommentMapper tbCommentMapper;


    @Override
    public List<TbAuthor> selectAll() {
        Logger logger=Logger.getLogger(AuthorServiceImpl.class);
        List<TbAuthor> list=tbAuthorMapper.selectAll();
        logger.debug("调用Dao层成功");
        return list;
    }

    @Override
    public boolean delete(Integer id) {

        if(tbAuthorMapper.deleteByPrimaryKey(id)!=0){
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public boolean deleteAll(Integer bid) {
        return false;
    }

    @Override
    public TbAuthor selectAuthoById(Integer id) {
        if(tbAuthorMapper.selectByPrimaryKey(id)!=null){
            return tbAuthorMapper.selectByPrimaryKey(id);
        }
        else{return null;
        }

    }

    @Override
    public boolean update(TbAuthor tbAuthor) {
        if(tbAuthorMapper.updateByPrimaryKeySelective(tbAuthor)!=0){
            return  true;
        }
        else{return false;
        }

    }


}
