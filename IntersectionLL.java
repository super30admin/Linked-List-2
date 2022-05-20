//Time Complexity: O(N) + O(M) + O(N or M)
//Space Complexity: O(1)
//Leetcode: yes.
public class IntersectionLL {
   /* Solution 1 Get the length and then find intesection*/
    /**
     * Definition for singly-linked list. */
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            if (headA == null || headB == null) {
                return null;
            }
            ListNode temp = headA;
            int lenA = 0;
            int lenB = 0;
            while(temp != null) {
                lenA++;
                temp = temp.next;
            }
            temp = headB;
            while(temp != null) {
                lenB++;
                temp = temp.next;
            }
            int i = 0;
            if (lenA > lenB) {
                temp = headA;
                i = lenA-lenB;
                while(i > 0) {
                    temp = temp.next;
                    i--;
                }

                while (temp != null && headB != null) {
                    if (temp == headB) {
                        return temp;
                    }
                    temp = temp.next;
                    headB = headB.next;
                }
            } else {
                temp = headB;
                i = lenB-lenA;
                while(i > 0) {
                    temp = temp.next;
                    i--;
                }

                while (temp != null && headA != null) {
                    if (temp == headA) {
                        return temp;
                    }
                    temp = temp.next;
                    headA = headA.next;
                }
            }

            return null;
        }
    //Time Complexity: O(N+M)
//Space Complexity: O(1)
//Leetcode: yes.
    /* Solution 2 Two pointer */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
