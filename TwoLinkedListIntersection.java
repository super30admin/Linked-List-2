// Time Complexity : O(n + m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach - - Use two pointers `pA` and `pB` starting at headA and headB respectively.
//   - Traverse both lists; when a pointer reaches the end of its list, redirect it to the head of the other list.
//   - If there's an intersection, the pointers will eventually meet there.
//   - If no intersection, both will reach null at the same time.

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class TwoLinkedListIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //multiple solutions
        //1. Create a hashset of nodes of list A, traverse B while checking it -> O(N+M), O(N)
        //2. Use 2 pointers, find length of both lists A and B. Iterate bigger one for iterations=diff of length
        //then traverse 2 lists together and check if value of node is same -> 3 * O(N+M), O(N)
        //3. Use 2 pointers, run while not same, if pA is null assign headB to it else iterate pA further,
        //repeat same for pB where if null assign headA to it. return pA at end. if intersection loop will be exited, if no intersection both pA and pB will end up at null.

        ListNode pA = headA;
        ListNode pB = headB;

        while(pA != pB) {
            pA = (pA == null ? headB : pA.next);
            pB = (pB == null ? headA : pB.next);
        }

        return pA;
    }

    public static void main(String[] args) {
        ListNode intersect = new ListNode(8, new ListNode(10));

        // List A: 4 -> 1 -> 8 -> 10
        ListNode headA = new ListNode(4, new ListNode(1, intersect));

        // List B: 5 -> 6 -> 1 -> 8 -> 10
        ListNode headB = new ListNode(5, new ListNode(6, new ListNode(1, intersect)));

        TwoLinkedListIntersection solution = new TwoLinkedListIntersection();
        ListNode result = solution.getIntersectionNode(headA, headB);

        if (result != null) {
            System.out.println("Intersection at node with value: " + result.val);
        } else {
            System.out.println("No intersection found.");
        }
    }
}
