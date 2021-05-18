package com.zhangxiang.mapper;

import com.zhangxiang.model.About;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AboutMapper {
    About getAbout();

    int updateAbout(About about);
}
