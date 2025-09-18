## Problem2 (https://leetcode.com/problems/reorder-list/)

# Method1: Using Two pointers on Array storing nodes
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Storing node references in an array. Then used two pointers one at start and another at end to make link in the required manner. Then we keep 
# squeezing the pointers closer.

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution(object):
    def reorderList(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: None Do not return anything, modify head in-place instead.
        """
        arr = []
        curr = head
        while(curr):
            arr.append(curr)
            curr = curr.next

        if(len(arr) <= 2):
            return head

        low = 0
        high = len(arr) - 1

        while(low < high):
            arr[low].next = arr[high]
            low += 1
            if(low < high):
                arr[high].next = arr[low]
                high -= 1

        head = arr[0]
        arr[high].next = None

        # return head
    
def printLinkedList(root):
    curr = root
    while(curr):
        print(curr.val, end=" -> ")
        curr = curr.next
    print()

print("Method1: Using Two pointers on Array storing nodes")
node1 = ListNode(1)
node2 = ListNode(2)
node3 = ListNode(3)
node4 = ListNode(4)
node5 = ListNode(5)
head = node1
node1.next = node2
node2.next = node3
node3.next = node4
node4.next = node5

sol = Solution()
print("eg:1")
sol.reorderList(head)
printLinkedList(head)

node1 = ListNode(1)
node2 = ListNode(2)
node3 = ListNode(3)
node4 = ListNode(4)

head = node1
node1.next = node2
node2.next = node3
node3.next = node4

sol = Solution()
print("eg:2")
sol.reorderList(head)
printLinkedList(head)

node1 = ListNode(1)
node2 = ListNode(2)

head = node1
node1.next = node2


sol = Solution()
print("eg:3")
sol.reorderList(head)
printLinkedList(head)

node1 = ListNode(1)
head = node1

sol = Solution()
print("eg:4")
sol.reorderList(head)
printLinkedList(head)


# Method2: Splitting the linked list into 2 halves and reversing the 2nd half
# Time Complexity : O(n) = O(n / 2) -- finding the middle + O(n / 2) --- reversing + O(n / 2) -- merging the two linked lists
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# We do this algo in three steps. First we find the middle of linked list using slow and fast pointer approach. For odd length we check using
# fast.next != null and for even length we can symmetric split and asymmetric split. For symmetric split we check fast.next.next != null and 
# for asymmetric split we check fast != null. Here we doing symmetric split. After the split, in second step, we reverse the second part. 
# We need to reverse because we need to keep track of nodes from back while merging. In third step, we merge the split linked lists. 
# We can do this using two temp variables as well as a single temp variable as well. Here I am using two variables

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reorderList(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: None Do not return anything, modify head in-place instead.
        """
        # step1: find the middle
        slow = head
        fast = head

        # for odd length stop at fast.next != null
        # for even length stop at fast.next.next != null for symmetric split
        while(fast.next and fast.next.next):
            slow = slow.next
            fast = fast.next.next

        # middle is at slow, split the linkedlist
        secondPart = slow.next
        slow.next = None

        # step2: reverse the second part
        prev = None
        curr = secondPart
        while(curr):
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        # step3: merge two linked lists using two temp variables
        slow = head
        # our new head of the reversed list
        fast = prev
        while(fast):
            temp = slow.next
            slow.next = fast
            temp1 = fast.next
            fast.next = temp
            slow = temp
            fast = temp1


print("Method2: Splitting the linked list into 2 halves and reversing the 2nd half")
node1 = ListNode(1)
node2 = ListNode(2)
node3 = ListNode(3)
node4 = ListNode(4)
node5 = ListNode(5)
head = node1
node1.next = node2
node2.next = node3
node3.next = node4
node4.next = node5

sol = Solution()
print("eg:1")
sol.reorderList(head)
printLinkedList(head)

node1 = ListNode(1)
node2 = ListNode(2)
node3 = ListNode(3)
node4 = ListNode(4)

head = node1
node1.next = node2
node2.next = node3
node3.next = node4

sol = Solution()
print("eg:2")
sol.reorderList(head)
printLinkedList(head)

node1 = ListNode(1)
node2 = ListNode(2)

head = node1
node1.next = node2


sol = Solution()
print("eg:3")
sol.reorderList(head)
printLinkedList(head)

node1 = ListNode(1)
head = node1

sol = Solution()
print("eg:4")
sol.reorderList(head)
printLinkedList(head)


# Method3: Splitting the linked list into 2 halves and reversing the 2nd half
# Time Complexity : O(n) = O(n / 2) -- finding the middle + O(n / 2) --- reversing + O(n / 2) -- merging the two linked lists
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# We do this algo in three steps. First we find the middle of linked list using slow and fast pointer approach. For odd length we check using
# fast.next != null and for even length we can symmetric split and asymmetric split. For symmetric split we check fast.next.next != null and 
# for asymmetric split we check fast != null. Here we doing asymmetric split. After the split, in second step, we reverse the second part. 
# We need to reverse because we need to keep track of nodes from back while merging. In third step, we merge the split linked lists. 
# We can do this using two temp variables as well as a single temp variable as well. Here I am using one temp variable. It is similar to above code
# as complexity is same

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reorderList(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: None Do not return anything, modify head in-place instead.
        """
        # step1: find the middle
        slow = head
        fast = head

        # for odd length stop at fast.next != null
        # for even length stop at fast != null for asymmetric split
        # for even length split would be 1 -> 2 -> 3 -> 4 and 5 -> 6
        while(fast and fast.next):
            slow = slow.next
            fast = fast.next.next

        # middle is at slow, split the linkedlist
        secondPart = slow.next
        slow.next = None

        # step2: reverse the second part
        prev = None
        curr = secondPart
        while(curr):
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        # step3: merge two linked lists using one temp variable
        slow = head
        # our new head of the reversed list
        fast = prev
        while(fast):
            temp = slow.next
            slow.next = fast
            # slow.next will hold our current fast. so we can move fast to fast.next
            fast = fast.next
            # slow.next will hold our previous fast.
            slow.next.next = temp
            slow = temp


print("Method3: Splitting the linked list into 2 halves and reversing the 2nd half")
node1 = ListNode(1)
node2 = ListNode(2)
node3 = ListNode(3)
node4 = ListNode(4)
node5 = ListNode(5)
head = node1
node1.next = node2
node2.next = node3
node3.next = node4
node4.next = node5

sol = Solution()
print("eg:1")
sol.reorderList(head)
printLinkedList(head)

node1 = ListNode(1)
node2 = ListNode(2)
node3 = ListNode(3)
node4 = ListNode(4)

head = node1
node1.next = node2
node2.next = node3
node3.next = node4

sol = Solution()
print("eg:2")
sol.reorderList(head)
printLinkedList(head)

node1 = ListNode(1)
node2 = ListNode(2)

head = node1
node1.next = node2


sol = Solution()
print("eg:3")
sol.reorderList(head)
printLinkedList(head)

node1 = ListNode(1)
head = node1

sol = Solution()
print("eg:4")
sol.reorderList(head)
printLinkedList(head)