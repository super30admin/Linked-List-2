// Time Complexity : O(n) where n is the length of longer linked list
// Space Complexity : O(1) No extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None



public class IntersectionOfLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while(temp1.next!=null && temp2.next!=null){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        int toskipA = 0, toskipB = 0;

        while(temp2.next!=null){
            temp2 = temp2.next;
            toskipB++;
        }
        while(temp1.next!=null){
            temp1 = temp1.next;
            toskipA++;
        }
        //System.out.println(toskipA+" "+toskipB);
        if(temp1!=temp2) return null;

        ListNode ptr1 = headA;
        ListNode ptr2 = headB;

        while(toskipA!=0){
            ptr1 = ptr1.next;
            toskipA--;
        }
        while(toskipB!=0){
            ptr2 = ptr2.next;
            toskipB--;
        }

        while(ptr1!=ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }
}