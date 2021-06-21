// Time Complexity : O(n)
// Space Complexity : O(1)

class IntersectionOfTwoLinkedList{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB= 0;
        ListNode itr = headA;
        while(itr!= null){
            lenA++;
            itr = itr.next;
        }

        itr = headB;
        while(itr!= null){
            lenB++;
            itr = itr.next;
        }

        itr = headA;
        ListNode itr2 = headB;

        if(lenA > lenB){
            while(lenA != lenB){
                lenA--;
                itr = itr.next;
            }
        } else {
            while(lenA != lenB){
                lenB--;
                itr2 = itr2.next;
            }
        }

        while(itr != null && itr2 != null) {
            if(itr == itr2) return itr;
            itr = itr.next;
            itr2 = itr2.next;
        }
        return null;

    }
}