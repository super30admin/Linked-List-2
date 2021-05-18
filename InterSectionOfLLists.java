/*
Desc : After ierating through both list the greater list's elements are skipped to achieve equal lengths
that way iterating through the lists simultaneously we check if we encounter the same node.
Time Complexity : O(n)
Space Complexity : O(1)
*/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //get length of the two lists first, skip the number of nodes as of the value of difference in length
        
        ListNode h1 = headA;
        ListNode h2 = headB;
        int l1=0; int l2=0;
        while(h1.next!=null){
            l1++;
            h1 = h1.next;
        }
        while(h2.next!=null){
            l2++;
            h2 = h2.next;
        }
        h1 = headA;
        h2 = headB;
        if(l1>=l2){
            int i=0;
            while(i<l1-l2){
                h1=h1.next;
                i++;
            }
        }else{
            int i=0;
            while(i<l2-l1){
                h2=h2.next;
                i++;
            }
        }
        while(h1!=null){
            if(h1 == h2) return h1;
            h1 = h1.next;
            h2 = h2.next;
        }
        return null;
    }
}
