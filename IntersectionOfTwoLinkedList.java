// Time Complexity : O(m+n) where m and n are length of the two linked lists
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: We traverse the lists by moving the pointers one node at a time until we either find the intersection point or reach the end of both lists.

// To handle the case where the lists have different lengths,we move the pointer of the shorter list to the head of the longer list when it reaches the end.This allows both pointers to travel an equal distance before reaching the intersection,if one exists.

// If there is an intersection,the two pointers will eventually meet at the intersection node.If there is no intersection,both pointers will reach the end of their respective lists,and we return null.

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class IntersectionOfTwoLinkedList {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        // Pointers for traversing the lists
        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // Traverse the lists to find the intersection node
        while (pointerA != pointerB) {
            // If we reach the end of a list, move to the other list
            if (pointerA == null) {
                pointerA = headB;
            } else {
                pointerA = pointerA.next;
            }

            if (pointerB == null) {
                pointerB = headA;
            } else {
                pointerB = pointerB.next;
            }
        }

        // Return the intersection node (or null if no intersection)
        return pointerA;
    }

    public static void main(String[] args) {
        // Create the first linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode headA = new ListNode(1);
        ListNode nodeA2 = new ListNode(2);
        ListNode nodeA3 = new ListNode(3);
        ListNode nodeA4 = new ListNode(4);
        ListNode nodeA5 = new ListNode(5);

        headA.next = nodeA2;
        nodeA2.next = nodeA3;
        nodeA3.next = nodeA4;
        nodeA4.next = nodeA5;

        // Create the second linked list: 6 -> 7 -> 4 -> 5 -> null
        ListNode headB = new ListNode(6);
        ListNode nodeB2 = new ListNode(7);

        headB.next = nodeB2;
        nodeB2.next = nodeA4; // Intersect at nodeA4

        ListNode intersectionNode = getIntersectionNode(headA, headB);

        // Print the result
        if (intersectionNode != null) {
            System.out.println("Intersected at node with value: " + intersectionNode.val);
        } else {
            System.out.println("No intersection in the lists");
        }
    }

}
