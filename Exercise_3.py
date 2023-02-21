#Time Complexity : O(1), do not need to traverse through array.
#Space Complexity : O(1), no additional array is used.
#Did this code successfully run on Leetcode : Not a leetcode question.
#Any problem you faced while coding this : Did not think of strategy. 
#Your code here along with comments explaining your approach in three sentences only
'''Make the current node value the value of the next node. Then, skip the next node. 
'''

class Node:
    def __init__(self, x):
        self.val=x
        self.next=None

    
class Solution:
    def __init__(self, head):
        self.head = head

    def delete(self, mid):
        mid.val = mid.next.val
        mid.next = mid.next.next
    
    def print(self):
        temp = head
        while(temp!=None):
            print(temp.val)
            temp = temp.next

head = Node(1)
temp = head
temp.next=Node(2)
temp = temp.next
temp.next=Node(3)
temp = temp.next
mid = temp
temp.next = Node(4)

s = Solution(head)
s.print()
print(mid.val)
print()
s.delete(mid)
s.print()
