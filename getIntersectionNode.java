//O(m+n)
//O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        
        //calculate lengths
        ListNode curr = headA;
        
        while(curr!= null){
            lenA++;
            curr = curr.next;
        }
        
        curr = headB;
        
        while(curr!= null){
            lenB++;
            curr = curr.next;
        }
        
          //logic
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
}
