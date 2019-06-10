package com.algorithm.list.structure;

/**
 * @author yuantongqin
 * 2019/5/30
 */
public class SingleLinked {

    public boolean is(ListNode head){

        ListNode prev = null;
        ListNode fast = head;
        ListNode current = head;

        /** 当前节点的后继指正指向上一个节点current.next = prev
         * 当前节点往后移动一位置
         * 当前节点就边上了上一个节点
         */
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            current.next = prev;
            prev = current;
            current = current.next;
        }

        if(fast != null){
            current = current.next;
        }

        while (prev != null && current != null){
            if(prev.val != current.val){
                return false;
            }
            prev = prev.next;
            current = current.next;
        }
        return true;
    }

}
