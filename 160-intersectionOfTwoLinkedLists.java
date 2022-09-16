//Approach-1: Using the two pointer approach
//Overall Time Complexity: O(N) or O(M + N) M->listA, N->listB
//Overall Space Complexity: O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n1 = 0;
        int n2 = 0;
        
        ListNode tempA = headA;
        ListNode tempB = headB;
        
        while(tempA != null){
            tempA = tempA.next;
            n1++;
        }
        
        while(tempB != null){
            tempB = tempB.next;
            n2++;
        }
        
        tempA = headA;
        tempB = headB;
        
        if(n1 > n2){
            while(n1 > n2){
                tempA = tempA.next;
                n1--;
            }
        }else{
            while(n1 < n2){
                tempB = tempB.next;
                n2--;
            }           
        }
        
        while(tempA != tempB){
            tempA = tempA.next;
            tempB = tempB.next;
        }
        
        return tempA;
    }
}