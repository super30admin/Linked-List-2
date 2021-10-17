//	Timecomplexity:- O(m+n);
//Space complexity:-O(n);
//Did it run on leetcode:- Yes.
//What were the problems faced while doing it?:- got some wrongs
//:- Your code with explanation:- iterating over every element in LinkedListA and adding to hashset and again checking whether it is there or not in hashset in iteraton of linkedlistB if it is there at that point it is intersection.






public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode res = null;
        while(headA != null){
            set.add(headA);
            headA = headA.next;
        }
        
        while(headB != null){
            if(set.contains(headB)){
                res = headB;
                break;
            }
            headB = headB.next;
        }
        
        return res;
    }
}
