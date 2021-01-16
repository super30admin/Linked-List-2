// Time Complexity : O(m+n), m = length of list A, n = length of list B
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Before the node where the two lists intersect, calculate the length of the two lists( eg: 3 and 5). Reset the head of the longer list( eg: to the 2nd node ) and the parse till both the nodes are equal. 

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lenA = 0;
        int lenB = 0;
        
        ListNode temp;
        
        temp = headA;
        while(temp != null){
            lenA = lenA + 1;
            temp = temp.next;
        }
        
        temp = headB;
        while(temp != null){
            lenB = lenB + 1;
            temp = temp.next;
        }
        
        int diff = Math.abs(lenA - lenB);
        int count = 0;
        if(lenA < lenB){
            while(count < diff){
                headB = headB.next;
                count = count + 1;
            }
        } else {
            while(count < diff){
                headA = headA.next;
                count = count + 1;
            }
        }
        
        while(headA != null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
}
