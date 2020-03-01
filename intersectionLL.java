# Time complexity:O(n)
# Space complexity: 0(1)
# Did code run successfully on leetcode: yes
# Any problem you faced: No

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
        int lengthA = getLength(headA), lengthB = getLength(headB);
        ListNode cursorA = headA, cursorB = headB;
        if(lengthA > lengthB){
            cursorA = move(headA, lengthA - lengthB);

        }
        else{
            cursorB = move(headB, lengthB - lengthA);
        }

        while(cursorA != null && cursorB != null){
            if(cursorA == cursorB)
                return cursorA;
            cursorA = cursorA.next;
            cursorB = cursorB.next;

        }
        return null;
    }

    private int getLength(ListNode head){
        ListNode cursor = head;
        int length = 0;
        while(cursor != null){
            length++;
            cursor = cursor.next;
        }

        return length;
    }

    private  ListNode move(ListNode cursor, int steps){
        while(steps > 0){
            cursor = cursor.next;
            steps--;
        }

        return cursor;
    }
}