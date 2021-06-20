public class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    /*-------------------Method One---------------------*/
    /*This solution applies the two requiredments of same ListNode: 1. value 
                                                                    2. address*/
    public ListNode getIntersectionNode_Method_One(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while(headA != null){
            set.add(headA);
            headA = headA.next;
        }
        while(!set.contains(headB) && headB != null){
            headB = headB.next;
        }
        return headB;
    }
    
    // Time complexity: O(n * m)
    // Space complexity: O(1)
    /*-------------------Method Two---------------------*/
    /*----------------------Brute Force-----------------*/
    public ListNode getIntersectionNode_Method_Two(ListNode headA, ListNode headB){
        while(headA != null){
            ListNode temp = headB;
            while(temp != null){
                if(headA == temp)
                    return temp;
                temp = temp.next;
            }
            headA = headA.next;
        }
        return null;
    }
    
    // Time complexity: O(n)
    // Space complexity: O(1)
    // Same as the question named finding cycle in linked list
    /*-------------------Method Three---------------------*/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA != pB){
            pA = pA == null? headB : pA.next;
            pB = pB == null? headA : pB.next;
        }
        return pA;
    }
    
}

