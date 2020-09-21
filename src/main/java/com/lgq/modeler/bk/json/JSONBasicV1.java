package com.lgq.modeler.bk.json;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eric on 2019/11/15.
 */
public class JSONBasicV1 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("basic1", "\"{\"assetOrderIdList\": [666911193944444928]\"}");

        String jsonStr = JSON.toJSONString(map);
        System.out.print(jsonStr);
    }
}
