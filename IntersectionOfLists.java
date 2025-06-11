/*
Time Complexity: O(n + m) where n is the length of list A and m is the length of list B.
Space Complexity: O(n) for storing nodes of list A in a set.
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Intuition: The idea is to traverse both linked lists and store the nodes of the first list in a set. 
Then, we traverse the second list and check if any node exists in the set.

*/
public class IntersectionOfLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet();

        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
