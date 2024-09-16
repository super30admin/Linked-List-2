/**
 * Time: O(1)
 * Space: O(1)
 */
class Solution{
    public void deleteWithoutHeadPointer(ListNode node){
        if(node.nxt = null){
            node =null;
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}