//Time complexity: O(n)
//Space Complexity:O(1)


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1=0;
        int l2=0;
        ListNode currA=headA;
        ListNode currB=headB;
        while(currA!=null){
            currA=currA.next;
            l1++;
        }
        while(currB!=null){
            currB=currB.next;
            l2++;
        }
        currA=headA;
        currB=headB;
        while(l1>l2){
            currA=currA.next;
            l1--;
        }
        while(l2>l1){
            currB=currB.next;
            l2--;
        }
        
        while(currA!=currB){
            currA=currA.next;
            currB=currB.next;
        }
        return currA;
    }
}