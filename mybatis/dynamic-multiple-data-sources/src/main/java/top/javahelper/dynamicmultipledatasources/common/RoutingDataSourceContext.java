package top.javahelper.dynamicmultipledatasources.common;

/**
 * @description:
 * @projectName:dynamic-multiple-data-sources
 * @see:top.javahelper.dynamicmultipledatasources.common
 * @author:郑晓龙
 * @createTime:2021/12/3 16:43
 * @version:1.0
 */
public class RoutingDataSourceContext {
    private static final ThreadLocal<String> LOOKUP_KEY_HOLDER = new ThreadLocal<>();

    public static String getRoutingKey() {
        String key = LOOKUP_KEY_HOLDER.get();
        return key == null ? "first" : key;
    }

    public static void setRoutingKey(String routingKey) {
        LOOKUP_KEY_HOLDER.set(routingKey);
    }

    public static void reset() {
        LOOKUP_KEY_HOLDER.remove();
    }
}
