''' Time Complexity : O(n) 
    Space Complexity : O(1) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Approach : Distance from start to start of cycle is always equal to distance from fast to start of cycle
'''
class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None:
            return None
        #find if cycle exists
        slow = fast = head
        flag = False
        while fast.next and fast.next.next:
                slow = slow.next
                fast = fast.next.next

                if slow == fast:
                    flag = True
                    break
        if not flag:
            return None

        if fast.next is None or fast.next.next is None:
            return None
        # find the start of cyclw
        slow = head
        while slow != fast:
            slow = slow.next
            fast = fast.next
        return slow