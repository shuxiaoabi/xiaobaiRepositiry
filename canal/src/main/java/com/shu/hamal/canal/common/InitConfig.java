package com.shu.hamal.canal.common;

import java.io.File;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 加载配置文件内容<br>
 * 
 * @author shuxiaobai
 */
public class InitConfig {

    public static String SPLIT_REGEX = ";;";

    public static Map<String, ConfigEntity> configMap = new ConcurrentHashMap<String, ConfigEntity>();

    public static Map<String, Vector<String>> listMap = new ConcurrentHashMap<String, Vector<String>>();

    static {
        /** 生成SQL文件目录 */
        String[] canalSqlDirectory = HamalPropertyConfigurer.getHamalProperty("canal.sql.directory").trim().replaceAll("\\\\", "\\" + File.separator)
                .replaceAll("/", "\\" + File.separator).split(SPLIT_REGEX);

        /** 读取SQL文件目录 */
        String[] canalMonitorDirectory = HamalPropertyConfigurer.getHamalProperty("canal.monitor.directory").trim()
                .replaceAll("\\\\", "\\" + File.separator).replaceAll("/", "\\" + File.separator).split(SPLIT_REGEX);

        /** canal服务器信息 */
        // String[] inetSocketAddress = HamalPropertyConfigurer.getHamalProperty("inet.socket.address").trim().split(SPLIT_REGEX);
        //
        // String[] inetSocketPort = HamalPropertyConfigurer.getHamalProperty("inet.socket.port").trim().split(SPLIT_REGEX);
        //
        // String[] canalDestination = HamalPropertyConfigurer.getHamalProperty("canal.destination").trim().split(SPLIT_REGEX);
        //
        // String[] canalUsername = HamalPropertyConfigurer.getHamalProperty("canal.username").trim().split(SPLIT_REGEX);
        //
        // String[] canalPassword = HamalPropertyConfigurer.getHamalProperty("canal.password").trim().split(SPLIT_REGEX);

        /** 目标库配置 */
        String[] jdbcDriverClassName = HamalPropertyConfigurer.getHamalProperty("jdbc.driverClassName").trim().split(SPLIT_REGEX);

        String[] jdbcUrl = HamalPropertyConfigurer.getHamalProperty("jdbc.url").trim().split(SPLIT_REGEX);

        String[] jdbcUsername = HamalPropertyConfigurer.getHamalProperty("jdbc.username").trim().split(SPLIT_REGEX);

        String[] jdbcPassword = HamalPropertyConfigurer.getHamalProperty("jdbc.password").trim().split(SPLIT_REGEX);

        String[] jdbcDialect = HamalPropertyConfigurer.getHamalProperty("jdbc.dialect").trim().split(SPLIT_REGEX);

        /** memcached配置 */
        String[] memcachedIp = HamalPropertyConfigurer.getHamalProperty("memcached.ip").trim().split(SPLIT_REGEX);

        String[] memcachedPort = HamalPropertyConfigurer.getHamalProperty("memcached.port").trim().split(SPLIT_REGEX);

        String[] memcachedTableName = HamalPropertyConfigurer.getHamalProperty("memcached.tableName").trim().split(SPLIT_REGEX);

        String[] memcachedTableNameKeyfield = HamalPropertyConfigurer.getHamalProperty("memcached.tableName.keyfield").trim().split(SPLIT_REGEX);

        String[] memcachedTableNameValuefield = HamalPropertyConfigurer.getHamalProperty("memcached.tableName.valuefield").trim().split(SPLIT_REGEX);

        for (int i = 0; i < jdbcUrl.length; i++) {
            String jdbcName = jdbcUrl[i].substring(jdbcUrl[i].lastIndexOf("/") + 1);
            ConfigEntity configEntity = new ConfigEntity(canalSqlDirectory.length > i ? canalSqlDirectory[i] : canalSqlDirectory[0],
                    canalMonitorDirectory.length > i ? canalMonitorDirectory[i] : canalMonitorDirectory[0],
                    jdbcDriverClassName.length > i ? jdbcDriverClassName[i] : jdbcDriverClassName[0], jdbcUrl.length > i ? jdbcUrl[i] : jdbcUrl[0],
                    jdbcUsername.length > i ? jdbcUsername[i] : jdbcUsername[0], jdbcPassword.length > i ? jdbcPassword[i] : jdbcPassword[0],
                    jdbcDialect.length > i ? jdbcDialect[i] : jdbcDialect[0], memcachedIp.length > i ? memcachedIp[i] : memcachedIp[0],
                    memcachedPort.length > i ? memcachedPort[i] : memcachedPort[0], memcachedTableName.length > i ? memcachedTableName[i]
                            : memcachedTableName[0], memcachedTableNameKeyfield.length > i ? memcachedTableNameKeyfield[i]
                            : memcachedTableNameKeyfield[0], memcachedTableNameValuefield.length > i ? memcachedTableNameValuefield[i]
                            : memcachedTableNameValuefield[0], jdbcName);
            configMap.put(jdbcName, configEntity);
            listMap.put(jdbcName, new Vector<String>());
        }
    }

    public static synchronized void operList() {

    }
}
