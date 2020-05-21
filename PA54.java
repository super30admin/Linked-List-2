//Leetcode 160. Intersection of Two Linked Lists
//Time Complexity: O(n) // it is actually O(5n) where n is the no of nodes in the largest linked list
//Space Complexity: O(1) // No any extra space allocated
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        int lenA= 0;
        int lenB=0;
        ListNode ha= headA;
         ListNode hb= headB;
        while(ha!=null){
            lenA++;
            ha=ha.next;
        }
        while(hb!=null){
            lenB++;
            hb=hb.next;
        }
        
        while(lenA>lenB){
            headA=headA.next;
            lenA--;
        }
        while(lenB>lenA){
            headB=headB.next;
            lenB--;
        }
        
        while(headA!=headB){
            headB=headB.next;
            headA=headA.next;
        }
        return headA;
    }
}