/*SC - O(N), TC O(N)
 * Approach - reverse the second half of the linked list and createe a new list with taking elements from first and second half alternatively consecutively
 * */


class Solution {
    public  ListNode reverseNode(ListNode node){

        ListNode prev = null;

        ListNode temp = node;
        while(node != null){
            temp = node;
            node = node.next;
            temp.next = prev;
            prev = temp;
        }
        return  prev;
    }
    public void reorderList(ListNode head) {

        ListNode first = head;
        // get the middle most element
        ListNode slow = head; ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow is the middle most element now reverse the list starting the middle most element
        ListNode reversedNode = reverseNode(slow);

        while(reversedNode.next != null){
            ListNode temp = first.next;
            ListNode temp2 = reversedNode.next;
            first.next = reversedNode;
            reversedNode .next = temp;
            first = temp;
            reversedNode=temp2;
        }

    }
}
