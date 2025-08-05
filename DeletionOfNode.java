// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// Since we are not given access to the head of the list, we cannot actually "remove" the node from the list
// in the traditional sense. Instead, we copy the value from the next node into the current node,
// and then delete the next node by adjusting the pointer.
//Example:
// Input: 1 -> 2 -> 3 -> 4, node = 2
// Output after deletion: 1 -> 3 -> 4
//
// Steps:
// 1. Copy value of next node into current node.
// 2. Point current node's next to next.next, effectively skipping over the next node.



class ListNode {
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}




public class DeletionOfNode {
    public void solve(ListNode node) {
        if(node == null || node.next==null){
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;

    }

    public static void main(String[]args){

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);

        DeletionOfNode ob = new DeletionOfNode();
        ob.solve(node.next);

        ListNode curr = node;
        while (curr!=null){
            System.out.println(curr.val + " ");
            curr = curr.next;
        } 
            

    }
    
}
