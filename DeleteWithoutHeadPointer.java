// Time Complexity : O(1)
// Space Complexity : O(1)
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Explanation in the delete node function.

public class DeleteWithoutHeadPointer {
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // The below logic only applies if the node that needs to be deleted is not the tail node of the list.
    public static void deleteNode(ListNode del){
         // copy the value of the next node into the node(del) that needs to deleted.
         del.val = del.next.val;

         // Remove the next node corresponding to the delete node.
         del.next = del.next.next;
    }

    public static ListNode[] generateLinkedList(int[] nums, int n){

        ListNode head = null, prev = null, delete = null;
        for(int i = nums.length-1; i>=0; i--){
            head = new ListNode(nums[i], prev);
            prev = head;

            // Setting the index of the node that needs to be deleted.
            if(i == n-1) delete = head;
        }
        return new ListNode[]{head, delete};
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
        ListNode[] input = null;
        input = generateLinkedList(new int[]{1,3,4,9,8,5}, 3);
        deleteNode(input[1]);
        printList(input[0]);

        input = generateLinkedList(new int[]{10,8,23,45,67,9,8,12,234}, 5);
        deleteNode(input[1]);
        printList(input[0]);
        
        input = generateLinkedList(new int[]{4,5,6}, 2);
        deleteNode(input[1]);
        printList(input[0]);
    }

}
