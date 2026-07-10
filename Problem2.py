# Problem 143. REORDER LIST
# TIME COMPELXITY: O(N) where N denotes the number of nodes that are there in the givne linked list
# SPACE COMPLEXITY: O(1) as we are only using pointers in order to reorder the list

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reorderList(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: None Do not return anything, modify head in-place instead.
        """
        fast=head
        slow=head

        while fast and fast.next:
            slow=slow.next
            fast=fast.next.next

        prev=None
        curr=slow.next
        slow.next=None

        while curr:
            temp=curr.next
            curr.next=prev
            prev=curr
            curr=temp
        
        #node=None
        first=head
        curr=prev
        
        while curr:
            temp1,temp2=first.next,curr.next
            first.next,curr.next=curr,temp1
            first,curr=temp1,temp2


