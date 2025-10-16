# Time Complexity : O(n) — we traverse the entire list once to store nodes,
#                   and then again to rearrange pointers.
# Space Complexity : O(n) — we store all nodes in an extra list.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Understanding how to correctly 
# reorder pointers without losing references between nodes.


# Your code here along with comments explaining your approach
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """

        # Edge case: if the list has 0 or 1 node, do nothing
        if not head or not head.next:
            return
        
        # Step 1️⃣: Traverse the list and store all nodes in an array for easy access
        nodeList = []
        curr = head
        while curr is not None:
            nodeList.append(curr)
            curr = curr.next
        
        # Step 2️⃣: Use two pointers (left from start, right from end)
        left, right = 0, len(nodeList) - 1
        
        # Step 3️⃣: Re-link nodes alternately from front and back
        while left < right:
            # Link left node to right node
            nodeList[left].next = nodeList[right]
            left += 1  # move left pointer forward

            # If pointers haven’t crossed, link right node to new left node
            if left < right:
                nodeList[right].next = nodeList[left]
                right -= 1  # move right pointer backward
            
        # Step 4️⃣: The last node must point to None to terminate the list
        nodeList[left].next = None