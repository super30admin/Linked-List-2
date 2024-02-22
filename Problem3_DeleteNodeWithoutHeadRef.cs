// Time Complexity : O(1)
// Space Complexity : O(1)

//User function Template for C#

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
            //Copy next node's details into deleting node
              del.data = del.next.data;
              del.next = del.next.next;
        }
    }