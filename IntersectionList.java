/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Idea:
 * 1. Calculate lengths of both lists. 
 * 2. Move the  longest list to diff of lengths positions. Now, both lists are equal in lengths
 * 3. Check if nodes are equal to find the intersection
 * 
 * LeetCode : Yes
 */


class IntersectionList {
    public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) {
                 val = x;
                 next = null;
             }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null){
            return null;
        }

        int lengthA = 0;        
        ListNode currA = headA;
        while(currA != null){
            lengthA++;
            currA = currA.next;
        }

        int lengthB = 0;
        ListNode currB = headB;
        while(currB != null){
            lengthB++;
            currB = currB.next;
        }
        //reset heads
        currA = headA;
        currB = headB;

        if(lengthA > lengthB){
            // move headA lengthA-lengthB places
            int diffLength = lengthA-lengthB;
            
            int counter=0;
            while(counter < diffLength){
                currA = currA.next;
            }
        }
        else{
            // move headA lengthB-lengthA places
            int diffLength = lengthB-lengthA;
            int counter = 0;
            while(counter < diffLength){
                currB = currB.next;
            }
        }

        // chrck if they are equal;

        while(currA != null && currB != null){
            if(currA == currB)
            {
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }



        return null;
    }

    public static void main(String[] args){
        System.out.println("IntersectionList");    
    }
}