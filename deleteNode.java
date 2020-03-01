
/*
-I will copy the value of next node into the current node which i need to delete
- and point next of current node to cur.next.next
- and I would delete the next node
*/
class Solution {
    public void deleteNode(ListNode node) {
        if(node ==null)
            return;
        node.val= node.next.val;
        node.next = node.next.next;
        return;
    }
}
