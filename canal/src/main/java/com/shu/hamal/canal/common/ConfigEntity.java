package com.shu.hamal.canal.common;

import java.io.File;

/**
 * 配置实体类<br>
 * 
 * @author shuxiabai
 */
public class ConfigEntity {

    /** 生成SQL文件目录 */
    private String canalSqlDirectory;

    /** 读取SQL文件目录 */
    private String canalMonitorDirectory;

    /** canal服务器信息 */
    // private String inetSocketAddress;
    //
    // private String inetSocketPort;
    //
    // private String canalDestination;
    //
    // private String canalUsername;
    //
    // private String canalPassword;

    /** 目标库配置 */
    private String jdbcDriverClassName;

    private String jdbcUrl;

    private String jdbcUsername;

    private String jdbcPassword;

    private String jdbcDialect;

    private String jdbcName;

    /** memcached配置 */
    private String memcachedIp;

    private String memcachedPort;

    private String memcachedTableName;

    private String memcachedTableNameKeyfield;

    private String memcachedTableNameValuefield;

    /** 索引文件 */
    private File updateFile = null;

    private File clientFile = null;

    /**
     * @param canalSqlDirectory
     * @param canalMonitorDirectory
     * @param jdbcDriverClassName
     * @param jdbcUrl
     * @param jdbcUsername
     * @param jdbcPassword
     * @param jdbcDialect
     * @param memcachedIp
     * @param memcachedPort
     * @param memcachedTableName
     * @param memcachedTableNameKeyfield
     * @param memcachedTableNameValuefield
     */
    public ConfigEntity(String canalSqlDirectory, String canalMonitorDirectory, String jdbcDriverClassName, String jdbcUrl, String jdbcUsername,
            String jdbcPassword, String jdbcDialect, String memcachedIp, String memcachedPort, String memcachedTableName,
            String memcachedTableNameKeyfield, String memcachedTableNameValuefield, String jdbcName) {
        super();
        this.canalSqlDirectory = canalSqlDirectory;
        this.canalMonitorDirectory = canalMonitorDirectory;
        this.jdbcDriverClassName = jdbcDriverClassName;
        this.jdbcUrl = jdbcUrl;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
        this.jdbcDialect = jdbcDialect;
        this.memcachedIp = memcachedIp;
        this.memcachedPort = memcachedPort;
        this.memcachedTableName = memcachedTableName;
        this.memcachedTableNameKeyfield = memcachedTableNameKeyfield;
        this.memcachedTableNameValuefield = memcachedTableNameValuefield;
        this.jdbcName = jdbcName;
        if (null != canalMonitorDirectory && !"".equals(canalMonitorDirectory)) {
            // 在in文件夹下初始化索引文件
            this.updateFile = new File(canalMonitorDirectory + File.separator + FileIndexUtil.update_index);
            this.clientFile = new File(canalMonitorDirectory + File.separator + FileIndexUtil.client_index);
            FileIndexUtil.initFile(this.updateFile, this.clientFile);
            File file = new File(canalSqlDirectory);
            if (!file.isDirectory())
                file.mkdirs();
        }
    }

    /**
     * @return the canalSqlDirectory
     */
    public String getCanalSqlDirectory() {
        return canalSqlDirectory;
    }

    /**
     * @param canalSqlDirectory the canalSqlDirectory to set
     */
    public void setCanalSqlDirectory(String canalSqlDirectory) {
        this.canalSqlDirectory = canalSqlDirectory;
    }

    /**
     * @return the canalMonitorDirectory
     */
    public String getCanalMonitorDirectory() {
        return canalMonitorDirectory;
    }

    /**
     * @param canalMonitorDirectory the canalMonitorDirectory to set
     */
    public void setCanalMonitorDirectory(String canalMonitorDirectory) {
        this.canalMonitorDirectory = canalMonitorDirectory;
    }

