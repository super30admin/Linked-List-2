public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        
        int length1 = 0, length2 = 0;
        while(temp1 != null){
            temp1 = temp1.next;
            length1++;
        }
        
        while(temp2 != null){
            temp2 = temp2.next;
            length2++;
        }
        
        int result = 0;
        if(length1 >= length2){
            result = length1 - length2;
            while(result > 0){
                headA = headA.next;
                result--;
            }
        }else{
            result = length2 - length1;
            while(result > 0){
                headB = headB.next;
                result--;
            }
        }
        
        while(headA != null){
            if(headA == headB)
                break;
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
}

Time Complexity: O(n)
Space Complexity: O(1)