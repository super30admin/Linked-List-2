// https://leetcode.com/problems/intersection-of-two-linked-lists/
import java.util.HashSet;

public class intersectionLinkedLists {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    // Time Complexity :O(m+n)
    // Space Complexity :O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    //
    // Your code here along with comments explaining your approach
    // 1. Calculate length of both lists.
    // 2. Start smallest list at first position and largest list at the position where the two list's lengths would be equal.
    // 3 . Traverse equally and check if both are equal and return that node.
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        if(headA == null || headB == null) return null;
        ListNode temp = headA;
        while(temp!=null){
            temp = temp.next;
            lenA++;
        }
        temp = headB;
        while(temp!=null){
            temp = temp.next;
            lenB++;
        }
        while(lenA>lenB){
            headA = headA.next;
            lenA--;
        }
        while(lenB>lenA){
            headB = headB.next;
            lenB--;
        }
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    // Time Complexity :O(m+n)
    // Space Complexity :O(m+n)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    //
    // Your code here along with comments explaining your approach
    // 1. Create a hash set and in each iteration add nodes of both headA and headB to set if they are not present.
    // 2. Do this till a match is found in hash set indicating a intersection and return that node.
    // 3. If both nodes are reached till end and no match is found in hash set , the two lists do not intersect.
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
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
