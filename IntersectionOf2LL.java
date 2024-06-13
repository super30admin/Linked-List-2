/***
 1. Find the length of the tow linked list and then find the difference.
 2. Iterate over the larger list till the difference and then start moving over both the list and comapring the nodes.
 3. If same nodes are found, return the node, else return null
 TC - O(m+n), SC - O(1)
 */
public class IntersectionOf2LL {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null)
            return null;

        //find length of 2 lists
        int lenA =0, lenB =0;

        ListNode curr = headA;

        while(curr != null) {
            curr = curr.next;
            lenA++;
        }

        curr = headB;

        while(curr != null) {
            curr = curr.next;
            lenB++;
        }

        ListNode curr1 = headA;
        ListNode curr2 = headB;

        while(lenA > lenB) {
            curr1 = curr1.next;
            lenA--;
        }

        while(lenB > lenA) {
            curr2 = curr2.next;
            lenB--;
        }

        while(curr1 != null || curr2 != null) {
            if(curr1 == curr2)
                return curr1;

            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return null;

    }
}
