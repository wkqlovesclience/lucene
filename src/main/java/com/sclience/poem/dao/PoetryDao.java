package com.sclience.poem.dao;

import com.sclience.poem.entity.Poet;
import com.sclience.poem.entity.Poetry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 王克强 on 2018/7/16.
 */
public interface PoetryDao {

    public List<Poetry> selectPoetryById(@Param("poetry_id") int poetry_id);
    public List<Poetry> selectAllPoetry();
    public List<Poetry> selectPoetryInPages(@Param("begin") int begin,@Param("pageSize") int pageSize);

}
