"""
// Time Complexity :O(n) for all 3 functions.
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NA
//Explanation:
Calculate the mid.
Reverse the LL after mid.
Merge the linkedlist.
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head is None or head.next is None:
            return

        # middle
        slow,fast = head, head
        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next

        # reverse
        fast = self.reverse(slow.next)
        slow.next = None
        slow = head


        # merge
        current = fast
        while fast is not None:
            current = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = current
            slow = current

    def reverse(self,head):
        previous = None
        current = head
        fast = head.next

        while fast != None:
            current.next = previous
            previous = current
            current = fast
            fast = fast.next
        current.next = previous
        return current
"""
class Node:
  # constructor
  def __init__(self, data = None, next=None):
    self.data = data
    self.next = next

# A Linked List class with a single head node
class LinkedList:
  def __init__(self):
    self.head = None
    self.length=0

  def insert(self,data):
    newNode=Node(data)
    current = self.head
    if current is None:
      self.head = newNode
    else:
      while current.next is not None:
        current = current.next
      current.next = newNode

  def mergeLL(self):
    slow, fast = self.head, self.head
    while fast.next is not None and fast.next.next is not None:
      slow = slow.next
      fast = fast.next.next

    fast = self.reverseLL(slow)
    slow.next = None
    slow = self.head

    while fast:
      print("*",slow.data,fast.data)
      current = slow.next
      slow.next = fast
      fast = fast.next
      slow.next.next = current
      slow = current

  def reverseLL(self,m):
    pointer1 = None
    pointer2 = m.next
    while pointer2 is not None:
      pointer3 = pointer2.next
      pointer2.next = pointer1
      pointer1 = pointer2
      pointer2 = pointer3
    m.next = pointer1
    return pointer1



  def printLL(self):
    current = self.head
    print("#original")
    while current:
      print(current.data,current.next)
      current = current.next

if __name__ == "__main__":
  ll = LinkedList()
  ll.insert(1)
  ll.insert(2)
  ll.insert(3)
  ll.insert(4)
  ll.insert(5)
  ll.mergeLL()
  ll.printLL()
"""
