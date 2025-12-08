// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//   Definition for singly-linked list.
  public class ReorderList {
      int val;
      ReorderList next;
      ReorderList() {}
      ReorderList(int val) { this.val = val; }
      ReorderList(int val, ReorderList next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public void reorderList(ReorderList head) {
        // a. find mid
        ReorderList slow = head, fast = head;
        while(null != fast && null != fast.next)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow is at mid
        // b. reverse linked list from the mid+1 node, as it will be second half of the linked list
        // and delink the reversed seconf half to form a seperate linked list
        ReorderList reversed = reverse(slow.next);
        slow.next = null;
        // c. link one node at a time from each linked list
        ReorderList curr = head;
        while(null != reversed)
        {
            ReorderList temp = curr.next;
            curr.next = reversed;
            reversed = reversed.next;
            curr.next.next = temp;
            curr = temp;
        }
    }

    private ReorderList reverse(ReorderList head)
    {
        ReorderList curr = head, prev = null;
        while(null != curr)
        {
            ReorderList temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}