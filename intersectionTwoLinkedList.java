//TC will be O(n+m)
//SC will be O(1)

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class intersectionTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode curr = headA;
        int lenA = 0;

        //find length of first linked list
        while (curr != null) {
            lenA++;
            curr = curr.next;
        }

        //find length of second linked list
        curr = headB;
        int lenB = 0;
        while (curr != null) {
            lenB++;
            curr = curr.next;
        }

        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    public static void main(String[] args) {
        // Create nodes for linked list A
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        // Create nodes for linked list B
        ListNode node4 = new ListNode(4);

        // Make the linked lists intersect at node2
        node4.next = node2;
        node3.next = node4;
        node1.next = node2;

        // Create instances of the intersectionTwoLinkedList class
        intersectionTwoLinkedList intersectionFinder = new intersectionTwoLinkedList();

        // Find the intersection node
        ListNode intersectionNode = intersectionFinder.getIntersectionNode(node1, node3);

        if (intersectionNode != null) {
            System.out.println("Intersection found at node with value: " + intersectionNode.val);
        } else {
            System.out.println("No intersection found.");
        }
    }
}