package com.zhangxiang.mapper;

import com.zhangxiang.model.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleMapper {
    List<Article> selectAllArticles();

    Article findArticle(Integer articleId);

    List<Article> selectAllArticlesByCategory(Integer categoryId);

    List<Article> findArticlesByTitle(String titleKeywords);

    List<Article> findArticlesByContent(String contentKeywords);

    int updateById(Article article);

    void updateCommentCount(@Param("articleId") Integer articleId,@Param("articleCommentCount") Integer articleCommentCount);

    int findCommentCountByArticleId(Integer articleId);

    int addArticle(Article article);

    int deleteArticle(Integer articleId);

    List<Article> selectAllTrueArticles();

    int recoverArticle(Integer articleId);

    int deleteArticleTrue(Integer articleId);

    HashMap<String, String> deleteArticles(String[] articles);

    int updateCategoriesToZero(Integer categoryId);

    Article findArticleById(Integer articleId);

    int updateArticleById(Article article);

    List<Article> searchArticle(Map<String, Object> map);
}
