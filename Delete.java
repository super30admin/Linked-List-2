// Time Complexity : O(1)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class Delete {
    void deleteNode(Node node) {
        // Your code here
        
        if(node == null || node.next == null){
            return;
        }
        Node tmp = node.next;
        node.data = tmp.data;
        node.next = tmp.next;
    }
}
