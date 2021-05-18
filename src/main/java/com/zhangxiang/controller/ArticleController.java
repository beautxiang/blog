package com.zhangxiang.controller;

import com.zhangxiang.model.Article;
import com.zhangxiang.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/article/list")
    public List<Article> returnAllArticles() {
        return articleService.selectAllTrueArticles();
    }

    @GetMapping("/article/{articleId}")
    public Article returnArticleDetail(@PathVariable("articleId") Integer articleId) {
        Article article = articleService.findArticle(articleId);
        if (article.getArticleStatus() == 0) {
            return null;
        } else {
            return article;
        }
    }

    @GetMapping("/articleCategory/{categoryId}")
    public List<Article> returnArticlesByCategory(@PathVariable Integer categoryId) {
        return articleService.selectAllArticlesByCategory(categoryId);
    }

    @GetMapping("/article/search")
    public List<Article> searchArticleByTitleOrContent(@RequestParam(name = "titleKeywords", required = false) String titleKeywords,
                                                       @RequestParam(name = "contentKeywords", required = false) String contentKeywords) {
        List<Article> articleByTitleOrContent = articleService.findArticleByTitleOrContent(titleKeywords, contentKeywords);
        if (articleByTitleOrContent.get(0) == null || articleByTitleOrContent.get(0).getArticleStatus() == 0) {
            return null;
        } else {
            return articleByTitleOrContent;
        }
    }

    @PostMapping("/article/{articleId}/like")
    public int articleLikeById(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer articleId) {
        return articleService.articleLikeById(request, response, articleId);
    }

}
