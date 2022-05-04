// Time Complexity : O(N) 3 pass
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class Intersectionof2lists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null){
            return null;
        }

        //Finding the lengths of lists

        ListNode l1 = headA;
        ListNode l2 = headB;

        int length1 = 0;
        int length2 = 0;

        while(l1 != null){
            length1++;
            l1 = l1.next;
        }

        while(l2 != null){
            length2++;
            l2 = l2.next;
        }

        //bringing larger list same distance from intersection as the smaller list
        l1 = headA;
        l2 = headB;
        if(length1 > length2){
            while(length1 > length2){
                length1--;
                l1 = l1.next;
            }
        }else{
            while(length2 > length1){
                length2--;
                l2 = l2.next;
            }
        }

        // Now both list equidistant from intersection

        while(l1 != l2){
            l1 = l1.next;
            l2 = l2.next;
        }

        return l1;
    }
}
