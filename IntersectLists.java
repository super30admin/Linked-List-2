/**
Time:O(N) where N is number of nodes
Space:O(1) 
Algorithm:
=========
1. Determine length of both linkedlists 
2. Iterate longer linkedlist till its pointer is at diff distance from its head
3. Now, both lists can be iterated one by one till intersection is found, else return null
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA, tempB = headB;
        int aCtr = 0, bCtr = 0;
        while(tempA != null) {
            // count length of linkedlist A
            aCtr++;
            tempA = tempA.next;
        }
        while(tempB != null) {
             // count length of linkedlist B
            bCtr++;
            tempB = tempB.next;
        }
        
        // find difference between lengths of LLs
        int diff = aCtr - bCtr;
        tempB = headB;
        tempA = headA;

        // iterate nodes of longer linked list by distance difference between both
        if(diff > 0) {
            while(diff != 0) {
                tempA = tempA.next;
                diff--;
            }
        }
        else if(diff < 0){
            while(diff != 0) {
                tempB = tempB.next;
                diff++;
            }
        }
        //iterate at a time now and check if they intersect
        while(tempA != null && tempB != null) {
            if(tempA == tempB)
                return tempA;
            tempA = tempA.next;
            tempB = tempB.next;
        }
        //no intersection
        return null;
    }
}