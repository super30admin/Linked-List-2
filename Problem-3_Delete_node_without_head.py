# APPROACH  
# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : N/A
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Here the pointer to the node to be deleted is given. and not the head of the list
# 2. So copy the next node's value to this node
# 3. And assign the next pointer apprpriately

def delete(node):
  node.val = node.next.val
  node.next = node.next.next
