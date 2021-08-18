/* Time Complexity :  O(n)
   Space Complexity : O(1)  
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow=head,fast=head;
        //Finding mid
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        fast = reverseList(slow.next);//reverse the second half
        slow.next=null;
        slow=head;
        ListNode temp=null;
        while(fast!=null){
            temp=slow.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=temp;
            slow=temp;
        }
    }
    private ListNode reverseList(ListNode cur){
        if(cur==null) return null;
        ListNode pre=null,fast=cur.next;
        while(fast!=null){
            cur.next=pre;
            pre=cur;
            cur=fast;
            fast=fast.next;
        }
        cur.next=pre;
        return cur;
    }
}