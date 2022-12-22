// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on geeks : yes
// Any problem you faced while coding this : no

class Solution
    {
        //Complete this function
        public void deleteNode(Node del)
        {
            //Your code here
            Node remove = del.next;
            del.data = remove.data;
            del.next = del.next.next;
        }

    }
