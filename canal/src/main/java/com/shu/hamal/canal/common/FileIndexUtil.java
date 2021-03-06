package com.shu.hamal.canal.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件序列号管理<br>
 * 
 * @author shuxiaobai
 */
public class FileIndexUtil {

    private static Logger logger = LoggerFactory.getLogger(FileIndexUtil.class);

    /** 文件名--保存需要同步的SQL文件序列号 */
    public static final String update_index = "update_index.properties";

    /** 文件名--保存生成的SQL文件序列号 */
    public static final String client_index = "client_index.properties";

    public static final String UPDATE_KEY = "update_index";

    public static final String CLIENT_KEY = "client_index";

    public static final String INIT_INDEX = "1";

    public static final String MAX_INDEX = "9999999";

    private static Properties properties = new Properties();

    private static InputStream inputStream = null;

    private static OutputStream outputStream = null;

    /**
     * 
     * 功能描述: 在in文件夹下初始化索引文件<br>
     * 
     * @param updateFile
     * @param clientFile
     */
    public static void initFile(File updateFile, File clientFile) {
        try {
            if (!updateFile.getParentFile().isDirectory()) {
                updateFile.getParentFile().mkdirs();
            }
            if (!updateFile.exists()) {
                updateFile.createNewFile();
                // 初始化update_index=1
                writeFile(updateFile, UPDATE_KEY, INIT_INDEX);
            }
            if (!clientFile.getParentFile().isDirectory()) {
                clientFile.getParentFile().mkdirs();
            }
            if (!clientFile.exists()) {
                clientFile.createNewFile();
                // 初始化client_index=1
                writeFile(clientFile, CLIENT_KEY, INIT_INDEX);
            }
        } catch (IOException e) {
            logger.error("创建文件异常：" + e);
        }
    }

    /**
     * 
     * 功能描述: 读取updateFile索引文件序列号<br>
     *
     * @param updateFile
     * @return
     */
    public static synchronized String readUpdateIndex(File updateFile) {
        // 读取index
        String index = readFile(updateFile, UPDATE_KEY);
        return formatString(index);
    }

    /**
     * 
     * 功能描述: 更新updateFile索引文件序列号<br>
     * 
     * @param index
     * @param updateFile
     */
    public static synchronized void updateIndex(String index, File updateFile) {
        // index加1
        long update_index = Long.valueOf(index) + 1L;
        if (update_index > Long.valueOf(MAX_INDEX)) {
            update_index = Long.valueOf(INIT_INDEX);
        }
        // 保存index
        writeFile(updateFile, UPDATE_KEY, String.valueOf(update_index));
    }

    /**
     * 
     * 功能描述: 读取clientFile索引文件序列号<br>
     * 
     * @param clientFile
     * @return
     */
    public static synchronized String readClientIndex(File clientFile) {
        // 读取index
        String index = readFile(clientFile, CLIENT_KEY);
        if (index == null || "".endsWith(index)) {
            index = "0";
        }
        // index加1
        long client_index = Long.valueOf(index) + 1L;
        if (client_index > Long.valueOf(MAX_INDEX)) {
            client_index = Long.valueOf(INIT_INDEX);
        }
        // 保存index
        writeFile(clientFile, CLIENT_KEY, String.valueOf(client_index));
        return formatString(index);
    }

    /**
     * 
     * 功能描述: 读取file文件中的key值<br>
     * 
     * @param file
     * @param key
     * @return
     */
    private static String readFile(File file, String key) {
        String index = null;
        try {
            inputStream = new FileInputStream(file);
            properties.load(inputStream);
            index = properties.getProperty(key);
            properties.clear();
        } catch (FileNotFoundException e) {
            logger.error("要读取的文件不存在：" + e);
        } catch (IOException e) {
            logger.error("properties文件加载失败：" + e);
        } finally {
            closeStream();
        }
        return index;
    }

    /**
     * 
     * 功能描述: 修改file文件中key的值为value<br>
     * 
     * @param file
     * @param key
     * @param value
     */
    private static void writeFile(File file, String key, String value) {
        try {
            outputStream = new FileOutputStream(file);
            properties.setProperty(key, value);
            properties.store(outputStream, "UPDATE-" + key + "=" + value);
            properties.clear();
        } catch (FileNotFoundException e) {
            logger.error("要读取的文件不存在：" + e);
        } catch (IOException e) {
            logger.error("properties文件加载失败：" + e);
        } finally {
            closeStream();
        }
    }

    /**
     * 
     * 功能描述: 关闭流<br>
     * 
     */
    private static void closeStream() {
        try {
            if (inputStream != null)
                inputStream.close();
            if (outputStream != null)
                outputStream.close();
        } catch (IOException e) {
            logger.error("流关闭异常：" + e);
        }
    }

    /**
     * 生成string
     * 
     * @param index
     */
    private static String formatString(String index) {
        StringBuffer sb = new StringBuffer();
        for (int j = 0; index.length() <= 6 - j; j++) {
            sb.append("0");
        }
        sb.append(index);
        return sb.toString();
    }

}
