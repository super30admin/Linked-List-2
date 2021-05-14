// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


public class deleteWithouHead {
    public void deleteNode(ListNode node) {
        // System.out.println(" node.next.val :"+node.next.val);
        // System.out.println("  node.val :"+ node.val);
        node.val=node.next.val;        
        node.next=node.next.next;
    }
}
