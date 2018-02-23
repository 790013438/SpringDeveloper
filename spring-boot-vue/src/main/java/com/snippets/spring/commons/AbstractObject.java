package com.snippets.spring.commons;

import com.alibaba.fastjson.JSON;

public class AbstractObject {

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
