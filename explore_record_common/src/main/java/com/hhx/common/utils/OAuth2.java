package com.hhx.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.hhx.common.constants.Service;

import java.util.HashMap;
import java.util.Map;

public class OAuth2 {

    final HttpUtil httpUtil;

    public OAuth2(HttpUtil httpUtil) {
        this.httpUtil = httpUtil;
    }

    public String getClusterToken() {
        Map<String, String> clientCredentials = new HashMap<>();
        clientCredentials.put("grant_type", "client_credentials");
        clientCredentials.put("client_id", "wisonic-cloud");
        clientCredentials.put("client_secret", "hnj3ht903b2ggwf");

        JSONObject response = httpUtil.postViaForm(
                "http://" + Service.USER_CENTER + "/oauth/token",
                clientCredentials
        );

        return response.getString("access_token");
    }
}
