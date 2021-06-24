// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode node = headA;
        while(node != null){
            lenA++;
            node = node.next;
        }
        node = headB;
        while(node != null){
            lenB++;
            node = node.next;
        }
        if(lenA > lenB){
            return move(lenA-lenB, headA, headB);
        }
        else{
            return move(lenB-lenA, headB, headA);
        }   
    }
    
    private ListNode move(int difference, ListNode one, ListNode two){
        for(int i=0; i<difference; i++)
                one = one.next;
            while(one != two){
                one = one.next;
                two = two.next;
            }
            return one;
    }
}
