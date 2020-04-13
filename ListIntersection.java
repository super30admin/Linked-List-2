// 160.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//approach - find lengths of both the lists and move forward by difference in lengths in the longer list. 
//then move forward by one step in both lists till next same and retun next as intersection

//time - O(m + n), m and n are length of lists
//space - constant
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthOfA = 0;
        int lengthOfB = 0;
        
        ListNode tempA = headA;
        ListNode tempB = headB;
        
        while(tempA != null)
        {
            lengthOfA++;
            tempA = tempA.next;
        }
        
        while(tempB != null)
        {
            lengthOfB++;
            tempB = tempB.next;
        }
        
        int lengthDifference = Math.abs(lengthOfA - lengthOfB);
        tempA = headA;
        tempB = headB;
        
        if(lengthOfA > lengthOfB)
        {
            while(lengthDifference != 0)
            {
                lengthDifference--;
                tempA = tempA.next;
            }
        }
        else
        {
            while(lengthDifference != 0)
            {
                lengthDifference--;
                tempB = tempB.next;
            }
        }
        
        while(tempA != tempB)
        {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        
        return tempA;
    }
}
