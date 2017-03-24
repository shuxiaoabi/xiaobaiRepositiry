package com.shu.hamal.canal.common;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * JDBC工具类<br>
 * 
 * @author shuxiaoabi
 */
public class JdbcUtil extends JdbcDaoSupport {
    private static Logger logger = LoggerFactory.getLogger(JdbcUtil.class);

    private static final int MAXACTIVE = 20;

    private static final int INITIALSIZE = 1;

    private static final long MAXWAIT = 60000;

    private static final int MAXIDLE = 20;

    private static final int MINIDLE = 1;

    private static final boolean REMOVEABANDONED = true;

    private static final int REMOVEABANDONEDTIMEOUT = 180;

    private static final long TIMEBETWEENEVICTIONRUNSMILLIS = 60000;

    private static final long MINEVICTABLEIDLETIMEMILLIS = 180000;

    private static final boolean TESTWHILEIDLE = true;

    public JdbcTemplate getJdbcTemplate(String driverClassName, String url, String username, String password) {
        // SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        BasicDataSource dataSource = new org.apache.commons.dbcp.BasicDataSource();
        try {
            // dataSource.setDriverClass((Class<? extends Driver>) Class.forName(driverClassName).newInstance().getClass());
            dataSource.setDriverClassName(driverClassName);
        } catch (Exception e) {
            logger.error("设置数据库驱动异常:" + e);
        }
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaxActive(MAXACTIVE);
        dataSource.setInitialSize(INITIALSIZE);
        dataSource.setMaxWait(MAXWAIT);
        dataSource.setMaxIdle(MAXIDLE);
        dataSource.setMinIdle(MINIDLE);
        dataSource.setRemoveAbandoned(REMOVEABANDONED);
        dataSource.setRemoveAbandonedTimeout(REMOVEABANDONEDTIMEOUT);
        dataSource.setTimeBetweenEvictionRunsMillis(TIMEBETWEENEVICTIONRUNSMILLIS);
        dataSource.setMinEvictableIdleTimeMillis(MINEVICTABLEIDLETIMEMILLIS);
        dataSource.setTestWhileIdle(TESTWHILEIDLE);
        this.setDataSource(dataSource);
        return this.getJdbcTemplate();
    }
}
