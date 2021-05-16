public class ReorderList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reorderList(ListNode head) {

        ListNode result = head;
        
        if(head == null || head.next == null) return result;
        
        // Find the middle using slow and fast pointer approach
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the second half of the linked list.
        fast = reverse(slow.next);
        
        // Break the connection between the first and second half of the linked list.
        slow.next = null;
        
        // reset the slow pointer to start of the first half of the linked list.
        slow = head;
        
        // Merge the two linked lists.
        ListNode curr = null;
        while(fast != null){
            curr = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = curr;
            slow = curr;
        }

        return result;
    }
    
    private static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        while(fast != null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }

    public static ListNode generateLinkedList(int[] nums){
        ListNode head = null, prev = null;
        for(int i = nums.length-1; i>=0; i--){
            head = new ListNode(nums[i], prev);
            prev = head;
        }
        return head;
    }

    public static void printList(ListNode head){
        if(head == null) return;

        while(head != null){
            System.out.print(head.val+" --> ");
            head = head.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
        printList(reorderList(generateLinkedList(new int[]{1,2,3,4,5})));
        printList(reorderList(generateLinkedList(new int[]{1,2,3,4,5,6,7,8})));
        printList(reorderList(generateLinkedList(new int[]{4})));
        printList(reorderList(generateLinkedList(new int[]{4,5})));
        printList(reorderList(generateLinkedList(new int[]{4,5,6})));
    }
}
