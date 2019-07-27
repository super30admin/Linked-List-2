/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Idea
 * 1. Copy data of next to current node
 * 2. Make the current node's next point to next.next
 * Leetcode: Yes
 * 
 */


class DeleteWithoutHead {
    public static class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
    }

    void deleteNode(ListNode node)
    {
         // Your code here
         node.val = node.next.val;
         node.next = node.next.next;
         

    }

    public void printList(ListNode head){
        ListNode curr = head;
        while(curr != null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
    public static void main(String[] args){
        System.out.println("DeleteWithoutHead");
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        DeleteWithoutHead obj = new DeleteWithoutHead();
        obj.deleteNode(head.next.next.next.next);
        obj.printList(head);
    }
}