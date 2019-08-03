package com.qmx.controller;

import com.qmx.dao.TbBlogMapper;
import com.qmx.dao.TbCommentMapper;
import com.qmx.pojo.TbAuthor;
import com.qmx.pojo.TbBlog;
import com.qmx.service.AuthorService;
import com.qmx.service.BlogService;
import com.qmx.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author iBoy
 * @date 2019-08-01-20:36
 */
@Controller
@RequestMapping (value ="/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BlogService blogService;
    @Autowired
    private CommentService commentService;

    private Logger logger=Logger.getLogger(AuthorController.class);

    /**
     * @param model
     * @return
     */

    @RequestMapping(value = "/select")
    public String selectAll(Model model){
         List<TbAuthor> list=  authorService.selectAll();
        System.out.println(list);
        logger.debug("调用service层成功");
         model.addAttribute("authorlist",list);
         return "author";
    }


    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String toInfoPage(Integer id,Model model){
        TbAuthor tbAuthor=authorService.selectAuthoById(id);
        model.addAttribute("author",tbAuthor);
        return "info";
    }
    @RequestMapping(value = "/update",method =RequestMethod.POST)
    public String update(Model model,TbAuthor tbAuthor){
        System.out.println("我是获取的作者"+tbAuthor);
        if(authorService.update(tbAuthor)){
            model.addAttribute("msg","修改成功");
        }
        else{
            model.addAttribute("msg","修改失败");
        }
        return "redirect:/author/select";
    }



    @RequestMapping("/delete")
    public String delete(@RequestParam("id") Integer aid, Model model){

            logger.debug("调用删除作者方法，获取的作者id是"+aid);
        if(authorService.delete(aid)){

            //删除作者成功之后开始删除博客-删除了所有的博客
            blogService.deleteAll(aid);
            //删除博客之后开始删除所有的评论
            List<TbBlog> tbBlogList=blogService.selectAll(aid);
            for (int i = 0; i < tbBlogList.size(); i++) {
                TbBlog tbBlog=tbBlogList.get(i);
                commentService.deleteAll(tbBlog.getId());
            }

            model.addAttribute("msg","删除成功");
        }
        else{
            model.addAttribute("msg","删除失败");
        }
        return "redirect:/author/select";
    }

    }

