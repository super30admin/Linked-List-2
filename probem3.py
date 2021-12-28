# Time Complexity : O(1)
# Space Complexity : O(1)

# Did this code successfully run on Leetcode : 
# Not in Leetcode

# Any problem you faced while coding this : 
# Your code here along with comments explaining your approachclass Solution:


def deletewithouthead(node):
    if node == None :
        return
    if node.next == None:
        return 
    temp = TreeNode()
    temp = pos.next
    pos.val= pos.next.val
    pos.next = pos.next.next

