# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
#Time Complexity:O(n)
#Space Complexity:O(1)
#I am calculating length of the two linked list, whihc ever is longer I move the pointer to the next node until the length of both linked list is same . Then I iterate through the n=both lists till then intersect and return the node where they intersect.
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        curr=headA
        lenA=0
        lenB=0
        while curr:
            lenA+=1
            curr=curr.next
        curr=headB
        while curr:
            lenB+=1
            curr=curr.next
        while(lenA>lenB):
            headA=headA.next
            lenA-=1
        while(lenB>lenA):
            headB=headB.next
            lenB-=1
        while(headA!=headB):
            headA=headA.next
            headB=headB.next
        return headB
        
            
