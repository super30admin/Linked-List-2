// Time Complexity :o(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

def reference(self,node):
  node.val=node.next.val
  node.next=node.next.next
