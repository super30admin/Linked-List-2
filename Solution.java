// Time Complexity : O(m+n)
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: i implemented this by suing set to put one linkedlist nodes in second i check whether the second linked list node is matching with the node which is in set if it is then return true;

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
    HashSet<ListNode> set=new HashSet<>();
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while(headA != null ){
             set.add(headA);
             headA= headA.next;
        }
         while(headB != null ){
            if(set.contains(headB)){
                return headB;
             }
               headB= headB.next;
        }
       return null;
        
    }
}



// Time Complexity : O((2(m+n))->O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: this is two pointer approach where i count two linked list count first then if any one of the count is greater than others then i redcuce the count of one which is greater then other ,then i started comparing two heads then there going to be intersect at same point where is has intersected.

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
    int p1;
     int p2;
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       ListNode tempA=headA;
       ListNode tempB=headB;
        while(headA != null ){
              p1++;
              headA= headA.next;
        }
         while(headB != null ){
              p2++;
               headB= headB.next;
        }
        headA=tempA;
        headB=tempB;


        while( p1 > p2){
            headA =headA.next;
            p1--;
        }
         while( p2 > p1){
           headB= headB.next;
            p2--;
        }
        while(headA != headB){
            headA= headA.next;
            headB=  headB.next;
           
        }
       return headA;
        
    }
}