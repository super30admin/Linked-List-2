//Delete without Head pointer
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :O(n)
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
We just have access of next node to the node to be deleted. 
We take the value of next node. Make the nodetoDelete's value as equal to next node's value
then we remove next node. We assign next pointer of nodeTobeDeleted to its next. Hence the reference of next node is 
null and its value is also null
*/
public class Problem3 {
    ListNode head;

    public static void main(String[] args){
        Problem3 p = new Problem3();
        p.head = new ListNode(1);
        p.head.next = new ListNode(2);
        p.head.next.next = new ListNode(3);
        p.head.next.next.next = new ListNode(4);
        p.head.next.next.next.next = new ListNode(5);
        p.deleteNode(p.head.next.next);
        while(p.head != null){
            System.out.print(" " +p.head.val);
            p.head = p.head.next;
        }

    }
    public void deleteNode(ListNode nodetoDel){
        //nodetoDel.next will not be null
        //nodetoDel will NOT be the last node and it will not be null
        int val = nodetoDel.next.val;
        nodetoDel.val = val;
        nodetoDel.next = nodetoDel.next.next;

    }
    
}
