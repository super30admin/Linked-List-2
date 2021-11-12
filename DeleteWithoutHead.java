//Time Complexity: O(n)
//Space Complexity: O(1)

class Solution
{
    void deleteNode(Node del)
    {
        if(del==null)
            return;
        Node temp=del;
        while(del.next!=null){
            del.data = del.next.data;
            temp = del;
            del = del.next;
        }
        temp.next=null;
    }
}

