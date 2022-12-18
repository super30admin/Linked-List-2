""" 
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

Note that the linked lists must retain their original structure after the function returns.

Time Complexity: O(n)
Space Complexity: O(1)
"""

def getIntersectionNode(headA, headB):
    if not headA or not headB:
        return None
    
    a, b = headA, headB
    while a != b:
        a = a.next if a else headB
        b = b.next if b else headA
    
    return a