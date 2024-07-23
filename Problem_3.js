// https://www.geeksforgeeks.org/problems/delete-without-head-pointer/1
// Time Complexity : O(1)
// Space Complexity : O(1)

/**
 * @param {ListNode} node
 */
function deleteNodeWithoutHead(node){
    //Given a node to be deleted, we can replace the value and next in curr node to next node's val and next reference, 
    // thereby deleting the node in essence.
    let tmp = node.next;
    node.val = node.next.val;
    node.next = node.next.next;
    tmp = null;
}