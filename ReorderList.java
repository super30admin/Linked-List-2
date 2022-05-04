// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class ReorderList {
    public void reorderList(ListNode head) {

        //3Steps
        //1)Find mid
        //2)Reverse the 2nd part
        //3)Merge the 2 lists

        ListNode slow = head;
        ListNode fast = head;


        //1) Find Mid
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //2)Reversing the 2nd Part and separating the list
        fast = reverse(slow.next);
        slow.next = null; // separating the list

        //3)Now merging the list

        slow = head;

        ListNode temp = slow;

        while(fast != null){

            temp = slow.next;
            slow.next = fast;
            slow = temp;
            temp = fast.next;
            fast.next = slow;
            fast = temp;
        }

    }

    private ListNode reverse(ListNode head){

        if(head == null){
            return null;
        }

        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;

        while(curr != null){

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        return prev;

    }
}
