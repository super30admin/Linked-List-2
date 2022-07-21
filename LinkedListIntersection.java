import java.util.HashSet;

public class LinkedListIntersection {
    /**
     * Time Complexity: O(M + N)
     * Space Complexity: O(N)
     * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode dummy = headA;
        ListNode counter = headB;
        HashSet<ListNode> hashSet = new HashSet<>();
        while (dummy != null) {
            hashSet.add(dummy);
            dummy = dummy.next;
        }

        while (counter != null) {
            if (hashSet.contains(counter)) {
                return counter;
            }
            counter = counter.next;
        }
        return null;
    }
    /**
     * Time Complexity: O(M + N)
     * Space Complexity: O(1)
     * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode aCounter = headA;
        ListNode bCounter = headB;
        int aLength = 0;
        int bLength = 0;
        // Calculating the length
        while(aCounter != null){
            aLength++;
            aCounter = aCounter.next;
        }

        while(bCounter != null){
            bLength++;
            bCounter = bCounter.next;
        }

        aCounter = headA;
        bCounter = headB;

        while(aLength > bLength){
            aCounter = aCounter.next;
            aLength--;
        }

        while(bLength > aLength){
            bCounter = bCounter.next;
            bLength--;
        }

        while(aCounter != bCounter){
            aCounter = aCounter.next;
            bCounter = bCounter.next;
        }

        return aCounter;
    }
}

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}