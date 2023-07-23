# Time complexity : O(n)
# Space complexity : O(1)
# In Method 2, we get length of both LLs. Then move the head of the bigger one till they are equal.
# Once, equal we move the head of both of them, till the values match

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        # Method 1 - Hashset - SC-O(n)
        # node_set = set()
        # while headA:
        #     node_set.add(headA)
        #     headA = headA.next

        # while headB:
        #     if headB in node_set:
        #         return headB

        #     headB = headB.next
        # return None

        # Method 2 - 2 pointers
        la=0
        cur=headA
        while cur!=None:
            cur=cur.next
            la+=1
        lb=0
        cur=headB
        while cur!=None:
            cur=cur.next
            lb+=1
        
        while la>lb:
            headA=headA.next
            la-=1
        
        while la<lb:
            headB=headB.next
            lb-=1
            
        while headA!=headB:
            headA=headA.next
            headB=headB.next
        return headB

