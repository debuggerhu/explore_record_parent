package com.hhx.common.utils;

import com.hhx.common.constants.Application;
import com.hhx.common.constants.Service;
import com.hhx.common.constants.authority.BaseAuthorities;
import com.hhx.common.dto.usercenter.ActionUpdateDTO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author su Lichen
 * @Date 2020/6/10 10:32
 */
public class SynchronizeActionUtil {
    public static void synchronize(HttpUtil httpUtil, Application application, List<BaseAuthorities> authorities, int retry) {
        ActionUpdateDTO actionUpdateDTO = new ActionUpdateDTO(application.getCode(), authorities.stream().map(
                authority -> new ActionUpdateDTO.Action(
                        authority.getActionName(),
                        authority.getAlias(),
                        authority.getModuleName()
                )
        ).collect(Collectors.toList()));

        try {
            httpUtil.postViaJson(
                    "http://" + Service.USER_CENTER + "/authorization/synchronizeAction",
                    actionUpdateDTO,
                    Boolean.class
            );
        } catch (Exception e) {
            e.printStackTrace();
            // 因为集群如果同时启动，可能用户中心还没在线，所以第一次可能会请求失败，所以需要每分钟重试，一共十次
            try {
                Thread.sleep(1000 * 60);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            if (retry < 9) {
                synchronize(httpUtil, application, authorities, ++retry);
            }

        }
    }
}
