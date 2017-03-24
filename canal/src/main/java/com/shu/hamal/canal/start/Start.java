package com.shu.hamal.canal.start;

import com.shu.hamal.canal.common.CanalContextHelper;
import com.shu.hamal.canal.listener.CanalListener;

/**
 * start main daemon<br>
 * 
 * @author admin
 */
public class Start {

    public static void main(String[] args) {
        ((CanalListener) CanalContextHelper.getBean("canalListener")).start();
    }
}
