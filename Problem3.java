// Time Complexity :O(m+n)
// Space Complexity :O(m+n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//
// Your code here along with comments explaining your approach
// 1. Create a hash set and in each iteration add nodes of both headA and headB to set if they are not present.
// 2. Do this till a match is found in hash set indicating a intersection and return that node.
// 3. If both nodes are reached till end and no match is found in hash set , the two lists do not intersect.
import java.util.HashSet;

public class intersectionLinkedLists {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while(headA!=null && headB!=null){
            if(set.contains(headA))
                return headA;
            else if(set.contains(headB))
                return headB;
            else{
                set.add(headA);
                if(!set.add(headB)) return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        while(headA!=null){
            if(set.contains(headA))
                return headA;
            headA = headA.next;
        }
        while(headB!=null){
            if(set.contains(headB))
                return headB;
            headB = headB.next;
        }
        return null;
    }
}
