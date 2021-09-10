package com.shell.xyxv1.core.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang.StringUtils;

/**
 * 用户上下文
 */
public class UserContextHolder {

    private ThreadLocal<Map<String, Object>> threadLocal;

    private UserContextHolder() {
        this.threadLocal = new ThreadLocal<>();
    }

    /**
     * 创建实例
     *
     * @return
     */
    public static UserContextHolder getInstance() {
        return SingletonHolder.sInstance;
    }

    /**
     * 静态内部类单例模式
     * 单例初使化
     */
    private static class SingletonHolder {
        private static final UserContextHolder sInstance = new UserContextHolder();
    }

    /**
     * 用户上下文中放入信息
     *
     * @param map
     */
    public void setContext(Map<String, Object> map) {
        threadLocal.set(map);
    }

    /**
     * 获取上下文中的信息
     *
     * @return
     */
    public Map<String, Object> getContext() {
        return threadLocal.get();
    }

    /**
     * 获取上下文中的用户名
     *
     * @return
     */
    public String getUsername() {
        String userName = null;
        if (null == threadLocal) {
            return userName;
        }
        if (null == threadLocal.get()) {
            return userName;
        }
        userName = String.valueOf(threadLocal.get().get("user_name"));
        if (StringUtils.isNotBlank(userName)) {
            return userName;
        }
        return userName;
    }

    /**
     * 获取上下文中的用户Id
     *
     * @return
     */
    public Integer getUserId() {
        return (Integer) threadLocal.get().get("user_id");
    }

    /**
     * 清空上下文
     */
    public void clear() {
        threadLocal.remove();
    }


    /**
     * 获取用户姓名
     *
     * @return
     */
    public String getName() {
        if (null == threadLocal) {
            return null;
        }
        if (null == threadLocal.get()) {
            return null;
        }
        HashMap map = (HashMap) threadLocal.get().get("detailInfo");
        return (String) map.get("name");
    }

    /**
     * 获取用户组织架构id
     *
     * @return
     */
    public Integer getOrganId() {
        ArrayList arrayList = (ArrayList) threadLocal.get().get("groupList");
        JSONArray jsonArray = (JSONArray) arrayList.get(0);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        return jsonObject.getInteger("id");
    }


    /**
     * 获取用户所有组织架构的id集合
     * @return
     */
    public List<Integer> getOrganIdList() {
        List<JSONArray> groupList = (List<JSONArray>) threadLocal.get().get("groupList");
        List<Integer> idList = groupList.stream(). map(item -> item.getJSONObject(0).getInteger("id")).collect(Collectors.toList());
        return idList;
    }

    /**
     * 获取用户所有组织架构的name集合
     *
     * @return
     */
    public List<String> getOrganNameList() {
        List<JSONArray> groupList = (List<JSONArray>) threadLocal.get().get("groupList");
        return groupList.stream().map(item -> item.getJSONObject(0).getString("name")).collect(Collectors.toList());
    }



    /**
     * 获取用户组织架构名称
     *
     * @return
     */
    public String getOrganName() {
        ArrayList arrayList = (ArrayList) threadLocal.get().get("groupList");
        JSONArray jsonArray = (JSONArray) arrayList.get(0);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        return jsonObject.getString("name");
    }

    /**
     * 获取用户组织架构的行政代码，区域代码
     * @return
     */
    public String getAreaCode() {
        ArrayList arrayList = (ArrayList) threadLocal.get().get("groupList");
        JSONArray jsonArray = (JSONArray) arrayList.get(0);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        return jsonObject.getString("areaCode");
    }

}
