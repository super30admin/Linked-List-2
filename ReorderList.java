// TC : O(n)
// SC : O(1)

package S30_Codes.Linked_List_2;

public class ReorderList {
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public void reorderList(ListNode head) {
        ListNode mid = findMid(head);
        ListNode rHead = reverseList(mid.next);
        mid.next = null;
        mergeList(head, rHead);
    }

    private void mergeList(ListNode l1, ListNode l2){
        while(l2 != null){
            ListNode l2Next = l2.next;
            l2.next = l1.next;
            l1.next = l2;
            l1 = l1.next.next;
            l2 = l2Next;
        }
    }

    private ListNode reverseList(ListNode cur){
        ListNode prev = null;
        while(cur != null){
            ListNode next = cur.next;

            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private ListNode findMid(ListNode head){
        ListNode s = head;
        ListNode f = head;

        while(f.next != null && f.next.next != null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
}