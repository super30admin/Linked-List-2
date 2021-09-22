
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class ListNode {
    int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
public class delete {
    void deleteNode(ListNode del)
    {
         
         del.val = del.next.val;
         del.next = del.next.next;
    }
}
