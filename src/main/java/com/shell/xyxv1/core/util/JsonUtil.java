package com.shell.xyxv1.core.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Json工具类
 */
public class JsonUtil {


    private final static Logger logger = LoggerFactory.getLogger(JsonUtil.class);


    /**
     * JSON转Map方法 (com.alibaba.fastjson)
     *
     * @param jsonStr json字符串
     * @return map
     */
    @SuppressWarnings(value = "unchecked")
    public static Map<String, Object> toMapFromJsonStr(String jsonStr) {
        if (StringUtils.isBlank(jsonStr)) {
            return new HashMap<>();
        }
        Map<String, Object> argsMap = toBeanFromStr(jsonStr, Map.class);
        return argsMap == null ? new HashMap<>() : argsMap;
    }

    /**
     * 转json字符串 (com.alibaba.fastjson)
     * jsonIgnore 无效
     *
     * @param obj 传入参（map、json等）
     * @return json字符串
     */
    public static String toJsonFromObject(Object obj) {
        if (obj == null || "".equals(obj)) {
            return "";
        }
        try {
            //     QuoteFieldNames———-输出key时是否使用双引号,默认为true
            //     WriteMapNullValue——–是否输出值为null的字段,默认为false
            //     WriteNullNumberAsZero—-数值字段如果为null,输出为0,而非null
            //     WriteNullListAsEmpty—–List字段如果为null,输出为[],而非null
            //     WriteNullStringAsEmpty—字符类型字段如果为null,输出为”“,而非null
            //     WriteNullBooleanAsFalse–Boolean字段如果为null,输出为false,而非null
            return JSON.toJSONString(obj, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullBooleanAsFalse);
        } catch (Exception e) {
            logger.error("Json转对象出错，obj=" + obj, e);
            return null;
        }
    }

    /**
     * 转json字符串 (com.alibaba.fastjson)
     * jsonIgnore 无效
     * <p>
     * <br/>
     * <b>暂未经大量实践，谨慎使用</b>
     *
     * @param obj 传入参（map、json等）
     * @return json字符串
     */
    public static String toSqlJsonFromObject(Object obj) {
        String sqlStr = toJsonFromObject(obj);
        return sqlStr == null ? null : sqlStr.replaceAll("\\\\", "\\\\\\\\");
    }


    /**
     * json 转对象
     *
     * @param jsonStr 字符串
     * @param c       class
     * @param <T>     转换对象
     * @return 对象
     */
    public static <T> T toBeanFromStr(String jsonStr, Class<T> c) {
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }
        try {
            return JSONObject.parseObject(jsonStr, c);
        } catch (Exception ex) {
            if (jsonStr.contains("\\")) {
                try {
                    jsonStr = jsonStr.replace("\\", "\\\\");
                    return JSONObject.parseObject(jsonStr, c);
                } catch (Exception e) {
                    logger.error("JSON转对象出错，jsonStr=" + jsonStr, e);
                }
            } else {
                logger.error("JSON转对象出错，jsonStr=" + jsonStr, ex);
            }
            return null;
        }
    }


    /**
     * json字符串转List(com.alibaba.fastjson)
     *
     * @param jsonStr json字符串
     * @return List
     */
    @SuppressWarnings(value = "unchecked")
    public static <T> List<T> toListFromJsonStr(String jsonStr) {
        if (StringUtils.isBlank(jsonStr)) {
            return new ArrayList<>();
        }
        List<T> argsMap;
        try {
            argsMap = JSONObject.parseObject(jsonStr, List.class);
        } catch (Exception ex) {
            if (jsonStr.contains("\\")) {
                try {
                    jsonStr = jsonStr.replace("\\", "\\\\");
                    return JSONObject.parseObject(jsonStr, List.class);
                } catch (Exception e) {
                    logger.error("JSON转List出错，jsonStr=" + jsonStr, e);
                }
            } else {
                logger.error("JSON转List出错，jsonStr=" + jsonStr, ex);
            }
            return new ArrayList<>();
        }
        return argsMap;
    }

    /**
     * json字符串转List(com.alibaba.fastjson)
     *
     * @param jsonStr json字符串
     * @return List
     */
    public static <T> List<T> toList(String jsonStr, Class<T> c) {
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }
        try {
            return JSONArray.parseArray(jsonStr, c);
        } catch (Exception ex) {
            if (jsonStr.contains("\\")) {
                try {
                    jsonStr = jsonStr.replace("\\", "\\\\");
                    return JSONArray.parseArray(jsonStr, c);
                } catch (Exception e) {
                    logger.error("JSON转List出错，jsonStr=" + jsonStr, e);
                }
            } else {
                logger.error("JSON转List出错，jsonStr=" + jsonStr, ex);
            }
            return null;
        }
    }

    public static String toJsonString(Object obj) {
        if(obj == null) {
            return "";
        }
        ObjectMapper om = new ObjectMapper();
        try {
            om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            return om.writeValueAsString(obj);
        } catch (Exception e) {
            logger.error("转Json出错。。。。。。");
            logger.error("error msg:", e);
            return null;
        }
    }

    public static <T> T fromString(String jsonString, Class<T> c) {
        ObjectMapper om = new ObjectMapper();

        try {
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return om.readValue(jsonString, c);
        } catch (Exception var4) {
            return null;
        }
    }

}
