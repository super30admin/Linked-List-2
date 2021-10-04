public class IntersectionOfTwoLinkedLists {
    
    // Time Complexity: O(n + m) (where n -> no. of nodes in ListA and m -> no. of nodes in ListB)
    // Space Complexity: O(1)
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /*
            Two pointer approach:
            
            1. Reach both lists till the end (tails)
                - if they have different tails, that means there's no intersection
                    --> return null
            2. While reaching till the end, count the length of the list. (3 possibilities)
                a. lenA == lenB
                b. lenA > lenB
                c. lenA < lenB
            3. Calculate the skipNodeCount = abs(lenA - lenB)
            4. Skip the longer length list ahead by skipNodeCount.
                - i.e move that many nodes ahead.
                - so now both pointers will be at equal distance from the intersection point.
            5. Now simply move both pointers ahead, until we find the intersection point.
        */
        
        if(headA == null || headB == null)
            return null;
        
        int lenA = 0;
        int lenB = 0;
        
        ListNode tempA, tempB;
        
        for(tempA = headA; tempA != null; tempA = tempA.next)
            lenA++;
        
        for(tempB = headB; tempB != null; tempB = tempB.next)
            lenB++;
        
        if(tempA != tempB)
            return null;
        
        if(lenA > lenB){
            int diff = lenA - lenB;
            while(diff-- > 0){
                headA = headA.next;
            }
        }else{
            int diff = lenB - lenA;
            while(diff-- > 0){
                headB = headB.next;
            }
        }
        
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}