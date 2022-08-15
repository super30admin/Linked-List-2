// Time Complexity : O(n)
// Space Complexity : O(1)

public class intersection {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int length1=0;
            int length2=0;
            ListNode curr=headA;
            ListNode curr1=headB;
            while(curr!=null){
                curr=curr.next;
                length1++;
            }
             while(curr1!=null){
                curr1=curr1.next;
                length2++;
            }
            int count=0;
            int skip=0;
            curr=headA;
            curr1=headB;
            if(length1>length2){
                skip = length1-length2;
                while(count<skip){
                    curr = curr.next;
                    count++;
                }
            }
            else{
                skip = length2-length1;
                while(count<skip){
                    curr1 = curr1.next;
                    count++;
                }
            }
            while(curr!=null && curr1!=null){
                if(curr==curr1)
                    return curr;
                curr=curr.next;
                curr1=curr1.next;
            }
            return null;
        }
    }
}
