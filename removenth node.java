// Time Complexity : O(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

//Two pointers to the head. Move the fptr n times. and startt moving sptr until fptr reaches end. this makes sptr points to
//nth from the end.
//base condition--if sptr and sptr.next are null and n is one then return null list.
//In the middle of the traversal if fptr reaches null then check if is exceeding n times and move head.


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fptr=head,sptr=head;                   
        if(sptr==null || (sptr.next==null && n==1)) return null;
        int i=0;
        while(i<n){
           
            if(fptr.next==null){
                if(i==n-1) head=head.next;
            }
            i++;
            fptr=fptr.next;
        }
        if(fptr!=null){
            while(fptr.next!=null){
            fptr=fptr.next;
            sptr=sptr.next;
            }
        }
        
        sptr.next=sptr.next.next;
        return head;
    }
}