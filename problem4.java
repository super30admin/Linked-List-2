class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

class intersectionOfTwoLinkedList{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        int lenA = 0;
        int lenB = 0;
        ListNode curr = headA;

        while(curr != null){
            curr = curr.next;
            lenA++;
        }
        curr = headB;
        while(curr != null){
            curr = curr.next;
            lenB++;
        }

        while(lenA > lenB){
            lenA--;
            headA = headA.next;
        }

        while(lenA < lenB){
            lenB--;
            headB = headB.next;
        }

        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public static void main(String[] args) {
        intersectionOfTwoLinkedList il = new intersectionOfTwoLinkedList();
        ListNode nodeA = new ListNode(4);
        nodeA.next = new ListNode(1);
        nodeA.next.next = new ListNode(8);
        nodeA.next.next.next = new ListNode(4);
        nodeA.next.next.next.next = new ListNode(5);

        ListNode nodeB = new ListNode(5);
        nodeB.next = new ListNode(6);
        nodeB.next.next = new ListNode(1);
        nodeB.next.next.next = new ListNode(8);
        nodeB.next.next.next.next = new ListNode(4);
        nodeB.next.next.next.next.next = new ListNode(5);

        System.out.println(il.getIntersectionNode(nodeA, nodeB).val);
    }
}