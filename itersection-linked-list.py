# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

'''
Time Complexity: O(n) where n is the length of the linked list
Space Complexity: O(1)

Approach:
We can use two pointers to iterate through the linked lists. 
The first pointer will be used to iterate through the first linked list, and the second pointer will be used to iterate through the second linked list. 
When the two pointers meet, we know that they are pointing to the same node, so we can return that node. 
If the two pointers do not meet, we know that they are not pointing to the same node, so we can return None.
'''

class Solution:
    def getIntersectionNode(
        self, headA: ListNode, headB: ListNode
    ) -> Optional[ListNode]:
        temp1 = headA
        temp2 = headB

        while temp1 != temp2:
            if temp1 == None:
                temp1 = headB
            else:
                temp1 = temp1.next
            if temp2 == None:
                temp2 = headA
            else:
                temp2 = temp2.next

        return temp1
