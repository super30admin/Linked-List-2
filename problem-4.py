# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        temp1 = headA
        temp2 = headB
        
        # we loop through the node the smaller will reach null so we make it to point head of next linked list and we loop until noth reach same destination 
        while temp1 != temp2:
            if temp1==None:
                temp1=headB
            else:
                temp1=temp1.next
            if temp2==None:
                temp2=headA
            else:
                temp2=temp2.next
        return temp2
        