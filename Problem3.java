
//T.C  : O(1)
//S.C : O(1)
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No
public class Problem3 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public void deleteNode(ListNode node) {
        int val = node.next.val;
        ListNode temp = node.next.next;
        node.val = val;
        node.next = temp;


    }
}
