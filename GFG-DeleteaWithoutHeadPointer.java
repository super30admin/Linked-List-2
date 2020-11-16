package LinkedList.DeleteWithoutHeadPointer;

class ListNode{

    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){ this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution1 {


    static void deleteNode(ListNode node)
    {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String args[]){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Input list: ");
        ListNode curr = head;
        while(curr != null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
        deleteNode(head.next);
        curr = head;
        System.out.println("\nOutput List:");
        while(curr != null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
