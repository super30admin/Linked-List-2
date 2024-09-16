// Time Complexity : O(N+M), N and M are length of two linked lists respectively.
// Space Complexity : O(1), no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : After class solution


// Your code here along with comments explaining your approach
//The idea is to use two pointers to calculate the length of two linked lists. Once, we get the difference between the lengths of both the lists, we move the cursor of the greater linked list to the starting point of the smaller linked list.
//Then we iterate over both the linked list to find the intersection.
//If intersection not found then we return null.

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null) return null;
        
        int lengthA = 0, lengthB = 0;
        
        ListNode cursorA = headA;
        ListNode cursorB = headB;
        
        while(cursorA != null){
            lengthA++;
            cursorA = cursorA.next;
        }
        
        while(cursorB != null){
            lengthB++;
            cursorB = cursorB.next;
        }
        
        int diffLen = lengthA - lengthB;
        
        cursorA = headA;
        cursorB = headB;
        
        if(diffLen > 0){//A is greater in length
           while(diffLen > 0){
               cursorA = cursorA.next;
               diffLen--;
           } 
        }else{//B is greater in length
            while(diffLen < 0){
                cursorB = cursorB.next;
                diffLen++;
            }
        }
        
        while(cursorA != null && cursorB != null){
            if(cursorA == cursorB){
                return cursorA;
            }
            cursorA = cursorA.next;
            cursorB = cursorB.next;
        }
       return null; 
    }
}