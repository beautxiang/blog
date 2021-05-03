package com.zhangxiang.service.impl;

import com.zhangxiang.mapper.ArticleMapper;
import com.zhangxiang.model.Article;
import com.zhangxiang.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> selectAllArticles() {
        return articleMapper.selectAllArticles();
    }

    @Override
    public Article findArticle(Integer articleId) {
        Article article = articleMapper.findArticle(articleId);
        if (article.getArticleViewCount() == null || article.getArticleViewCount() == 0) {
            article.setArticleViewCount(1);
        } else {
            article.setArticleViewCount(article.getArticleViewCount() + 1);
        }
        articleMapper.updateById(article);
        return articleMapper.findArticle(articleId);
    }

    @Override
    public List<Article> selectAllArticlesByCategory(Integer categoryId) {
        return articleMapper.selectAllArticlesByCategory(categoryId);
    }

    @Override
    public List<Article> findArticleByTitleOrContent(String titleKeywords, String contentKeywords) {
        if (titleKeywords == null && contentKeywords == null) {
            return articleMapper.selectAllArticles();
        } else if (titleKeywords != null && contentKeywords == null) {
            return articleMapper.findArticlesByTitle(titleKeywords);
        } else {
            return articleMapper.findArticlesByContent(contentKeywords);
        }
    }

}
