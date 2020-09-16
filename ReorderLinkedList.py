// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head is None or head.next is None:
            return head
        #find the middle
        slow=head
        fast=head
        while fast and fast.next:
            slow=slow.next
            fast=fast.next.next
        # reverse second half
        curr=slow.next
        slow.next=None
        prev=None
        while curr:
            nxt=curr.next
            curr.next=prev
            prev=curr
            curr=nxt
        headB=prev
        
        #merge 2 lists
        while headB:
            temp1=head.next
            head.next=headB
            temp2=headB.next
            headB.next=temp1
            head=temp1
            headB=temp2
        
        return head
        

            