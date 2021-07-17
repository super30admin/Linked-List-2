# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA, headB) :

        p1 = headA
        p2 = headB

        while p1 != p2:

            if not p1:
                p1 = headB
            else:
                p1 = p1.next
            if not p2:
                p2 = headA
            else:
                p2 = p2.next

        return p1

#         node1=headA
#         node2=headB
#         m=0
#         n=0

#         while node1!=None:
#             m+=1
#             node1=node1.next

#         while node2!=None:
#             n+=1
#             node2=node2.next

#         if m<n:
#             node1,node2=node2,node1

#         node1=headA
#         node2=headB

#         for i in range (abs(m-n)):
#             node2=node2.next

#         while node1!=node2:
#             node1.next=node1
#             node2=node2.next

#         return node1
