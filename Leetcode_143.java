//way1
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

 //Identify mid point
 //Reverse second half
 //Use two pointerss and rearrange it
 //TC: O(n/2)+O(n/2)+O(n/2); SC:O(1)
class Solution {
    public void reorderList(ListNode head) {
        //identify mid
        ListNode slow=head;
        ListNode fast=head;


        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        //reverse second half
        fast=slow.next;
        slow.next=null;

        slow = reverse(fast);

        //Rearrange using 2 pointers
        fast=head;

        while(slow!=null){
            ListNode temp1=fast.next;
            fast.next=slow;
            slow=slow.next;
            fast.next.next=temp1;
            fast=fast.next.next;
        }
        
    }

    private ListNode reverse(ListNode curr){

        ListNode prev=null;

        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }

        return prev;
    }
}


//way2
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

 //Identify mid point
 //Store secind half in stack
 //Use two pointerss and rearrange it
 //TC: O(n); SC:O(n)
class Solution {
    public void reorderList(ListNode head) {
        //identify mid
        ListNode slow=head;
        ListNode fast=head;


        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        //reverse second half
        fast=slow.next;
        slow.next=null;

        Stack<ListNode> stack=new Stack();
        while(fast!=null){
            stack.add(fast);
            fast=fast.next;
        }

        fast=head;
        while(!(stack.isEmpty())){
            ListNode temp1=fast.next;
            fast.next=stack.pop();
            fast.next.next=temp1;
             fast=fast.next.next;
        }
        
    }
}
