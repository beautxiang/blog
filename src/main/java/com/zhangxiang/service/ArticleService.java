package com.zhangxiang.service;

import com.zhangxiang.model.Article;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public interface ArticleService {
    List<Article> selectAllArticles();

    Article findArticle(Integer articleId);

    List<Article> selectAllArticlesByCategory(Integer categoryId);

    List<Article> findArticleByTitleOrContent(String titleKeywords, String contentKeywords);

    int articleLikeById(HttpServletRequest request, HttpServletResponse response, Integer articleId);
}
