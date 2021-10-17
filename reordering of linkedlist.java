//	Timecomplexity:- O(n);
//Space complexity:-O(n);
//Did it run on leetcode:- Yes.
//What were the problems faced while doing it?:- got some wrng answers intially.
//:- Your code with explanation:- first every node value is added to created stack and created queue because after this insertions as stck is last in first out and queue is first in out we can at a time
// insert pop from stack after queue removal which gives first element from queue next top of the stack(last element).Like that we do until size/2 only because for only one iteration we are adding two elements.






class Solution {
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        Queue<ListNode> q = new LinkedList<>();
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            stack.push(temp);
            q.add(temp);
            temp = temp.next;
            size++;
        }
        
        int index = 0;
        temp = q.remove();
        while (index < size/2) {
            temp.next = stack.pop();
            temp = temp.next;
            temp.next = q.remove();
            temp = temp.next;
            index++;
        }
        temp.next = null;
    
    }
}