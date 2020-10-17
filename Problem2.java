// https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
// Time Complexity :O(n) -> number of nodes
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Worked on GEEKSFORGEEKS
// Any problem you faced while coding this : No
//

public class deleteWithoutHead {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    // Your code here along with comments explaining your approach
    // 1. Swap value of current node with next node's value till last node . Use a new ListNode to keep track of previous node.
    // 2. Now when last node's next element is null , it means the node we wished to delete is at the last position .
    // 3. Since we keep track of element previous to the given node , we can set the next node (the node we used to store
    //    previous node of current node ) to null . Now ,the given node will be deleted since it is at the end.
    void deleteNode(ListNode node)
    {
        // Your code here
        //  if(node.next == null){
        //      node = null;
        //      return;
        //  }
        ListNode prev = node;
        while(node.next!=null){
            int temp = node.val;
            node.val = node.next.val;
            node.next.val = temp;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }
    // Time Complexity : O(1)
    //swap given node'' value with next node and change next pointer of current node to next next node.
    void deleteNode2(ListNode head){
        head.val = head.next.val;
        head.next = head.next.next;
    }

}
