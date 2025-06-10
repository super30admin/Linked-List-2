
#Time Complexity: O(N)
#Space Complexity: O(1)

class Solution(object):
    def reorderList(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: None Do not return anything, modify head in-place instead.
        """
        slow, fast = head, head
        #Find the middle Half
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        cur = slow.next
        slow.next = None
        prev = None
        
        #Reverse the list
        while cur is not None:
            next_node = cur.next
            cur.next = prev
            prev = cur
            cur = next_node
        
        
        #Merge the lists
        p1 = head 
        p2 = prev


        while p2 is not None:
            temp = p2.next
            p2.next = p1.next
            p1.next = p2
            p1 = p1.next.next
            p2 = temp
