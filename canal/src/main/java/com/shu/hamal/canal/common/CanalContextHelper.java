package com.shu.hamal.canal.common;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CanalContextHelper {

    private static ClassPathXmlApplicationContext context = null;
    private static RuntimeException initException = null;

    static {
        try {
            context = new ClassPathXmlApplicationContext("applicationContext.xml") {

                @Override
                protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
                    super.customizeBeanFactory(beanFactory);
                    beanFactory.setAllowBeanDefinitionOverriding(false);
                }
            };
        }
        catch (RuntimeException e) {
            throw e;
        }
    }

    private static ApplicationContext getApplicationContext() {
        if (context == null) {
            throw initException;
        } 

        return context;
    }

    public static void close() {
        ((ClassPathXmlApplicationContext)context).close();
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        return (T)getApplicationContext().getBean(name);
    }

    /**
     * 根据当前spring容器的bean定义，解析对应的object并完成注入
     */
    public static void autowire(Object obj) {
        // 重新注入一下对象
        context.getAutowireCapableBeanFactory().autowireBeanProperties(obj,
            AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, false);
    }
}
