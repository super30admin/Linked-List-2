#// Time Complexity : O(n)
#// Space Complexity : O(1)
#// Did this code successfully run on Leetcode :yes

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        slow=headA
        fast=headB
        while(slow!=fast):
            if(slow!=None):
                slow=slow.next
            else:
                slow=headB
            if(fast!=None):
                fast=fast.next
            else:
                fast=headA
        return slow