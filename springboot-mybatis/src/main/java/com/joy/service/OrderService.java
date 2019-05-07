package com.joy.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joy.dao.OrderMapper;
import com.joy.pojo.PreOrder;

@Service
public class OrderService {

    @Autowired
    private OrderMapper mapper;

    public List<PreOrder> queryList() {
        return mapper.queryList();
    }

    public PreOrder findById(long userId) {
        System.out.println("userId:" + userId);
        return mapper.findById(userId);
    }

    public int insertEntity() {
        PreOrder entity = new PreOrder();
        entity.setUserName("lisi");
        entity.setUserCode("lisi" + new Date());
        entity.setNickName("郭靖");
        entity.setUserPwd("123");
        entity.setCreateDate(new Date());
        entity.setUpdateDate(new Date());
        return mapper.insertEntity(entity);
    }

    public int insertParam() {
        return mapper.insertParam("linzhiqiang", "lzq");
    }

    public int insertByMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("nickName", "zhaotong");
        map.put("userCode", "zt");
        return mapper.insertByMap(map);
    }

    public int updateEntity() {
        PreOrder entity = new PreOrder();
        entity.setUserId(1);
        entity.setNickName("郭靖");
        return mapper.updateEntity(entity);
    }

    public int deleteEntity() {
        PreOrder entity = new PreOrder();
        entity.setUserId(11);
        return mapper.deleteEntity(entity);
    }
}
