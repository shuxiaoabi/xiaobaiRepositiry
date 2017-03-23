/*
 * Copyright (C), 2013-2014, 江苏飞搏软件技术有限公司
 * FileName: Tree.java
 * Author:   jxue
 * Date:     2014年10月29日 下午1:48:58
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.fable.common.easyui.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONType;

/**
 * easyui 树控件 <br>
 * 用于绑定数据，转成json，供页面适用
 * 
 * @author jxue
 */
@JSONType(ignores = { "level", "parentId", "parent" })
public class Tree implements Serializable {

    private static final long serialVersionUID = -6839667086063014781L;

    /** 编号 */
    private String id;

    /** 编号(treegrid使用) */
    private String hiddenId;

    /** 显示文本 */
    private String text;

    /** 图标css */
    private String iconCls;

    /** 是否叶子节点 */
    private boolean leaf;

    /** 是否含有叶子节点 */
    private boolean hasLeaf;

    /** 节点状态 */
    private String state;

    /** 是否选中 */
    private boolean checked;

    /** 自定义属性 */
    private Object attributes;

    /** 层级 */
    private int level;

    /** 父节点编号 */
    private String parentId;

    /** 父节点 */
    private Tree parent;

    /** 子节点 */
    private List<Tree> children = new ArrayList<Tree>();

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the hiddenId
     */
    public String getHiddenId() {
        return hiddenId;
    }

    /**
     * @param hiddenId the hiddenId to set
     */
    public void setHiddenId(String hiddenId) {
        this.hiddenId = hiddenId;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the iconCls
     */
    public String getIconCls() {
        return iconCls;
    }

    /**
     * @param iconCls the iconCls to set
     */
    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    /**
     * @return the leaf
     */
    public boolean isLeaf() {
        return leaf;
    }

    /**
     * @param leaf the leaf to set
     */
    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    /**
     * @return the hasLeaf
     */
    public boolean isHasLeaf() {
        return hasLeaf;
    }

    /**
     * @param hasLeaf the hasLeaf to set
     */
    public void setHasLeaf(boolean hasLeaf) {
        this.hasLeaf = hasLeaf;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the checked
     */
    public boolean isChecked() {
        return checked;
    }

    /**
     * @param checked the checked to set
     */
    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    /**
     * @return the attributes
     */
    public Object getAttributes() {
        return attributes;
    }

    /**
     * @param attributes the attributes to set
     */
    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return the parentId
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * @param parentId the parentId to set
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * @return the parent
     */
    public Tree getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Tree parent) {
        this.parent = parent;
    }

    /**
     * @return the children
     */
    public List<Tree> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(List<Tree> children) {
        this.children = children;
    }

    /**
     * @param children the children to add
     */
    public void addChildren(Tree children) {
        this.children.add(children);
    }

}
