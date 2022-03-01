/*
Time Complexity: O(1)
Space Complexity: O(1)

run on the geeks for geeks: yes
any difficulties: no

Approach:
1. Changing next pointer and values
 */
public class DeleteWithoutHeadPointer {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val =val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static void deleteListNode(ListNode node){
        if(node == null){
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(4);
        ListNode first = new ListNode(5);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(9);
        ListNode fourth = new ListNode(3);

        head.next = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = null;

        deleteListNode(first);

        while(head!= null){
            System.out.print(head.val);
            head = head.next;
            System.out.print("->");
        }
    }
}
