# Time Complexity : O(1)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : -

def deleteNode(node):
    if node.next:
        node.val = node.next.val
        node.next = node.next.next
    else:
        node = None