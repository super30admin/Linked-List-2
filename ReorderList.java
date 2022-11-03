package s30.linkedList.linkedList2;


import s30.linkedList.ListNode;

import java.util.Stack;


// Time Complexity O(n)
// Space complexity O(1)
public class ReorderList {
    public static void reorderList(ListNode head) {
      ListNode dummy = new ListNode(-1);
      dummy.next = head;
        ListNode fast = head;
        ListNode slow = dummy;

        Stack<ListNode> reverseStack = new Stack();

        int count =0;

        while(fast.next!=null){
            count++;

            if( (count & 1) !=0){
                slow = slow.next;
            }

            fast = fast.next;
        }


        while(slow.next != null){
            slow = slow.next;
            reverseStack.push(slow);
        }

        slow = head;

        while(!reverseStack.isEmpty()){
            ListNode temp = reverseStack.pop();
            temp.next = slow.next;
            slow.next = temp;
            slow = slow.next.next;
        }
        slow.next = null;

    }
    public static void main(String[] args) {

        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        reorderList(root);
    }
}