    /**
     * @return the jdbcDriverClassName
     */
    public String getJdbcDriverClassName() {
        return jdbcDriverClassName;
    }

    /**
     * @param jdbcDriverClassName the jdbcDriverClassName to set
     */
    public void setJdbcDriverClassName(String jdbcDriverClassName) {
        this.jdbcDriverClassName = jdbcDriverClassName;
    }

    /**
     * @return the jdbcUrl
     */
    public String getJdbcUrl() {
        return jdbcUrl;
    }

    /**
     * @param jdbcUrl the jdbcUrl to set
     */
    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    /**
     * @return the jdbcUsername
     */
    public String getJdbcUsername() {
        return jdbcUsername;
    }

    /**
     * @param jdbcUsername the jdbcUsername to set
     */
    public void setJdbcUsername(String jdbcUsername) {
        this.jdbcUsername = jdbcUsername;
    }

    /**
     * @return the jdbcPassword
     */
    public String getJdbcPassword() {
        return jdbcPassword;
    }

    /**
     * @param jdbcPassword the jdbcPassword to set
     */
    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }

    /**
     * @return the jdbcDialect
     */
    public String getJdbcDialect() {
        return jdbcDialect;
    }

    /**
     * @param jdbcDialect the jdbcDialect to set
     */
    public void setJdbcDialect(String jdbcDialect) {
        this.jdbcDialect = jdbcDialect;
    }

    /**
     * @return the memcachedIp
     */
    public String getMemcachedIp() {
        return memcachedIp;
    }

    /**
     * @param memcachedIp the memcachedIp to set
     */
    public void setMemcachedIp(String memcachedIp) {
        this.memcachedIp = memcachedIp;
    }

    /**
     * @return the memcachedPort
     */
    public String getMemcachedPort() {
        return memcachedPort;
    }

    /**
     * @param memcachedPort the memcachedPort to set
     */
    public void setMemcachedPort(String memcachedPort) {
        this.memcachedPort = memcachedPort;
    }

    /**
     * @return the memcachedTableName
     */
    public String getMemcachedTableName() {
        return memcachedTableName;
    }

    /**
     * @param memcachedTableName the memcachedTableName to set
     */
    public void setMemcachedTableName(String memcachedTableName) {
        this.memcachedTableName = memcachedTableName;
    }

    /**
     * @return the memcachedTableNameKeyfield
     */
    public String getMemcachedTableNameKeyfield() {
        return memcachedTableNameKeyfield;
    }

    /**
     * @param memcachedTableNameKeyfield the memcachedTableNameKeyfield to set
     */
    public void setMemcachedTableNameKeyfield(String memcachedTableNameKeyfield) {
        this.memcachedTableNameKeyfield = memcachedTableNameKeyfield;
    }

    /**
     * @return the memcachedTableNameValuefield
     */
    public String getMemcachedTableNameValuefield() {
        return memcachedTableNameValuefield;
    }

    /**
     * @param memcachedTableNameValuefield the memcachedTableNameValuefield to set
     */
    public void setMemcachedTableNameValuefield(String memcachedTableNameValuefield) {
        this.memcachedTableNameValuefield = memcachedTableNameValuefield;
    }

    /**
     * @return the updateFile
     */
    public File getUpdateFile() {
        return updateFile;
    }

    /**
     * @param updateFile the updateFile to set
     */
    public void setUpdateFile(File updateFile) {
        this.updateFile = updateFile;
    }

    /**
     * @return the clientFile
     */
    public File getClientFile() {
        return clientFile;
    }

    /**
     * @param clientFile the clientFile to set
     */
    public void setClientFile(File clientFile) {
        this.clientFile = clientFile;
    }

    /**
     * @return the jdbcName
     */
    public String getJdbcName() {
        return jdbcName;
    }

    /**
     * @param jdbcName the jdbcName to set
     */
    public void setJdbcName(String jdbcName) {
        this.jdbcName = jdbcName;
    }

}
