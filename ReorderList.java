// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Using a stack to put all elements abd then iterate over the half of the list
// and put the node and next the element of the task until the mid
// At the end set curr.next to null
class Solution {
    public void reorderList(ListNode head) {
        if(head == null)
            return;
        
        ListNode curr = head;
        int length = 0;
        Stack<ListNode> stack = new Stack<>();
        while(curr!= null){
            stack.add(curr);
            curr = curr.next;
            length++; 
        }
        curr = head;
        for(int i=0; i<length/2; i++){
            if(curr!= null){
                ListNode temp = curr.next;
                curr.next = stack.pop();
                curr.next.next = temp;
            }
            curr = curr.next.next;
        }
        curr.next = null;
    }
}