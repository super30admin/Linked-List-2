# Time Complexity : O(hn)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

# we first find the mid of the LL - traverse with slow and fast ptr.
# then we reverse the second half of the LL from mid+1
# then merge the first half of LL and reversed LL half - by taking one from each LL.
class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        def reverse(headA):
            prev=None
            curr=headA
            if(headA.next is None):
                return headA
            fast=headA.next
            while(fast!=None):
                curr.next=prev
                prev=curr
                curr=fast
                fast=fast.next
            curr.next=prev
            return curr
        if(head==None or head.next is None):
            return head
        fast=head
        slow=head
        # print(fast)
        while((fast.next is not None) and (fast.next.next is not None)):
            slow=slow.next
            # print(fast)
            fast=fast.next.next
            # print(fast)
        
        # mid=slow
        

        fast=reverse(slow.next)
        slow.next=None
        # print(head)
        slow=head
        while(fast!=None):
            # print(slow)
            temp=slow.next
            # print(temp)
            slow.next=fast
            fast=fast.next
            slow.next.next=temp
            slow=temp