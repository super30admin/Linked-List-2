//Time Complexity: O(1)
//Space Complexity: O(1)
//Did it run on leetcode: yes
//Problems faced any: No

public class Problem53 {
    void deleteNode(ListNode node)
    {
        // Your code here
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
