/*
-The brute force approach is we can save all the nodes of list A into hashset and then traverse over list b and check if any node we can find in list b from list a.
-If we find then this is the intersection
-Time Complexity-O(n)
-Space Complexity-O(1)
*/

/*
Optimized Solution:
-Time Complexity-O(n)
-Space Complexity-O(1)
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //edge case
        if(headA == null || headB ==null)
            return null;
        
        int aCount = countNodes(headA);
        int bCount = countNodes(headB);
        // move the bigger list by the difference of node count of 2 lists
        if(aCount > bCount)
           headA = moveList(headA,  aCount - bCount);
        else
           headB = moveList(headB,  bCount - aCount);
        //get intersection of 2 lists
        return getIntersection(headA, headB);
    }

    private ListNode moveList(ListNode node , int count){
       int temp =0;
       while(node!= null && temp < count){
           temp++;
           node = node.next;
       }
        return node;
    }
    //count number of nodes of lists
    private int countNodes(ListNode node){
        int count=0;
        while(node != null){
            count++;
            node = node.next;
        }
        return count;
    }
    
    private ListNode getIntersection(ListNode headA, ListNode headB){
        while(headA != null && headB != null){
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
