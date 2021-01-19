public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode l1 = headA;
        ListNode l2 = headB;
        int length1 = 0;
        int length2 = 0;

        while (l1 != null) {
        l1 = l1.next;
        length1++;
        }

        while (l2 != null){
        l2 = l2.next;
        length2++;
        }

        int diff = Math.abs(length1 - length2);
        l1 = headA;
        l2 = headB;

        if(length1 > length2) {
        for(int i = 0; i < diff; i++) {
        l1 = l1.next;
        }
        } else {
        for(int i = 0; i < diff; i++) {
        l2 = l2.next;
        }
        }

        while(l1 != null) {
        if(l1 == l2) {
        return l1;
        }
        l1 = l1.next;
        l2 = l2.next;
        }
        return null;

        }

        }