#https://leetcode.com/problems/intersection-of-two-linked-lists/
#// Time Complexity : O(n) where n is length of the longest list
#// Space Complexity : O(1) constants pointers
#// Did this code successfully run on Leetcode : yes (finally)
#// Any problem you faced while coding this :
#
# i was returning the value, but leetcode wanted a reference to the node
# also struggled with understanding that we are comparing node reference not node.value
#
#// Your code here along with comments explaining your approach
#
# Find the length of the 2 lists.
# Determine the longer one if any
# Advance the pointer along the longer one by the lengths difference, if any
# Advance step by step along each list checking
#   if values are the same, return that node's reference
#   if you hit null, no intersection return null

ListNode = (val = -1, next = null) -> Object.assign(
  Object.create(ListNode::),
    val: val
    next: next
  )

getIntersectionNode = (headA, headB) ->
  sizeA = 0
  sizeB = 0

  dummyA = headA
  dummyB = headB

  while dummyA isnt null
    dummyA = dummyA.next
    sizeA += 1

  while dummyB isnt null
    dummyB = dummyB.next
    sizeB += 1

  dummyA = headA
  dummyB = headB

  if sizeA > sizeB
    while sizeA != sizeB
      sizeA -= 1
      dummyA = dummyA.next
  else
    while sizeA != sizeB
      sizeB -= 1
      dummyB = dummyB.next

  while dummyA isnt null and dummyB isnt null
    return dummyA if dummyA is dummyB
    dummyA = dummyA.next
    dummyB = dummyB.next

  null

#node8 = ListNode(8, ListNode(4, ListNode(5)))
#node1 = ListNode(5, ListNode(6, ListNode(1, node8)))
#node4 = ListNode(4, ListNode(1, node8))
#getIntersectionNode(node1, node4) is 8

#node5 = ListNode(5, ListNode(6, ListNode(7)))
#node1 = ListNode(1, ListNode(2, node5))
#node3 = ListNode(3, ListNode(4, node5))
#getIntersectionNode(node1, node3) is 5
