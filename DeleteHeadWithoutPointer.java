//Time Complexity: O(1)
//Space Complexity: O(1)
public class DeleteHeadWithoutPointer {
    void deleteNode(ListNode delNode)
    {
        // Your code here
        delNode.val = delNode.next.val;
        delNode.next = delNode.next.next;
    }
}
