//Time - O(n)
//Space - O(1)
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
        ListNode curr = headA;
        ListNode curr1 = headB;
        int length=0;
        int length1=0;
        while(curr!=null){
            length++;
            curr=curr.next;
        }
        while(curr1!=null){
            length1++;
            curr1=curr1.next;
        }
        curr = headA;
        curr1 = headB;
        if(length>length1){
            int count = length-length1;
            while(count>0){
                curr=curr.next;
                count--;
            }
        }
        if(length1>length){
            int count = length1-length;
            while(count>0){
                curr1=curr1.next;
                count--;
            }
        }
        while(curr!=null && curr1!=null){
            if(curr==curr1){
                return curr;
            }
            curr=curr.next;
            curr1 = curr1.next;
        }
        return null;
    }
}


