public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        int lenA = 0;
        int lenB = 0;
        ListNode curr = headA;
        
        //Traverse headA till null
        while(curr != null){
            curr = curr.next;
            lenA++;
        }
        
        //Travel headB till null
        curr = headB;
        while(curr != null){
            curr = curr.next;
            lenB++;
        }
        
        //Make length of headA equal to headB
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        
        //Make length of headB equal to headA
        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }
        
        //Finding the intersection point
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        
        return headB;
    }
}