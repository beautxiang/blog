package com.zhangxiang.service.impl;

import com.zhangxiang.mapper.ArticleMapper;
import com.zhangxiang.model.Article;
import com.zhangxiang.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @Override
    public int articleLikeById(HttpServletRequest request, HttpServletResponse response, Integer articleId) {
        Cookie[] cookies = request.getCookies();
        // 建立一个是否喜欢的标志位，默认为不喜欢
        Boolean isLike = false;
        if (!(cookies == null)) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("isLike") && cookie.getValue().equals("1")) {
                    isLike = true;
                }
            }
        }

        Article article = articleMapper.findArticle(articleId);
        // 点按一次后就是喜欢，即使cookies为null也会执行
        if (!isLike) {
            article.setArticleLikeCount(article.getArticleLikeCount() + 1);
            articleMapper.updateById(article);
            response.addCookie(new Cookie("isLike", "1"));
            return articleMapper.findArticle(articleId).getArticleLikeCount();
        } else {
            article.setArticleLikeCount(article.getArticleLikeCount() - 1);
            articleMapper.updateById(article);
            response.addCookie(new Cookie("isLike", "0"));
            return articleMapper.findArticle(articleId).getArticleLikeCount();
        }
    }

    @Override
    public int updateCommentCount(Integer articleId) {
        int articleCommentCount = articleMapper.findCommentCountByArticleId(articleId);
        articleMapper.updateCommentCount(articleId, articleCommentCount);
        return articleCommentCount;
    }

    @Override
    public int addArticle(HttpServletRequest request) {
        String articleTitle = request.getParameter("articleTitle");
        String articleContent = request.getParameter("articleContent");
        Integer articleStatus = Integer.valueOf(request.getParameter("articleStatus"));
        Integer categoryId = Integer.valueOf(request.getParameter("categoryId"));
        Integer adminId = Integer.valueOf(request.getParameter("adminId"));
        Date articleCreationTime = new Date();
        Article article = new Article(articleTitle, articleContent, articleStatus, articleCreationTime, categoryId, adminId);
        System.out.println(article);
        return articleMapper.addArticle(article);
    }

    @Override
    public int deleteArticle(Integer articleId) {
        Article article = articleMapper.findArticle(articleId);
        if (article.getArticleStatus() == 1) {
            return articleMapper.deleteArticle(articleId);
        } else  {
            return articleMapper.deleteArticleTrue(articleId);
        }
    }

    @Override
    public List<Article> selectAllTrueArticles() {
        return articleMapper.selectAllTrueArticles();
    }

    @Override
    public int recoverArticle(Integer articleId) {
        return articleMapper.recoverArticle(articleId);
    }

    @Override
    public int deleteArticles(String[] articles) {
        int count = 0;
        for (String article : articles) {
            articleMapper.deleteArticle(Integer.valueOf(article));
            count++;
        }
        return count;
    }

    @Override
    public Article findArticleById(String articleId) {
        return articleMapper.findArticleById(Integer.valueOf(articleId));
    }

    @Override
    public int updateArticleById(HttpServletRequest request, Integer articleId) {
        String articleTitle = request.getParameter("articleTitle");
        String articleContent = request.getParameter("articleContent");
        Integer articleStatus = Integer.valueOf(request.getParameter("articleStatus"));
        Integer categoryId = Integer.valueOf(request.getParameter("categoryId"));
        Integer adminId = Integer.valueOf(request.getParameter("adminId"));
        Article article = new Article(articleId, articleTitle, articleContent, articleStatus, categoryId);
        return articleMapper.updateArticleById(article);
    }

    @Override
    public List<Article> searchArticle(Map<String, Object> map) {
        return articleMapper.searchArticle(map);
    }

}
