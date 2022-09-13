// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
/**
 * For this reordering problem, we are first using two pointers to find the mid, slow and fast pointers would get
 * us the mid. then we will break the refernce from the mid , to get two linked lists. We will reverse the second list and
 * then perform merging on both the lists as per the required reordering. Also, while reversing the sceond list ,
 * we would take care of the situation if we have even nodes
 *
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
class Problem2 {
    public void reorderList(ListNode head) {

        //first we will calculate the mid by using slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){

            slow = slow.next;
            fast = fast.next.next;

        }
        //slow will be at mid


        //reverse the list from slow.next (second half the list)
        //as fast can move in case of even nodes
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;

        //merging the two lists
        while(fast!=null ){

            ListNode temp;
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;


        }



    }

    private ListNode reverse(ListNode head){

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //returning the new head
        return prev;
    }
}