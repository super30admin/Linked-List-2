// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : rearranging the pointers was challenging


// Your code here along with comments explaining your approach

 /* we will find the mid of the list and then reverse the elements from the mid and make it a seperate list
 we then will move one step in each list to join them criss cross
*/
class Solution {
    public void reorderList(ListNode head) {

        //edge cases

        //stopping at one before the mid
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        // slow pointing to the one node before the mid

        ListNode l2 = reverse(slow.next); // reverse the list from mid and returning the new head
        slow.next = null; // preventing cycle

        ListNode l1 = head;
        ListNode l1Next = null;
        ListNode l2Next = null;

        while(l1!=null){
            // save l1's' next
            l1Next = l1.next;
            //save l2's' next
            l2Next = l2.next;
            // pointing l1's next to l2
            l1.next = l2;
            // moving l1 pointer to next position in l1
            l1 = l1Next;
            // pointing l2'snext ' to l1's' next
            l2.next = l1Next;
            // moving l2 pointer
            if(l1Next!=null) // edge case, when the input is odd length, we want to preserve the l2's' tail, so we can add the next element after this loop
            l2 = l2Next;
        }        

        if(l2Next!=null) // for odd length
        {
            l2.next = l2Next;
            l2Next.next = null;
        }        
    }

    private ListNode reverse(ListNode node){
        if(node==null) return null;
        // using three pointers

        ListNode prev = null;
        ListNode current = node;
        ListNode next = node.next;
        while(next!=null){
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }
        current.next = prev;
        return current;
    }
}