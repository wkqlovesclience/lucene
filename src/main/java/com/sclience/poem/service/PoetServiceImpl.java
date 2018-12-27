package com.sclience.poem.service;

import com.sclience.poem.dao.PoetDao;
import com.sclience.poem.entity.Poet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 王克强 on 2018/7/16.
 */
@Service
@Transactional
public class PoetServiceImpl {
    @Autowired
    private PoetDao pd;

    public List<Poet> queryAllPoet(){
        return pd.selectAllPoet();
    }
    public List<Poet> queryPoet(int poet_id){
        return pd.selectPoetById(poet_id);
    }

    public List<Poet> queryPoetInPages(Integer page,Integer pageSize){
        return  pd.selectPoetInPages((page-1)*pageSize,pageSize);
    }
}
