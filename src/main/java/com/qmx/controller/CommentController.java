package com.qmx.controller;

import com.qmx.dao.TbCommentMapper;
import com.qmx.pojo.TbComment;
import com.qmx.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author iBoy
 * @date 2019-08-02-12:58
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private TbCommentMapper tbCommentMapper;
    Logger logger=Logger.getLogger(CommentController.class);

    @RequestMapping("/select")
    public String selectAll(@RequestParam("id") Integer bid, Model model){
        logger.debug("前端获取的博客id："+bid);
        List<TbComment> list=commentService.selectAll(bid);
        logger.debug("调用servic层成功");
        model.addAttribute("commentlist",list);
        System.out.println(list);
        return "comment";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") Integer cid, Model model){
        Logger logger=Logger.getLogger(CommentController.class);
       TbComment tbComment=tbCommentMapper.selectByPrimaryKey(cid);
        //获取对应博客的ID
        int bid=tbComment.getBlogId();
        logger.debug("我是获取的bid"+bid);
        if(commentService.delete(cid)){
            model.addAttribute("msg","删除成功");
        }
        else{
            model.addAttribute("msg","删除失败");
        }
        String s = "redirect:/comment/select?id="+bid;
        return s;
    }
}
