//Apprach 1
//Time: O(n)
//Space: O(n)
//https://leetcode.com/submissions/detail/615109463/
package com.company;

import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Main {

    public static void reorderList(ListNode head) {
        ArrayList<ListNode> orignallist;
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        int i = 1, j = list.size() - 1;
        ListNode temp2 = head;
        int count = 1;
        while(i < j) {
            temp2.next = list.get(j);
            temp2 = temp2.next;
            j--;
            temp2.next =  list.get(i);
            temp2 = temp2.next;
            i++;
            count = count + 2;
        }
        if(count < list.size()) {
            temp2.next = list.get(j);
            temp2 = temp2.next;
            temp2.next =null;
        } else
        {
            temp2.next =null;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Main.reorderList(node);
    }
}
