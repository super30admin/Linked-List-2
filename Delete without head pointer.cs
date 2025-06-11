/*
 Time complexity: O(1)
 Space complexity: O(1)

 Code ran successfully on GFG: Yes

 */

/*
class Node {
    public int data;
    public Node next;

    public Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public void DeleteNode(Node del_node) {
        // code here
        if(del_node==null && del_node.next==null)
            return;
            
        Node temp = del_node.next;
        del_node.data = temp.data;
        del_node.next = temp.next;
        
        temp = null;
    }
}
