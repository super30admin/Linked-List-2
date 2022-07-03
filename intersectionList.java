// Time Complexity : O(m+ n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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

class Main {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;

        // first calculate size of the both list
        int countA = 0;
        int countB = 0;
        while (tempA != null) {
            tempA = tempA.next;
            countA++;
        }
        while (tempB != null) {
            tempB = tempB.next;
            countB++;
        }
        tempA = headA;
        tempB = headB;
        // whichever size is biggest move head pointer till diffrence of both size
        while (countA > countB) {
            countA--;
            tempA = tempA.next;
        }
        while (countB > countA) {
            countB--;
            tempB = tempB.next;
        }
        // move both pointer till we find intersection if we haven't found intersection
        // return null

        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(9);
        headA.next.next = new ListNode(1);
        headA.next.next.next = new ListNode(2);
        headA.next.next.next.next = new ListNode(4);
        ListNode headB = new ListNode(3);
        headB.next = headA.next.next.next;
        System.out.println(getIntersectionNode(headA, headB).val);

    }
}