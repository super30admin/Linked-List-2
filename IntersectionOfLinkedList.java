package week4;

public class IntersectionOfLinkedList {

    class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public ListNode findIntersection(ListNode headA, ListNode headB) {

        ListNode currA = headA;
        ListNode currB = headB;

        int lengthA = findLength(currA);
        int lengthB = findLength(currB);

        currA = headA;
        currB = headB;
        while(lengthA > lengthB) {
            currA = currA.next;
            lengthA--;
        }
        while(lengthB > lengthA) {
            currB = currB.next;
            lengthB--;
        }

        while(currA !=null && currB!= null) {
            currB = currB.next;
            currA = currA.next;

            if(currA == currB) {
                return currA;
            }
        }
        return null;
    }

    private int findLength(ListNode head) {
        int length = 0;
        while(head!= null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
