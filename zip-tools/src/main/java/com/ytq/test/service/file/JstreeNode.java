package com.ytq.test.service.file;

/**
 * @author yuantongqin
 * 2019/4/12
 */
public class JstreeNode {
    /** id并没有实际的意义，仅仅用于唯一标识节点，为了掌握节点之间的上下级关系，我们将id设为节点对file-path的相对路径 */
    private String id;

    /** 节点的显示名字，我们设为文件名 */
    private String text;

    /** 节点是否有孩子节点 */
    private boolean hasChildren;

    /** 节点类型，即文件还是文件夹，设置文件夹为0，文件为1 */
    private int type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
