package com.qmx.controller;

import com.qmx.pojo.TbBlog;
import com.qmx.service.BlogService;
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
 * @date 2019-08-02-12:56
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CommentService commentService;


    private Logger logger=Logger.getLogger(BlogController.class);

    @RequestMapping("/select")
    public String selectAll(@RequestParam("id")Integer aid, Model model){
        logger.debug("我是前端获取的aid："+aid);
        List<TbBlog> list=blogService.selectAll(aid);
        logger.debug("blog调用service层成功");
        logger.debug("打印已查询的博客列表");
        System.out.println(list);
        model.addAttribute("bloglist",list);
        return "blog";
    }



    @RequestMapping("/delete")
    public String delete(@RequestParam("id") Integer bid, Model model){
            //由博客ID获取作者ID为重定向做准备
    TbBlog tbBlog=blogService.selectByPrimaryKey(bid);

        int aid=tbBlog.getAuthorId();

        if(blogService.delete(bid)){
//            删除所有博客成功之后开始删除博客的所有评论
            commentService.deleteAll(bid);
            model.addAttribute("msg","删除成功");
            }

        else{
            model.addAttribute("msg","删除失败");
        }

        String s = "redirect:/blog/select?id="+aid;
        return s;
    }
}

