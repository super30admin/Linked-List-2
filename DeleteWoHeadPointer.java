// TC - O(1)
// SC - O(1)
// URL - https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1

public class DeleteWoHeadPointer {
    public static class ListNode {
        int val;
        ReorderList.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ReorderList.ListNode next) { this.val = val; this.next = next; }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}