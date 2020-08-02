#Time complexity: O(n)
#Space complexity: O(1)
# Works on leetcode: yes
#Approach: We first find the middle of the linked list and reverse the second half of the linked list. We then merge the first
# half and reversed second half of the linked list. 
def reverse(head):
    prev = None
    current = head
    while current:
        nextt = current.next
        current.next = prev
        prev = current
        current = nextt
    return prev

def split(head):
    s,f = head,head
    while f and f.next:
        s = s.next
        f = f.next.next
    middle = s.next
    s.next =None
    return head,middle

def merge(a,b):
    tail, head = a,a
    a = a.next
    while b:
        tail.next = b
        tail = tail.next
        b=b.next
        if a:
            a,b = b,a
    return head

class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head or not head.next:
            return
        a,b = split(head)
        b = reverse(b)
        head = merge(a,b)
        