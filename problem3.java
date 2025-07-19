// Time Complexity: O(n)
// Space Complexity: O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode listA = headA, listB = headB;
        int lenA = 0, lenB = 0;
        while (listA != null) {
            listA = listA.next;
            lenA++;
        } 

        while (listB != null) {
            listB = listB.next;
            lenB++;
        }
        listA = headA;
        listB = headB;
        while (lenA > lenB) {
            listA = listA.next;
            lenA--;
        }

        while (lenB > lenA) {
            listB = listB.next;
            lenB--;
        }

        while (listA != null) {
            if (listA == listB) return listA;
            listA = listA.next;
            listB = listB.next;
        }

        return null;
    }
}

// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         Set<ListNode> visitedNodes = new HashSet<>();
//         ListNode listA = headA, listB = headB;
//         while (listA != null) {
//             visitedNodes.add(listA);
//             listA = listA.next;
//         } 

//         while (listB != null) {
//             if (visitedNodes.contains(listB)) break;
//             listB = listB.next;
//         }

//         return listB;
//     }
// }
