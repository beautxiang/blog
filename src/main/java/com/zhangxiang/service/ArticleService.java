package com.zhangxiang.service;

import com.zhangxiang.model.Article;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ArticleService {
    List<Article> selectAllArticles();

    Article findArticle(Integer articleId);

    List<Article> selectAllArticlesByCategory(Integer categoryId);

    List<Article> findArticleByTitleOrContent(String titleKeywords, String contentKeywords);
}
