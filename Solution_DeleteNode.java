//TC: O(n)
//SC: O(1)
//Did it run on leetcode: Yes
public class Solution_DeleteNode {
    void deleteNode(Node node) {
        // Your code here
        while(node.next.next != null){
            node.data = node.next.data;
            node = node.next;
        }
        node.data = node.next.data;
        node.next = null;
    }
}
