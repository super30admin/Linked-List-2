//Time complexity : O(n) (split + reverse + merge)
//Space Complexity : O(1)
//Runs successfully on leetcode
//No problem

//Here we will be splitting the linkedlist in halfs
//The second half will be reversed
//The original first half and reversed second half will be merged and we will achieve the required pattern


public class Linked_List_2_Problem_2_reOrderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        slow = head;

        fast = reverse(mid);

        ListNode temp;

        while(fast!=null)
        {
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    public ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!= null)
        {
            slow.next = prev;
            prev = slow;
            slow = fast;
            fast = fast.next;
        }
        slow.next = prev;

        return slow;


    }
}
