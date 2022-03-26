// Time Complexity : O(M+N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         ListNode l1 = headA;
        
        int lenA = 0;
        while(l1 != null){
            l1 = l1.next;
            lenA++;
        }
        //Length of List-A
        l1 = headB;
        int lenB = 0;
        while(l1 != null){
            l1 = l1.next;
            lenB++;
        }
        //Length of List-B


        //Now making both the lists of same length whichever list having greater length,
        //we will traverse to the node such that from that node both lists having same length

        
        l1 = headA;
        while(lenA > lenB){ // If ListA's length is greater
            l1 = l1.next;
            lenA--;
        }
        
        
        ListNode l2 = headB;
        while(lenB > lenA){ // If ListB's length is greater
            l2 = l2.next;
            lenB--;
        }
        
        while(l1 != l2){ // Traverse the nodes one by one and when they intersect, both pointers will point to same node
            l1 = l1.next;
            l2 = l2.next;
        }
        
        return l1; //Can return node l1 or l2 - as both are same
        
    }
}

