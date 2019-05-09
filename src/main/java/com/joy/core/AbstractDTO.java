package com.joy.core;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * Title:
 * Description:
 * Copyright: 2019 聚好联信息技术有限公司 版权所有.保留所有权
 * Company:聚好联信息技术有限公司
 * Author: KylerTien
 * Create Time:2019/5/9
 */
public class AbstractDTO implements Serializable {

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
