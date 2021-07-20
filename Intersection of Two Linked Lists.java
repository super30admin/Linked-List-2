//time n
//space constant

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode temp1 = headA;
        ListNode temp2 = headB;
        boolean temp1shorter = false;


        while(temp1!=null && temp2!=null)
        {
            temp1=temp1.next;
            temp2=temp2.next;
        }

        int counter = 0;

        while(temp1!=null)
        {
            temp1=temp1.next;
            ++counter;
        }

        while(temp2!=null)
        {
            temp1shorter = true;
            temp2=temp2.next;
            ++counter;
        }

        ListNode tem1 = headA;
        ListNode tem2 = headB;

        if(temp1shorter)
        {
            while(counter-->0) tem2 = tem2.next;
        }
        else
        {
            while(counter-->0) tem1 = tem1.next;
        }

        while(tem1!=null && tem2!=null)
        {
            if(tem1 == tem2) return tem1;
            tem1 = tem1.next;
            tem2 = tem2.next;
        }

        return null;

    }
}
