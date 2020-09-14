#https://leetcode.com/problems/binary-search-tree-iterator/
# // Time Complexity : O(n) we run through the lists 2 times
#// Space Complexity : O(1) we have a constant number of pointers
#// Did this code successfully run on Leetcode : yes
#// Any problem you faced while coding this :
#
# keeping all the pointers straight before overwriting .next fields
#
#// Your code here along with comments explaining your approach
#
# use 2 pointers ala floyd's algorithm to get to the middle of the linkedlist
# p1 will be in the middle, p2 will either be null or the element before null
# reverse(p1.next) (2nd half of the list will be reversed), store in h2
# set p1.next = null to terminate list1
#
# you have 2 lists.
# for each position in l1 and l2
#   rearrange pointers to interleave them such that l1[i]->l2[i]
#   break if l2[i] is null
#
# return h1

ListNode = (val = 0, next = null) -> Object.assign(
  Object.create(ListNode::),
    val: val
    next: next
  )

reverse = (head) ->
  prev = null
  cur = head
  next = null

  while cur isnt null
    next = cur.next
    cur.next = prev
    prev = cur
    cur = next

  prev

#/**
# * @param {ListNode} head
# * @return {void} Do not return anything, modify head in-place instead.
# */
reorderList = (head) ->
  return if head is null

  p1 = head
  p2 = head

  while p2 isnt null and p2.next isnt null
    p1 = p1.next
    p2 = p2.next.next

  p2 = reverse(p1.next)
  p1.next = null

  temp1 = null
  temp2 = null
  p1 = head

  while p2 isnt null
    temp1 = p1.next
    temp2 = p2.next

    p1.next = p2
    p2.next = temp1

    p1 = temp1
    p2 = temp2

  head


#testList = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
#reorderList(testList)
