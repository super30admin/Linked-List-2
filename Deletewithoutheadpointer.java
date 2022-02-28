// space complexity - o(1)
//time - o(1) 4
//Ran on GFGS successfully : Yes
// Problem faced  : No
// Iterative approach : copy the next node value to current node and delete the next node.
class Solution
{
    void deleteNode(Node del)
         del.data = del.next.data;
         del.next = del.next.next;
    }
}
