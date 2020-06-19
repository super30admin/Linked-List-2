   ----------------------Delete Node in a List--------------------------------------   
# Time Complexity : O(1)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here as i dont have the access to the head node, I cannot iterate through the linked list. so I will copy the next node value into te deleted node and deleted the next node.

 
 
 def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        node.val = node.next.val
        node.next = node.next.next