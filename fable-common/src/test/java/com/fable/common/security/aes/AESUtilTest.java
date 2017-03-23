/*
 * Copyright (C), 2013-2014, 江苏飞搏软件技术有限公司
 * FileName: AESUtilTest.java
 * Author:   jxue
 * Date:     2014年10月29日 下午1:48:58
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.fable.common.security.aes;

import org.junit.Assert;

import junit.framework.TestCase;

/**
 * junit测试AES对称加密
 * 
 * @author jxue
 * @Date 2014-9-18
 */
public class AESUtilTest extends TestCase {

    /**
     * 测试加密解密
     * 
     * @throws Exception
     */
    public void testAES() throws Exception {
        String content = "content";
        Assert.assertEquals(content, AESUtil.aesDecrypt(AESUtil.aesEncrypt(content, "123456"), "123456"));
    }

}
