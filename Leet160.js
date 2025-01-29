// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode}
 */
var getIntersectionNode = function(head1, head2) {
        let c1= head1;
        let c2= head2;
      while(c1!==c2)
      {
          c1=  !c1? head2 : c1.next;
          c2 = !c2? head1:c2.next;
      }
        
      return c1;
          
};