/*
Time Complexity: O(N)~ amortized, as finding middle would take N/2 (where N is the length of the ListNode)
Space Complexity: O(N)

Approach:
1. First find out middle using slow and fast pointer
2. reverse the second half using prev pointer
3. Merge the second half and head

 */
public class ReorderList {
    public static class ListNode{
        int val;
        ListNode next;

        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.next = next;
        }
    }

    public static void reorderList(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!= null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversedList = reverseLinkedList(slow.next);
        slow.next = null;

        mergeLists(head, reversedList);
    }

    public static ListNode reverseLinkedList(ListNode node){
        ListNode prev = null;

        while(node!= null){
            ListNode curr = node.next;
            node.next = prev;
            prev = node;
            node= curr;
        }
        return prev;
    }

    public static ListNode mergeLists(ListNode a, ListNode b){
        ListNode temp = a;

        while(a!= null && b!= null){
            ListNode a1 = a.next;
            ListNode b1 = b.next;

            a.next = b;
            b.next = a1;

            a = a1;
            b = b1;
        }
        return temp;
    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(4);

        head.next = first ;
        first.next = second;
        second.next = third;
        third.next = null;

        reorderList(head);

        while(head!= null){
            System.out.print(head.val);
            head = head.next;
            System.out.print("->");
        }
    }
}
