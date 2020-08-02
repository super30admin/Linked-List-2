# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#Problem 1: Binary Search Tree Iterator
# Time complexity: O(n) to create the iterator, next costs O(1) time
# O(h) space, h is the height of the tree
#Worked on leetcode? Yes
'''
In the initialisation of the iterator, we will do an inorder traversal,
so we know that the elements array will be sorted , then we reverse it
and pop from there
'''

class BSTIterator:

    def __init__(self, root: TreeNode):
        self.inorder=[]
        st=[]
        while root or st:
            while root:
                st.append(root)
                root=root.left
            root=st.pop()
            self.inorder.append(root.val)
            root=root.right
        self.inorder=self.inorder[::-1]

    def next(self) -> int:
        """
        @return the next smallest number
        """
        if self.hasNext():
            return self.inorder.pop()


    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        if self.inorder:
            return True
        return False

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

#problem 2: Reorder List
#Time Complexity: O(n)
#Space Complexity : O(n)
#Worked on leetcode? Yes
'''
Traverse the linked list and keep a hashmap with indices as keys
and values as pointer to the node. This the orginal list. Then, from the
last element, we point last-1 to None, point last to start+1 and point
start to last.We increment the start pointer and decrement the last pointer.
We do this until first is >= to last index.
'''

class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        #edge case:
        if not head or not head.next:
            return head

        h={}
        idx=0
        while head:
            h[idx]=head
            head=head.next
            idx+=1
        start=0
        last=idx-1
        count=0

        #We don't want to more then n/2 swaps
        while count<int((idx-1)/2):
            h[last-1].next=None
            h[last].next=h[start+1]
            h[start].next=h[last]
            last-=1
            start+=1
            count+=1


#problem 3: Reorder List
#Time Complexity: O(n)
#Space Complexity : O(n)
#Worked on leetcode? Yes

#Problem 3: Delete without head pointer
#Time complexity: O(1)
#Space complexity: O(1)
#Did it work on geeksforgeeks? YES

'''
Since we only check value, we can change the present value
of our node as the next one, and point the current node to
the next next one
'''
def deleteNode(curr_node):
    #code here
    if not curr_node.next:
        curr_node=None
        return
    curr_node.data=curr_node.next.data
    curr_node.next=curr_node.next.next


#Problem 4: Intersection of Two linked Lists
#Time Complexity: O(n)
#Space Complexity: O(1)
#Worked on Leetcode? Yes

'''
Brute force: Compare each node to all the elements  in the other linked list
in an O(n^2) fashion until we find it.
'''
'''
Main idea: We see that as soon as they connect,
the length of the remaining linkedlist is the same. So if their lengths differ
by k,we only have to compare index i to index i+K in the longest array
'''
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        #edge case:
        if not headA or not headB:
            return None

        #find lengths
        nA=0
        nB=0
        currA=headA
        currB=headB
        while currA:
            nA+=1
            currA=currA.next
        while currB:
            nB+=1
            currB=currB.next
        diff=abs(nA-nB)
        if nA>=nB:
            big=headA
            small=headB
        else:
            big=headB
            small=headA

        for i in range(diff):
            big=big.next
        while small:
            if small==big:
                return small
            small=small.next
            big=big.next
        return None
