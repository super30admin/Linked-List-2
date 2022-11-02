/* Approach : The node to be deleted differs from next node only in its value. 
So update the current node value with next one and delete the next node.
*/
// Time Complexity : O(1)
// Space Complexity : O(1)

// public class Node{
    //     public int data;
    //     public Node next;
        
    //     public Node(int a){
    //         this.data = a;
    //         this.next = null;
    //     }
        
    // }
    class Solution
    {
        //Complete this function
        public void deleteNode(Node del)
        {
            //Your code here
            del.data = del.next.data;
            del.next = del.next.next;
        }

    }