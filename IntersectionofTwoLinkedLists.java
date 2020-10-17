
public class IntersectionofTwoLinkedLists {
    //Time complexity O(m+n)
    //Space complexity O(1)
    //Tested in leetcode
    // # of attempt = 4 , attemp 1,2,3 had failing case for list which are not intersecting
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            
        ListNode first = headA;
        ListNode second = headB;
        
        //iterate till both pointer point to null
        while(first != null || second != null){
            if(first == null)
                headB = headB.next;
            else
                first = first.next;
            
            if(second == null)
                headA= headA.next;
            else
                second = second.next;
        }    
        while(headA != headB){
            headB = headB.next;
            headA= headA.next;
        }
            
        return headA;
    }
}