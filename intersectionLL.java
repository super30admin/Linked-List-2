public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptr1=headA, ptr2=headB;
        int count1=0,count2=0;
        
        while(ptr1!=null){
            count1++;
            ptr1=ptr1.next;
        }
        while(ptr2!=null){
            count2++;
            ptr2=ptr2.next;
        }
        ptr1=headA;
        ptr2=headB;
        
        while(count1>count2){
            ptr1=ptr1.next;
            count1--;
        }
        while(count2>count1){
            ptr2=ptr2.next;
            count2--;
        }
        
        while(ptr1 != ptr2){
            ptr1= ptr1.next;
            ptr2= ptr2.next;
        }
        
        return ptr2;
    }
}
