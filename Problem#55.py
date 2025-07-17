'''
160. Intersection of Two Linked Lists
Problem Link: https://leetcode.com/problems/intersection-of-two-linked-lists/
'''

# Time Complexity : 
# Space Complexity : 
# Did this code successfully run on Leetcode : 
# Any problem you faced while coding this :

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        '''
        Intuition:
        Two pointers currA and currB traverse the two linked lists. they keep track of the lengths of the lists.
        When one pointer reaches the end, it starts traversing the other list.If there is an intersection, the two pointers will meet at the intersection node.
        If there is no intersection, both pointers will reach the end of their respective lists at the same time.
        Time Complexity: O(m + n), where m and n are the lengths of the two linked lists.
        Space Complexity: O(1), as we are using only two pointers.
        '''
        if not headA or not headB: # Agar dono linked lists me se koi bhi khali hai to intersection nahi ho sakta (if either linked list is empty, there can't be an intersection)
            return None # hum empty linked list return karte hain (return None for empty linked list)
        currA, currB = headA, headB # currA aur currB ko dono linked lists ke head se initialize karte hain (initialize currA and currB to the heads of both linked lists)
        # dono linked lists ke lengths ko track karne ke liye variables (variables to track the lengths of both linked lists)
        lenA, lenB = 0, 0 # dono linked lists ke lengths ko 0 se initialize karte hain (initialize lengths to 0)
        # dono linked lists ke lengths ko calculate karte hain (calculate the lengths of both linked
        while currA is not None: # jab tak currA None nahi ho jata (while currA is not None)
            lenA += 1 # currA ki length ko increment karte hain (increment length of currA)
            currA = currA.next # currA ko next node par le jate hain (move currA to the next node)
        currA = headA # currA ko headA se reset karte hain (reset currA to headA)
        while currB is not None: # jab tak currB None nahi ho jata (while currB is not None)
            lenB += 1 # currB ki length ko increment karte hain (increment length of currB)
            currB = currB.next # currB ko next node par le jate hain (move currB to the next node)
        currB = headB # currB ko headB se reset karte hain (reset currB to headB)
        
        # dono linked lists ke lengths ko equal karte hain (make the lengths of both linked lists equal)
        while lenA > lenB: # jab tak currA ki length currB se zyada hai (while length of currA is greater than length of currB)
            currA = currA.next # currA ko next node par le jate hain (move currA to the next node)
            lenA -= 1 # currA ki length ko decrement karte hain (decrement length of currA)
        while lenB > lenA: # jab tak currB ki length currA se zyada hai (while length of currB is greater than length of currA)
            currB = currB.next # currB ko next node par le jate hain (move currB to the next node)
            lenB -= 1 # currB ki length ko decrement karte hain (decrement length of currB)
        # dono linked lists ke lengths ko equal karne ke baad, dono pointers ko same position par le aate hain (after making the lengths of both linked lists equal, move both pointers to the same position)
        # ab dono pointers ko traverse karte hain (now traverse both pointers)
        while currA is not None and currB is not None: # jab tak dono pointers None nahi ho jate (while both pointers are not None)
            if currA == currB: # agar dono pointers same node par hain (if both pointers are at the same node)
                return currA # to wahi intersection node hai (return the intersection node)
            currA = currA.next # currA ko next node par le jate hain (move currA to the next node)
            currB = currB.next # currB ko next node par le jate hain (move currB to the next node)
        # agar dono pointers None ho gaye hain, to intersection nahi hai (if both pointers are None, there is no intersection)
        return None # return None for no intersection