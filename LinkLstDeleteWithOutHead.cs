using System;
using System.Collections.Generic;
using System.Text;

namespace LinkedList
{
    //Time Complexity: O(1)
    //Space Complexity: O(1)
    class DeleteNthNodeWithoutHead
    {
        public class Node
        {
            public int data;
            public Node next;

            public Node(int a)
            {
                this.data = a;
                this.next = null;
            }
        }

        public void DeleteNode(Node node)
        {
            Node temp = node.next;
            node.data = temp.data;
            node.next = temp.next;
        }

    }
}
