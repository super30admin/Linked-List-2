package LinkedList2;

import LinkedList1.ListNode;

public class DeleteWithoutHeadPointer {
    void deleteNode(ListNode del)
    {
        // Your code here
        int val = del.next.val;
        del.val = val;
        del.next = del.next.next;
    }
}
