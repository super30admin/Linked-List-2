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
        """
        # conditions given 
        # given single linked list : so once there is a intersection point both the linked lists will be the same
        # the trick part is to start traversing both the linked lists from the same len such that when there intersect we can find the insection point
        # since both the lists differ in len, i will calcualte the len of both nodes and find the diff and star the iterating the bigger list from the difference between tehlists
        # such that i can travser from same len of the list and find the intersection point

        # tc : O(m+n) to find the lens, O(min(m,n)) to find the intersection val -> O(m+n)
        # sc : O(1) no extra space 


        currA = headA
        currB = headB

        lenA = self.length(currA)
        lenB = self.length(currB)

        x = abs(lenB - lenA)

        currA = headA
        currB = headB

        if lenA < lenB:
            return self.intersection(currA,currB,x)
        else:
            return self.intersection(currB,currA,x)

    
    def length(self, headA):
        length = 0
        while headA is not None:
            length +=1
            headA = headA.next

        return length


    def intersection(self,slow,fast,x):
        for i in range(x):
                fast = fast.next
            
        while slow is not None:
            if slow == fast:
                return slow
            slow = slow.next
            fast = fast.next

        return slow




