public class ReorderList {

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        //1. Find out the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //2. Reverse the list after the middle node
        fast = reverseList(slow.next);
        // Cutting the first list at the middle element
        slow.next = null;


        //3. Now rearrange the elements
       slow = head;
       ListNode temp = slow.next;

       while(fast != null) {
           temp = slow.next;
           slow.next = fast;
           fast = fast.next;
           slow.next.next = temp;
           slow = temp;
       }


        //printList(head);

    }

    private ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode prev = null;
        ListNode current = head;
        ListNode fast = head.next;

        while(fast !=null) {
            current.next = prev;
            prev = current;
            current = fast;
            fast = fast.next;
        }

        current.next = prev;

        return current;
    }

    private ListNode insert(ListNode head, int data){
        ListNode tempNode = new ListNode(data);

        if(head == null) {
            head = tempNode;
        }else{
            ListNode currentNode = head;
            while(currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = tempNode;
        }
        return head;
    }

    // Method to print the LinkedList.
    private void printList(ListNode head)
    {
        ListNode currentNode = head;
        System.out.print("head -> ");
        while(currentNode != null){
            System.out.print(currentNode.val + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println(" end");
    }

    private boolean isListNull(ListNode list) {
        return null == list;
    }

    public static void main(String[] args) {
        ReorderList re = new ReorderList();
        ListNode head = null;
        head = re.insert(null, 1);
        head = re.insert(head, 2);
        head = re.insert(head, 3);
        head = re.insert(head, 4);
        //head = re.insert(head, 5);

        re.printList(head);
        System.out.println("Reordering the list now" );
        re.reorderList(head);
    }
}
