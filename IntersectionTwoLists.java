// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class IntersectionTwoLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //if(headA == null || headB == null) return null;

        int len1 = 1;
        int len2 = 1;

        ListNode curr1 = headA;
        ListNode curr2 = headB;

        //length of first one
        while(curr1 != null){
            curr1 = curr1.next;
            len1++;
        }

        //length of second one
        while(curr2 != null){
            curr2 = curr2.next;
            len2++;
        }


        ListNode fast;
        ListNode slow;

        if(len1 > len2){
            fast = headA;
            slow = headB;
        }else{
            fast = headB;
            slow = headA;
        }
        //set lag for slow pointer
        int diff = Math.abs(len1 - len2);
        int count = 0;

        //go until same spot
        while(fast != slow){
            if(count < diff){
                fast = fast.next;
                count++;
            }else{
                fast = fast.next;
                slow = slow.next;
            }
        }

        return fast;

    }
}