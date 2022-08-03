//Time Complexity :O(m+n)
//Space Complexity:O(1)
//Microsoft Interview
//Brute Force:Imagine I decide to use the hashset using the reference node.value
//Optimal Approch:Using the list the first case both list lengths should be equal i.e length a =length b.2.length a =5=[4,1,8,4,5] length b = 6 =[5,6,1,8,4,5] then length a >length b them move the head B pointer forward initial point.lenght a =length b then move both the ponters parallely A and B 3.length b>length A move the b pointer until it equal to  A=B
//If no intersect happen it should be return null.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      if(headA == null || headB==null) return null;
        int lenA = 0,lenB=0;
        ListNode curr = headA;
        while(curr!=null){
            curr = curr.next;
            lenA++;
        }
        curr = headB;
        while(curr!=null){
            curr = curr.next;
            lenB++;
        }
        while(lenA>lenB){
            headA=headA.next;
            lenA--;
        }
        while(lenB>lenA){
            headB= headB.next;
            lenB--;
        }
        //No intersection happens then both the pointers reach to null
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}