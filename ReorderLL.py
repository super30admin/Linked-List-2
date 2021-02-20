# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# 1. find mid
# 2. reverse from mid.next - 
#                   1. using slow.next
#                   2. slow.next = None to detach
# 3. Merge two - Use chaining

class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head == None or head.next == None: return None
        slow = head
        fast = head
        #reverse function
        def rev(cur):
            prev = None
            fast = cur.next
            while fast:
                cur.next = prev
                prev = cur
                cur = fast 
                fast = fast.next
            cur.next = prev
            return cur
        
        # find mid
        while fast.next and fast.next.next:
            fast = fast.next.next
            slow = slow.next
        
        second = rev(slow.next)
        # detach
        slow.next = None
        cur = ListNode(-1)
        
        #merge
        while second and head:
            #taking from first LL
            cur.next = head
            cur = cur.next
            head = head.next
            
            #taking from second LL
            cur.next = second
            cur = cur.next
            second = second.next
            
        #remaining
        while second:
            cur.next = second
            cur = cur.next
            second = second.next
            
        #remaining
        while head:
            cur.next = head
            cur = cur.next
            head = head.next
        

            
            
        
        