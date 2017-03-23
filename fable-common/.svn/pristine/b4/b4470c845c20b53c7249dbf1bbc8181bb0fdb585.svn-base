/*
 * Copyright (C), 2013-2014, 江苏飞搏软件技术有限公司
 * FileName: RSAUtilTest.java
 * Author:   jxue
 * Date:     2014年10月29日 下午1:48:58
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.fable.common.security.aes;

import java.util.Map;

import org.junit.Assert;

import com.fable.common.security.rsa.RSAUtil;

import junit.framework.TestCase;

/**
 * junit测试RSA非对称密钥
 * 
 * @author jxue
 * @Date 2014-9-18
 */
public class RSAUtilTest extends TestCase {

    /**
     * 测试生成密钥文件
     * 
     * @throws Exception
     */
    public void testCreateFile() throws Exception {
        // RSAUtil.generateKeyFile("d:/"); //生成密钥对文件
    }

    /**
     * 测试加密解密
     * 
     * @throws Exception
     */
    public void testRSA() throws Exception {
        String content = "content";
        Map<String, Object> key_map = RSAUtil.genKeyPair();
        String privateKey = RSAUtil.getPrivateKey(key_map); // 获取私钥信息
        String publicKey = RSAUtil.getPublicKey(key_map);// 获取公钥信息

        Assert.assertEquals(content, RSAUtil.decryptPrivateKey(RSAUtil.encryptPublicKey(content, publicKey), privateKey));// 公钥加密 私钥解密
        Assert.assertEquals(content, RSAUtil.decryptPublicKey(RSAUtil.encryptPrivateKey(content, privateKey), publicKey));// 私钥加密 公钥解密
    }

}
