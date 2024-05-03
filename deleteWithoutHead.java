// Time Complexity : O(1)
// Space Complexity : O(1)

//delete when head is not given
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class deleteWithoutHead {
    public void deleteNode (ListNode node){
        ListNode temp = node.next;
        node.val = temp.val;
        node.next = temp.next;
        temp = null;
    } 
}