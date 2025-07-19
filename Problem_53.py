'''
143. Reorder List
Problem Link: https://leetcode.com/problems/reorder-list/
'''

# Time Complexity : 
# Space Complexity : 
# Did this code successfully run on Leetcode : 
# Any problem you faced while coding this :

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from typing import Optional

class Solution:
    def reorderList(self, head: Optional['ListNode']) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        '''
        Intuition:
        1. Find the middle of the linked list using the slow and fast pointer technique.
        2. Reverse the second half of the linked list.
        3. Merge the two halves of the linked list.
        Time Complexity: O(n), where n is the number of nodes in the linked list.
        Space Complexity: O(1), as we are modifying the linked list in-place.
        '''
        if not head or not head.next: # Agar linked list khali hai ya sirf ek node hai to reorder nahi karna (if the linked list is empty or has only one node, no reordering needed)
            return None # hum None return karte hain (return None for empty linked list)
        # Step 1: Find the middle of the linked list using slow and fast pointers
        # slow pointer moves one step at a time, fast pointer moves two steps at a time
        slow, fast = head, head # head se slow aur fast pointers ko initialize karte hain (initialize slow and fast pointers to head)
        # jab tak fast pointer ke next aur next.next None nahi ho jata (while fast pointer's next and next.next are not None)
        # isse hum middle node tak pahunchte hain (this helps us reach the middle node)
        # agar fast pointer ke next ya next.next None ho jata hai to hum middle node tak pahunch gaye hain (if fast pointer's next or next.next is None, we have reached the middle node)
        # isse hum second half ko reverse karne ke liye use karte hain (this will be used to reverse the second half)
        while fast.next is not None and fast.next.next is not None: # jab tak fast pointer ke next aur next.next None nahi ho jata (while fast pointer's next and next.next are not None)
            slow = slow.next # slow pointer ko next node par le jate hain (move slow pointer to the next node)
            fast = fast.next.next # fast pointer ko next.next node par le jate hain (move fast pointer to the next.next node)
        # slow pointer ab middle node par hai (slow pointer is now at the middle node)
        # Step 2: Reverse the second half of the linked list 
        fast = self.reverseList(slow.next) # slow.next se second half ko reverse karte hain (reverse the second half starting from slow.next)
        # fast pointer ab second half ke head par hai (fast pointer is now at the head of the second half)
        # slow pointer ab middle node par hai (slow pointer is now at the middle node)
        
        # Disconnect the first half from the second half       
        slow.next = None # disconnect the first half from the second half
        # slow pointer ab first half ke last node par hai (slow pointer is now at the last node of the first half)
        # fast pointer ab second half ke head par hai (fast pointer is now at the head of the second half)
        slow = head # slow pointer ko head se reset karte hain (reset slow pointer to head)
        # Step 3: Merge the two halves of the linked list
        while fast is not None: # jab tak fast pointer None nahi ho jata (while fast pointer is not None)
            temp = slow.next # slow.next ko temporary variable me store karte hain (store slow.next in a temporary variable)
            slow.next = fast # slow.next ko fast pointer se connect karte hain (connect slow.next to fast pointer)
            fast = fast.next # fast pointer ko next node par le jate hain (move fast pointer to the next node)
            slow.next.next = temp # slow.next.next ko temporary variable se connect karte hain (connect slow.next.next to the temporary variable)
            slow = temp # slow pointer ko temporary variable se connect karte hain (connect slow pointer to the temporary variable)
            # isse hum dono halves ko merge karte hain (this merges both halves)
        # The linked list is now reordered in-place

    def reverseList(self, head: Optional['ListNode']) -> Optional['ListNode']: # humne ek helper function banaya hai jo linked list ko reverse karta hai (we created a helper function to reverse the linked list)
            
        if head is None or head.next is None: # agar linked list khali hai ya sirf ek node hai to reverse nahi karna (if the linked list is empty or has only one node, no reversal needed)
            return head # hum head return karte hain (return head for empty linked list)
        prev = None # previous node ko None se initialize karte hain (initialize previous node to None)
        curr = head # current node ko head se initialize karte hain (initialize current node to head)
        while curr: # jab tak current node None nahi ho jata (while current node is not None)
            nxt = curr.next # next node ko current node ke next se store karte hain (store the next node in a temporary variable)
            curr.next = prev # current node ke next ko previous node se connect karte hain (connect current node's next to the previous node)
            # isse hum current node ko reverse karte hain (this reverses the current node)
            prev = curr # ab previous node ko current node se connect karte hain (connect previous node to the current node)
            # isse hum previous node ko current node se connect karte hain (this connects the previous node to the current node)
            curr = nxt # current node ko next node par le jate hain (move current node to the next node)
        # ab previous node last node hai aur linked list reverse ho chuki hai (now the previous node is the last node and the linked list is reversed)
        # hum previous node ko return karte hain (we return the previous node)
        return prev
