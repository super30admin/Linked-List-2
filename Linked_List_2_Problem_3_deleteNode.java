//Time complexity: O(1)
//Space complexity: O(1)
//Runs successfully on leetcode ( https://leetcode.com/problems/delete-node-in-a-linked-list/ )
//No problem



public class Linked_List_2_Problem_3_deleteNode {
    public void deleteNode(ListNode node) {
        if(node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
