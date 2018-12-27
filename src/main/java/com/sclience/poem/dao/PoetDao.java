package com.sclience.poem.dao;

import com.sclience.poem.entity.Poet;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 王克强 on 2018/7/16.
 */
public interface PoetDao {

    public List<Poet> selectPoetById(@Param("poet_id") int poet_id);
    public List<Poet> selectAllPoet();
    public List<Poet> selectPoetInPages(@Param("begin") int begin,@Param("pageSize") int pageSize);

}
