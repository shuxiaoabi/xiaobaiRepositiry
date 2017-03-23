/*
 * Copyright (C), 2013-2014, 江苏飞搏软件技术有限公司
 * FileName: GenerateEasyuiTreeTest.java
 * Author:   jxue
 * Date:     2014年10月29日 下午1:48:58
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.fable.common.easyui.tree;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.alibaba.fastjson.JSON;

/**
 * junit测试生成easyui tree<br>
 * 
 * @author jxue
 */
public class GenerateEasyuiTreeTest extends TestCase {

    private List<Tree> tree1 = new ArrayList<Tree>();
    private List<Tree> tree2 = new ArrayList<Tree>();

    public void testGenerateTree() {
        initTree1();
        initTree2();

        Iterable<Tree> tree = GenerateEasyuiTree.parseToEasyuiTree(false, tree1, tree2);

        System.out.println(JSON.toJSONString(tree, true));
    }

    private void initTree1() {
        {
            Tree tree = new Tree();
            tree.setId("1");
            tree.setText("根节点1");
            tree.setParentId("-1");
            tree.setLeaf(false);

            tree1.add(tree);
        }
        {
            Tree tree = new Tree();
            tree.setId("2");
            tree.setText("根节点2");
            tree.setParentId("-1");
            tree.setLeaf(false);

            tree1.add(tree);
        }
        {
            Tree tree = new Tree();
            tree.setId("3");
            tree.setText("根节点3");
            tree.setParentId("-1");
            tree.setLeaf(false);

            tree1.add(tree);
        }

        // 第二层数据
        {
            Tree tree = new Tree();
            tree.setId("11");
            tree.setText("节点11");
            tree.setParentId("1");
            tree.setLeaf(false);

            tree1.add(tree);
        }
        {
            Tree tree = new Tree();
            tree.setId("21");
            tree.setText("节点21");
            tree.setParentId("2");
            tree.setLeaf(false);

            tree1.add(tree);
        }
    }

    private void initTree2() {
        {
            Tree tree = new Tree();
            tree.setId("111");
            tree.setText("叶子节点111");
            tree.setParentId("11");
            tree.setLeaf(true);
            tree.setAttributes("自定义属性");

            tree2.add(tree);
        }
    }

}
