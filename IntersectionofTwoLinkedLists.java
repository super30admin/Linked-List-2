public class IntersectionofTwoLinkedLists {

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            //find length of Linkedlist 1
            ListNode currA = headA;
            int l1 = 0;

            while(currA != null) {

                l1++;
                currA = currA.next;
            }

            //find length of linkedlist2
            ListNode currB = headB;

            int l2 = 0;

            while(currB != null) {

                l2++;
                currB = currB.next;
            }

            // cover gap, if Linkedlist 1 is longer
            while(l1 > l2) {

                headA = headA.next; // O(m)
                l1--;
            }

            // cover gap, if Linkedlist 2 is longer
            while(l2 > l1) {

                headB = headB.next; // O(n)
                l2--;
            }

            // move both head pointers by 1x, until they are same
            //when no intersection, both will be null
            while(headA != headB) {

                headA = headA.next; // O(m)
                headB = headB.next; // O(n)
            }

            // output headA or headB
            return headA;

        }

}
/* Time Complexity = O(m+n) - worst case 2(m+n). First iteration for length, Second iteration for intersection.
Space Complexity = O(1) - no auxiliary data structure occupying space */