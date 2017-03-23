/*
 * Copyright (C), 2013-2014, 江苏飞搏软件技术有限公司
 * FileName: GenerateEasyuiTree.java
 * Author:   jxue
 * Date:     2014年10月29日 下午1:48:58
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.fable.common.easyui.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 根据提供数据，递归生成easyui tree结构<br>
 * 
 * @author jxue
 */
public class GenerateEasyuiTree {

    private static Long idx = 1L;

    /**
     * 
     * 生成easyui tree结构 <br>
     * 
     * @param del_empty 是否删除空节点(无叶子节点) true-删除
     * @param data 数据结构(按照层级结构顺序传入)
     * @return
     */
    @SafeVarargs
    public static Iterable<Tree> parseToEasyuiTree(boolean del_empty, Iterable<Tree>... data) {
        if (data.length == 0)
            return null;

        return generate(del_empty, data);
    }

    /**
     * 
     * 生成easyui treegrid结构 <br>
     * 将原先id替换成不重复变量，原id保存在hiddenId中
     * 
     * @param del_empty
     * @param data
     * @return
     */
    @SafeVarargs
    public static Iterable<Tree> parseToEasyuiTreeGrid(boolean del_empty, Iterable<Tree>... data) {
        if (data.length == 0)
            return null;

        Iterable<Tree> root = generate(del_empty, data);

        // 将原先id值存入hiddenId中，并改为递增不重复变量
        idx = 1L;
        for (Tree r : root) {
            changeIDToRandom(r);
        }

        return root;
    }

    /**
     * 
     * 解析打包数据<br>
     * 
     * @param del_empty
     * @param data
     * @return
     */
    @SafeVarargs
    private static Iterable<Tree> generate(boolean del_empty, Iterable<Tree>... data) {

        // 设置层级关系
        for (int i = 0; i < data.length; i++) {
            Iterable<Tree> iterable = data[i];
            for (Tree t : iterable) {
                t.setLevel(i + 1);
            }
        }

        Iterable<Tree> root = parseRoot(data[0]);
        for (Iterable<Tree> d : data) {
            for (Tree t : d) {
                for (Tree r : root) {
                    parseChildToParent(t, r);
                }
            }
        }

        if (del_empty) {// 删除空节点
            deleteEmpty((ArrayList<Tree>) root);
        }
        return root;
    }

    /**
     * 
     * 整理出第一级根节点(ParentId.equals("-1")) <br>
     * 
     * @param tree
     * @return
     */
    private static Iterable<Tree> parseRoot(Iterable<Tree> data) {
        List<Tree> root = new ArrayList<Tree>();

        for (Iterator<Tree> iterator = data.iterator(); iterator.hasNext();) {
            Tree t = (Tree) iterator.next();
            if (t.getParentId().equals("-1")) {
                root.add(t);
            }
        }
        return root;
    }

    /**
     * 
     * 将子节点关联至其父节点 <br>
     * 
     * @param chrild
     * @param parent
     */
    private static void parseChildToParent(Tree chrild, Tree parent) {
        if (chrild.getParentId().equals(parent.getId()) && ((parent.getLevel() == 1 && chrild.getLevel()==1) || chrild.getLevel() == parent.getLevel() + 1)) { // 等于上一层父节点
            parent.addChildren(chrild);
            chrild.setParent(parent);// 设置父节点
            if (chrild.isLeaf()) {// 如果是叶子节点，则设置关联父节点hasLeaf=true
                setParentHasLeaf(chrild);
            }
        } else {
            if (parent.getChildren().size() > 0) {
                List<Tree> list = parent.getChildren();
                for (Tree p : list) {
                    parseChildToParent(chrild, p);
                }
            }
        }
    }

    /**
     * 
     * 设置叶子节点关联的父节点hasLeaf=true <br>
     * 
     * @param chrild
     */
    private static void setParentHasLeaf(Tree chrild) {
        Tree parent = chrild.getParent();
        if (parent != null) {
            chrild.getParent().setHasLeaf(true);
            setParentHasLeaf(parent);
        }
    }

    /**
     * 
     * 根据hasLeaf,删除没有叶子节点 <br>
     * 
     * @param tree
     */
    private static void deleteEmpty(ArrayList<Tree> tree) {
        for (int i = tree.size() - 1; i >= 0; i--) {
            Tree t = tree.get(i);
            if (!t.isLeaf() && !t.isHasLeaf())
                tree.remove(t);
            else if (!t.isLeaf() && t.getChildren().size() > 0) {
                deleteEmpty((ArrayList<Tree>) t.getChildren());
            }
        }
    }

    /**
     * 
     * 将原先id值改为不重复字段，原id存入hiddenId中 <br>
     * treegrid中id不可重复，否则出错
     * 
     * @param tree
     */
    private static void changeIDToRandom(Tree tree) {
        tree.setHiddenId(tree.getId());
        tree.setId(String.valueOf(idx++));
        if (tree.getChildren().size() > 0) {
            List<Tree> t = tree.getChildren();
            for (int i = 0; i < t.size(); i++) {
                changeIDToRandom(t.get(i));
            }
        }
    }

}
