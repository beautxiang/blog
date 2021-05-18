package com.zhangxiang.controller;
import com.alibaba.fastjson.JSONObject;
import com.zhangxiang.model.*;
import com.zhangxiang.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private MessageService messageService;

    // 登录验证
    @PostMapping("/loginVerify")
    public String login(HttpServletRequest request,
                        HttpServletResponse response,
                        @RequestParam(value = "adminName") String adminName,
                        @RequestParam(value = "password") String password
    ) {

        Map<String, Object> map = new HashMap<String, Object>();
        // 根据前端传来的用户名去数据库中寻找有木有相对应的用户
        Admin admin = adminService.findAdminByName(adminName);
        if (admin == null) {
            map.put("code", 0);
            map.put("msg", "无此用户");
        } else if (!password.equals(admin.getAdminPassword())) {

            map.put("code", 0);
            map.put("msg", "密码错误");
        } else {
            map.put("code", 1);
            map.put("msg", "登录成功");
            //添加session 此项会自动的将sessionid写入cookie中
            request.getSession().setAttribute("admin", admin);
        }
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            map.put(cookie.getName(), cookie.getValue());
        }
        return new JSONObject(map).toString();
    }

    // 得到所有的文章，包括文章状态为0的
    @GetMapping("/article/list")
    public List<Article> selectAllArticles(HttpServletRequest request) {
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        System.out.printf(admin.getAdminName());
        System.out.printf(admin.getAdminPassword());

        return articleService.selectAllArticles();
    }

    // 新增一篇文章
    @PostMapping("/article/add")
    public HashMap<String, String> addArticle(HttpServletRequest request,
                                              HttpServletResponse response) {

        HashMap<String, String> map = new HashMap<>();
        int i = articleService.addArticle(request);
        System.out.println(i);
        if (i == 0) {
            map.put("msg", "添加失败");
        } else {
            map.put("msg", "新增文章成功");
        }
        return map;
    }

    @GetMapping("/article/{articleId}")
    public Article findArticleById(@PathVariable String articleId) {
        return articleService.findArticleById(articleId);
    }


    // 删除一篇文章(第一次点击是假删除，第二次点击是真删除)
    @PostMapping("/article/{articleId}/delete")
    public HashMap<String, String> deleteArticle(@PathVariable Integer articleId) {


        int i = articleService.deleteArticle(articleId);
        HashMap<String, String> map = new HashMap<>();
        if (i == 0) {
            map.put("msg", "删除失败");
        } else {
            map.put("msg", "成功删除id为" + articleId + "的文章");
        }
        return map;
    }

    @PostMapping("/articles/{articleIds}/delete")
    public HashMap<String, String> deleteArticle(@PathVariable String articleIds) {
        String[] articles = articleIds.split(",");
        System.out.println(Arrays.toString(articles));
        int i = articleService.deleteArticles(articles);
        HashMap<String, String> map = new HashMap<>();
        if (i == 0) {
            map.put("msg", "删除失败");
        } else {
            map.put("msg", "成功删除id为" + articleIds + "的文章" + "，共计" + i + "篇文章");
        }
        return map;
    }

    // 将假删除的文章恢复，使其在用户界面可见
    @PostMapping("/article/{articleId}/recover")
    public HashMap<String, String> recoverArticle(@PathVariable Integer articleId) {

        int i = articleService.recoverArticle(articleId);
        HashMap<String, String> map = new HashMap<>();
        if (i == 0) {
            map.put("msg", "恢复失败");
        } else {
            map.put("msg", "成功恢复id为" + articleId + "的文章");
        }
        return map;
    }

    // 根据条件来搜索
    @GetMapping("/article/search")
    public List<Article> searchArticle(HttpServletRequest request,

                                       @RequestParam(name = "categoryId", required = false) Integer categoryId,
                                       @RequestParam(name = "articleTitle", required = false) String articleTitle,
                                       @RequestParam(name = "articleContent", required = false) String articleContent,
                                       @RequestParam(name = "articleCreationTimeBegin", required = false) String articleCreationTimeBegin,
                                       @RequestParam(name = "articleCreationTimeOver", required = false) String articleCreationTimeOver,
                                       @RequestParam(name = "articleStatus", required = false) Integer articleStatus
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("categoryId", categoryId);
        map.put("articleTitle", articleTitle);
        map.put("articleContent", articleContent);
        if (articleCreationTimeBegin.equals("") && articleCreationTimeOver.equals("")) {
            map.put("articleCreationTimeBegin", null);
            map.put("articleCreationTimeOver", null);
        } else {
            map.put("articleCreationTimeBegin", articleCreationTimeBegin);
            map.put("articleCreationTimeOver", articleCreationTimeOver);
        }
        map.put("articleStatus", articleStatus);

        Map<String, String[]> parameterMap = request.getParameterMap();
        return articleService.searchArticle(map);
    }

    @PostMapping("/article/{articleId}/update")
    public HashMap<String, String> updateArticleById(HttpServletRequest request, @PathVariable Integer articleId) {
        HashMap<String, String> map = new HashMap<>();
        int i = articleService.updateArticleById(request, articleId);
        System.out.println(i);
        if (i == 0) {
            map.put("msg", "添加失败");
        } else {
            map.put("msg", "修改文章成功");
        }
        return map;
    }


    @GetMapping("/category/list")
    public List<Category> selectAllCategories() {
        return categoryService.selectAllCategories();
    }


    @PostMapping("/category/add")
    public HashMap<String, String> addCategory(@RequestPart(value = "file", required = false) MultipartFile file,
                                               @RequestParam(value = "categoryName", required = true) String categoryName) throws IOException {
        // 如果上传了图片
        String path = null;
        String categoryPhoto = null;
        if (!file.isEmpty()) {
            String originalFilename = file.getOriginalFilename();
            path = "D:\\java\\category\\image\\" + originalFilename;
            System.out.println(path);
            file.transferTo(new File(path));
            categoryPhoto = "http://localhost:8080/category/image/" + file.getOriginalFilename();
        }
        int i = categoryService.addCategory(categoryPhoto, categoryName);
        HashMap<String, String> map = new HashMap<>();
        if (i == 0) {
            map.put("msg", "新增失败");
        } else {
            map.put("msg", "成功新增分类名为" + categoryName + "，在服务端存储的路径为：" + path);
        }
        return map;
    }

    @PostMapping("category/{categoryId}/update")
    public HashMap<String, String> addCategory(@RequestPart(value = "file", required = false) MultipartFile file,
                                               @RequestParam(value = "categoryName", required = false) String categoryName,
                                               @PathVariable Integer categoryId) throws IOException {
        String path = null;
        String categoryPhoto = null;
        if (file != null) {
            String originalFilename = file.getOriginalFilename();
            path = "D:\\java\\category\\image\\" + originalFilename;
            System.out.println(path);
            file.transferTo(new File(path));
            categoryPhoto = "http://localhost:8080/category/image/" + file.getOriginalFilename();
        }

        int i = 0;
        if (categoryPhoto == null) {
            i = categoryService.updateCategoryById(categoryId, categoryName);
        } else {
            i = categoryService.updateCategoryById(categoryId, categoryName, categoryPhoto);
        }

        HashMap<String, String> map = new HashMap<>();
        if (i == 0) {
            map.put("msg", "更新失败");
        } else {
            map.put("msg", "成功更新分类id为" + categoryId + "的分类名为：" + categoryName + "在服务端存储图片的地址为:" + path);
        }
        return map;
    }

    @PostMapping("/category/{categoryId}/delete")
    public HashMap<String, String> deleteCategory(@PathVariable String categoryId) {

        int i = categoryService.deleteCategory(Integer.valueOf(categoryId));
        HashMap<String, String> map = new HashMap<>();
        if (i == 0) {
            map.put("msg", "删除失败");
        } else {
            map.put("msg", "成功删除categoryId为" + categoryId + "的分类");
        }
        return map;
    }


    @GetMapping("/comment/list")
    public List<Comment> selectComments() {
        return commentService.selectComments();
    }


    @PostMapping("/comment/{commentId}/delete")
    public HashMap<String, String> deleteComment(@PathVariable Integer commentId) {
        int i = commentService.deleteCommentById(commentId);
        HashMap<String, String> map = new HashMap<>();
        if (i == 0) {
            map.put("msg", "删除失败");
        } else {
            map.put("msg", "成功删除id为" + commentId + "的评论");
        }
        return map;
    }


    @GetMapping("/message/list")
    public List<Message> selectMessages() {
        return messageService.selectAllMessage();
    }


    @PostMapping("/message/delete")
    public HashMap<String, String> deleteMessage() {
        return null;
    }

}
