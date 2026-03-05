// Solution - 1 

// Time Complexity: O(1)
// Space Complexity: O(1)

class Solution {
    public void deleteNode(Node del_node) {
        // code here
        Node curr = del_node;
        Node temp = curr.next;
        curr.data = curr.next.data;
        curr.next = curr.next.next;
        temp.next = null;
    }
}

// Solution - 2

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public void deleteNode(Node del_node) {
        // code here
        Node curr = del_node;
        Node temp = curr.next;
        while(temp.next!=null) {
            curr.data = temp.data;
            curr = temp;
            temp = temp.next;
        }
        curr.data = temp.data;
        curr.next = null;
    }
}
