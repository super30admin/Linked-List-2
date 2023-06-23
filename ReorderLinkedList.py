# Time Complexity : O(n) for each operation.
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to traverse till the mid point and reverse it and then create a new list with both half.

class Solution:
    def reverse(self, node):
        prev=None
        while(node!=None):
            temp=node.next
            node.next=prev
            prev=node
            node=temp
        return prev            

    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        f=head
        s=head
        while(f != None and f.next!=None):    
            f=f.next.next
            s=s.next
        f=self.reverse(s.next)
        s.next=None
        s=head

        while(f!=None):
            temp=s.next
            s.next=f
            f=f.next
            s.next.next=temp
            s=temp

        return head