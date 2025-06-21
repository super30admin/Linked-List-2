// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class  IntersectionOfTwoLinkedList {
    class ListNode {
        int data;
        ListNode next;

        ListNode(int val) {
            this.data = val;
            this.next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        int lenA = 0, lenB = 0;

        while(p1 != null || p2 != null) {
            if(p1 != null) {
                p1 = p1.next;
                lenA++;
            }
            if(p2 != null) {
                p2 = p2.next;
                lenB++;
            }
        }

        while(lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while(lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headB;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedList obj = new IntersectionOfTwoLinkedList();

        ListNode common = obj.new ListNode(8);
        common.next = obj.new ListNode(10);

        ListNode headA = obj.new ListNode(3);
        headA.next = obj.new ListNode(7);
        headA.next.next = common;


        ListNode headB = obj.new ListNode(99);
        headB.next = obj.new ListNode(1);
        headB.next.next = common;


        System.out.println("List A:");
        obj.printList(headA);
        System.out.println("List B:");
        obj.printList(headB);

        ListNode intersection = obj.getIntersectionNode(headA, headB);
        if (intersection != null) {
            System.out.println("Intersection at node with value: " + intersection.data);
        } else {
            System.out.println("No intersection.");
        }
    }
}
