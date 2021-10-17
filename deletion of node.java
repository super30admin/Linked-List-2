//	Timecomplexity:- O(1);
//Space complexity:-O(1);
//Did it run on leetcode:- Yes.
//What were the problems faced while doing it?:- nothing
//:- Your code with explanation:- replacing data with next one's data and previous node connection to next node.


class Solution
{
    void deleteNode(Node del)
    {
         del.data=del.next.data;
         del.next=del.next.next;
    }
}
