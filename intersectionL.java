class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class intersectionL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode currA = headA;
        ListNode currB = headB;

        int lenA = 0;
        int lenB = 0;

        // Calculate the length of list A
        while (currA != null) {
            lenA++;
            currA = currA.next;

        }

        // Calculate the length of list B
        while (currB != null) {
            lenB++;
            currB = currB.next;
        }

        // Reset the pointers to the head of each list
        currA = headA;
        currB = headB;

        // Adjust the starting point for the longer list
        while (lenA > lenB) {
            currA = currA.next;
            lenA--;
        }
        while (lenB > lenA) {
            currB = currB.next;
            lenB--;
        }

        // Move both pointers until they meet at the intersection point
        while (currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }

        return currA;
    }

    public static void main(String[] args) {
        intersectionL list = new intersectionL();

        // Create two linked lists
        // List A: 1 -> 9 -> 1 -> 2 -> 4
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(9);
        headA.next.next = new ListNode(1);
        ListNode intersection = new ListNode(2);
        headA.next.next.next = intersection;
        intersection.next = new ListNode(4);

        // List B: 3 -> 2 -> 4
        ListNode headB = new ListNode(3);
        headB.next = intersection; // Intersection point at node with value 2

        // Find intersection
        ListNode result = list.getIntersectionNode(headA, headB);

        // Print the intersection node value
        if (result != null) {
            System.out.println("Intersection node value: " + result.val);
        } else {
            System.out.println("No intersection");
        }
    }
}
