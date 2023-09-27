//TC - O(n)
//SC - O(1);

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 

 //TC O(n+M)
 //SC O(1)
public class IntersectionNodes {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        int countA = 0;

        while (a != null) {
            countA++;
            a = a.next;
        }

        ListNode b = headB;
        int countB = 0;

        while (b != null) {
            countB++;
            b = b.next;
        }

        while (countA > countB) {
            headA = headA.next;
            countA--;
        }

        while (countB > countA) {
            headB = headB.next;
            countB--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    public static void main(String[] args) {
        // Create two linked lists for testing
        ListNode commonNode = new ListNode(8);
        ListNode list1 = new ListNode(4);
        list1.next = new ListNode(1);
        list1.next.next = commonNode;
        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(1);
        list2.next.next.next = commonNode;

        // Create an instance of the IntersectionNodes class
        IntersectionNodes intersectionNodes = new IntersectionNodes();

        // Find the intersection node
        ListNode intersectionNode = intersectionNodes.getIntersectionNode(list1, list2);

        if (intersectionNode != null) {
            System.out.println("Intersection Node Value: " + intersectionNode.val);
        } else {
            System.out.println("No intersection found.");
        }
    }
}
