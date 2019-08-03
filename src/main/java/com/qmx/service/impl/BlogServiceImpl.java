package com.qmx.service.impl;

import com.qmx.dao.TbBlogMapper;
import com.qmx.dao.TbCommentMapper;
import com.qmx.pojo.TbBlog;
import com.qmx.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.apache.log4j.Logger;


/**
 * @author iBoy
 * @date 2019-08-02-12:58
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private TbBlogMapper tbBlogMapper;
    @Autowired
    private TbCommentMapper tbCommentMapper;



    @Override
    public List<TbBlog> selectAll(Integer aid) {
        Logger logger=Logger.getLogger(BlogServiceImpl.class);
        List<TbBlog>list=tbBlogMapper.selectAll(aid);
        logger.debug("blog调用dao层成功");
        logger.debug("打印已查询的博客列表"+list);
        System.out.println(list);
        return list;
    }

    @Override
    public boolean delete(Integer id) {
        if(tbBlogMapper.deleteByPrimaryKey(id)!=0){
            return true;
        }
        else{return false;
        }
        }

    @Override
    public boolean deleteAll(Integer aid) {
        if(tbBlogMapper.deleteAll(aid)!=0){
            return true;
        }
        else{return false;
        }

    }

    @Override
    public TbBlog selectByPrimaryKey(Integer bid) {
        TbBlog tbBlog=tbBlogMapper.selectByPrimaryKey(bid);
        if(tbBlog!=null){
            return tbBlog;
        }
        else{return null;
        }

    }

}
