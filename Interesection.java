// Time complexity :O(m+n)
// Space Complexity :O(1)
public class Interesection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1=headA;
        while(temp1!=null){
            temp1.val=temp1.val*(-1);
            temp1=temp1.next;
        }
        ListNode temp2= headB;
        while(temp2!=null){
            if(temp2.val<0){
                break;
            }
            temp2=temp2.next;
        }
        temp1=headA;
        while(temp1!=null){
            temp1.val=temp1.val*(-1);
            temp1=temp1.next;
        }
        return temp2;
       
    }
}