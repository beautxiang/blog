package com.zhangxiang.mapper;

import com.zhangxiang.model.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    List<Article> selectAllArticles();

    Article findArticle(Integer articleId);

    List<Article> selectAllArticlesByCategory(Integer categoryId);

    List<Article> findArticlesByTitle(String titleKeywords);

    List<Article> findArticlesByContent(String contentKeywords);

    int updateById(Article article);
}
