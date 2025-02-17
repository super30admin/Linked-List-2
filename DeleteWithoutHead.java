//The idea here is to copy the data of the next node to the node given and then remove the next node from the linkedlist
//Time Complexity: O(1)
//Space complexity: O(1)

class Node
{
    int data ;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}


class Solution {
    void deleteNode(Node node) {
        // Your code here
        if(node == null || node.next == null){
            return;
        }
        
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
