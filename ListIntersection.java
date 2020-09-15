/* https://leetcode.com/problems/intersection-of-two-linked-lists/
160. Intersection of Two Linked Lists - EASY
*/

public class ListIntersection {

    /*
    TC: 
    - length - O(m) + O(n)
    - get intersection - O(max(m,n))
    SC: O(1)
    Approach: Calculate the length of both lists, advance in the longer list by difference in lengths. 
    By this, as we advance both pointers one by one, at one point, they'll both point to the same node,
    if there's an intersection.
    */
    static ListNode getIntersectionDiff(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        int len1 = getLength(l1);
        int len2 = getLength(l2);

        if (len1 > len2) {
            while (len1 != len2) {
                l1 = l1.next;
                len1--;
            }
        } else {
            while (len1 != len2) {
                l2 = l2.next;
                len2--;
            }
        }

        while (l1 != null && l2 != null) { 
            if (l1 == l2) {
                return l1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return null;
    }

    /*
    TC: O(m+n)
    SC: O(1)
    The idea here is - to traverse 2 pointers thru list 1 and 2, until one of them reaches null.
    Once the shorter list pointer reaches null, the longer list pointer is yet to treaverse the difference in length
    between the 2 lists.
    Reassign the shorter-list pointer to point to the longer list, and continue advancing until the longer-list poiner reaches the end.
    At this point, the shorter-list pointer would have traversed the diff in the longer list.
    Reassign the longer-list pointer to the shorter list.
    Now both pointers are at the same starting point, advance by one, until they meet, or both meet null (no intersection).
    */
    static ListNode getIntersection(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode l1 = head1, l2 = head2;

        while (l1 != l2) {
            if (l1 != null) {
                l1 = l1.next;
            } else {
                l1 = head2;
            }

            if (l2 != null) {
                l2 = l2.next;
            } else {
                l2 = head1;
            }
        }

        return l1;
    }

    static int getLength(ListNode head) {
        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static void main(String args[]) {
        ListNode head1 = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        ListNode head2 = new ListNode(2);
        ListNode three2 = new ListNode(3);

        head1.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        head2.next = three2;
        three2.next = four;

        ListNode insersectionNode = getIntersectionDiff(head1, head2);
        if (insersectionNode == null) {
            System.out.println("No intersection");
        } else {
            System.out.println("Intersection at node with value - " + insersectionNode.val);
        }

        insersectionNode = getIntersection(head1, head2);
        if (insersectionNode == null) {
            System.out.println("No intersection");
        } else {
            System.out.println("Intersection at node with value - " + insersectionNode.val);
        }
    }
}
