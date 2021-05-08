package utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

/**
 * @author zhangyizhang01
 * @date 2020-12-23
 */
/**
 * @author zhangyizhang01
 * @date 2020-12-23
 */
public class JacksonUtil {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 对象转json字符串(Bean、List、Map)
     *
     * @param t
     * @param <T>
     * @return 字符串
     * <p>
     * 备注：默认序列化模式  null、""、默认值都参与序列化
     */
    public static <T> String objectToJsonString(T t) {
        return objectToJsonString(t, JsonInclude.Include.ALWAYS);
    }

    /**
     * 对象转json字符串(Bean、List、Map)
     *
     * @param t
     * @param include
     * @param <T>
     * @return
     */
    public static <T> String objectToJsonString(T t, JsonInclude.Include include) {
        try {
            MAPPER.setSerializationInclusion(include);
            String string = MAPPER.writeValueAsString(t);
            MAPPER.setSerializationInclusion(JsonInclude.Include.ALWAYS);
            return string;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * json字符串转对象(List、Map建议使用带泛型的转换方法)
     *
     * @param json   字符串
     * @param tClass 对象类型
     * @param <T>
     * @return
     */
    public static <T> T jsonStringToObject(String json, Class<T> tClass) {
        try {
            return MAPPER.readValue(json, tClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * json字符串转带泛型Map
     *
     * @param json     字符串
     * @param mapClass Map类型
     * @param kClass   Map键类型
     * @param vClass   Map值类型
     * @param <M>
     * @param <K>
     * @param <V>
     * @return
     */
    public static <M extends Map<K, V>, K, V> Map<K, V> jsonStringToMapWithGenericity(String json, Class<M> mapClass, Class<K> kClass, Class<V> vClass) {
        try {
            JavaType jvt = MAPPER.getTypeFactory().constructParametricType(mapClass, kClass, vClass);
            return MAPPER.readValue(json, jvt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * json字符串转带泛型List
     *
     * @param json      字符串
     * @param listClass List类型
     * @param tClass    List泛型类型
     * @param <L>
     * @param <T>
     * @return
     */
    public static <L extends List<T>, T> List<T> jsonStringToListWithGenericity(String json, Class<L> listClass, Class<T> tClass) {
        try {
            JavaType jvt = MAPPER.getTypeFactory().constructParametricType(listClass, tClass);
            return MAPPER.readValue(json, jvt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}