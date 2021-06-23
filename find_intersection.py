# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        :SC:O(1):
        :TC:O(n)
        """
     
     # key idea - intersect when they point to same node
        if headA is None or headB is None:
            return None
      
        la=0
        lb=0
        pa=headA
        pb=headB
          
        # find lengths off lists
        while pa is not None:
            la+=1
            pa=pa.next
        while pb is not None:
            lb+=1
            pb=pb.next
        pa=headA
        pb=headB
        
        # move till both have equal length
        if la>lb:
            for i in range(la-lb):
                pa=pa.next
        elif lb>la:
            for i in range(lb-la):
                pb=pb.next
        while pa!=pb:
            pa=pa.next
            pb=pb.next
        return pa
    
    
        