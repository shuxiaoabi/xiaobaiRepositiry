package com.shu.hamal.canal.listener;

import java.util.Map.Entry;
import java.util.Vector;

import com.shu.hamal.canal.common.ConfigEntity;
import com.shu.hamal.canal.common.InitConfig;
import com.shu.hamal.canal.instance.CanalClient;
import com.shu.hamal.canal.instance.CanalUpdate;

public class CanalListener {

    public void start() {
        Vector<String> obj = new Vector<String>();
       
        //生成SQL文件线程<br>
        Thread canalClientThread = new Thread(new CanalClient(obj));
        canalClientThread.start();
        for (Entry<String, ConfigEntity> entry : InitConfig.configMap.entrySet()) {
            /**
             * 更新数据库线程<br>
             */
            Thread canalUpdateThread = new Thread(new CanalUpdate(obj, entry.getValue()));
            canalUpdateThread.start();
        }
    }
}
