# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

#starting both after advancing longer ll head by the difference of lengths

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        f = headA
        s = headB

        while f and s:
            if f == s: return f
            f=f.next
            s=s.next
        
        count = 0
        if f and not s:
            while f:
                f=f.next
                count += 1
        
            tf=headA
            while count:
                tf=tf.next
                count-=1
            f=tf
            s=headB
        elif s and not f:
            while s:
                s=s.next
                count+=1

            ts = headB
            while count:
                ts = ts.next
                count -= 1
            f=headA
            s=ts
        
        while f and s:
            if f == s: return f
            f=f.next
            s=s.next
        
        return None
        

