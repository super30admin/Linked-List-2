# Time Complexity: O(n)
# Space Complexity: O(1)
# Approach:
# - First, find the middle of the list using a fast and slow pointer (Floyd's Algorithm)
# - Next, reverse the second half of the list(beginning from the mid) in-place.
# - Now we have the start of the first half and second half(reversed) lists
# - Traverse both lists and reorder elements, placing one element from either list during each iteration.

class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        if not head:
            return None
        first_list_end = self.find_mid(head)
        second_list_start = self.reverse(first_list_end)
        
        first, second = head, second_list_start
        
        while second.next:
            temp = first.next
            first.next = second
            first = temp
            
            temp = second.next
            second.next = first
            second = temp
        
    def find_mid(self, head):
        slow, fast = head, head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        return slow
    
    def reverse(self, head):
        current = head
        prev = None
        while current:
            next_node = current.next
            current.next = prev
            prev = current
            current = next_node
        return prev