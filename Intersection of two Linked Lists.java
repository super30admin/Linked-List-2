// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
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

    private int getLength(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        int l1 = getLength(headA);
        int l2 = getLength(headB);

        System.out.println(l1 + ", " + l2);

        if (l1 > l2){
            while (l1 > l2){
                //System.out.println("headA: " + headA.val);
                headA = headA.next;
                l1--;
            }
        } else while(l2 > l1){
            //System.out.println("headB: " + headB.val);
            headB = headB.next;
            l2--;
        }

        while(headA != null && headB != null && headA != headB){
            //System.out.println("-------");
            //System.out.println("headA: " + headA.val);
            //System.out.println("headB: " + headB.val);
            headA = headA.next;
            headB = headB.next;
        }

        return headA == headB ? headA : null;
    }
}
