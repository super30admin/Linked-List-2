// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        
        int countA = 1;
        int countB = 1;
            
        while(l1.next != null) {
            countA = countA + 1;
            l1 = l1.next;
        }
        while(l2.next != null) {
            countB = countB + 1;
            l2 = l2.next;
        }
        
        
        
        l1 = headA;
        l2 = headB;
        
        if(countA<countB) {
          while(countA < countB) {
                l2 = l2.next;
                countB--;
          }
        } else if(countA>countB) {
            while(countA > countB) {
               l1 = l1.next;
               countA--;
          }
        } else {
            l1 = headA;
            l2 = headB;
        }
        
     
        ListNode output = null;
        
        while(l1 !=null && l2 !=null) {
            if(l1 == l2) {
               return l1;
            } else {
                l1 = l1.next;
                l2 = l2.next;
            }
              
        }
        return null;
        
    }
}
