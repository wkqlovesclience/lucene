package com.sclience.poem.service;

import com.sclience.poem.dao.PoetDao;
import com.sclience.poem.dao.PoetryDao;
import com.sclience.poem.entity.Poet;
import com.sclience.poem.entity.Poetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 王克强 on 2018/7/16.
 */
@Service
@Transactional
public class PoetryServiceImpl {
    @Autowired
    private PoetryDao pd;

    public List<Poetry> queryAllPoetry(){
        return pd.selectAllPoetry();
    }
    public List<Poetry> queryPoetry(int poetry_id){
        return pd.selectPoetryById(poetry_id);
    }

    public List<Poetry> queryPoetryInPages(Integer page,Integer pageSize){
        return  pd.selectPoetryInPages((page-1)*pageSize,pageSize);
    }
}
