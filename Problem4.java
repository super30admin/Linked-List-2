/*
Find intersection of 2 linked lists
approach: find absolute diff of both lists. start both pointers from same distance from intersection.
time: O(m+n)
space: O(1)
 */
public class Problem4 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr = headA;

        int countA = 0;
        while(curr!=null) {
            countA+=1;
            curr = curr.next;
        }

        curr = headB;
        int countB = 0;
        while(curr!=null) {
            countB+=1;
            curr = curr.next;
        }

        int diff = Math.abs(countA-countB);

        if(countA>countB) {
            while(diff>0) {
                headA = headA.next;
                diff--;
            }
        }
        else {
            while(diff>0) {
                headB = headB.next;
                diff--;
            }
        }
        System.out.println("head1 "+headA.val);
        System.out.println("head2 "+headB.val);

        while(headA!=headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
