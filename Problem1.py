## Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)

# Node class used to make the tree
class Node(object):
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

# Method1: Loading entire BST into array via Inorder traversal
# Time Complexity : O(1) --- for constructor as it is called once only, so it runs for O(n) only once, O(1) -- for next(), O(1) -- for hasNext()
# Space Complexity : O(n) -- for the constructor O(1) -- for next(), O(1) -- for hasNext()
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here we do inorder traversal of the BST in the constructor and store it in an array. We keep our pointer at the first index of the 
# array. When next method is called, we return the element at the current pointer index and increment the pointer. When hasNext is called,
# we compare the pointer position to the length of the array. But this is not a correct approach for an iterator. Iterator has the property
# of lazy loading. If some of the elements got modified (added/deleted), then this solution would fail as the array is only created once in 
# the constructor. We would have to update the array again and again everytime it got modified to keep track of the changes

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator(object):

    # used for recursive inorder traversal
    def helper(self, root):
        # base
        if(not root):
            return

        self.helper(root.left)
        self.inorder.append(root.val)

        self.helper(root.right)
        


    def __init__(self, root):
        """
        :type root: Optional[TreeNode]
        """
        self.head = root
        # do inorder traversal and store the elements in array
        # since it is constructor it would be called only once
        self.inorder = []
        self.helper(root)
        # pointer to determine the next
        self.ptr = 0



    def next(self):
        """
        :rtype: int
        """
        curr = self.inorder[self.ptr]
        self.ptr += 1
        return curr

    def hasNext(self):
        """
        :rtype: bool
        """
        return (self.ptr < len(self.inorder))


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()

root = Node(100)

node50 = Node(50)
root.left = node50
node150 = Node(150)
root.right = node150
node20 = Node(20)
node50.left = node20
node80 = Node(80)
node50.right = node80
node130 = Node(130)
node150.left = node130
node180 = Node(180)
node150.right = node180
node10 = Node(10)
node20.left = node10
node30 = Node(30)
node20.right = node30
node70 = Node(70)
node80.left = node70
node120 = Node(120)
node130.left = node120
node140 = Node(140)
node130.right = node140
node170 = Node(170)
node180.left = node170
node200 = Node(200)
node180.right = node200

def inOrder(root):
    if(not root):
        return
    
    inOrder(root.left)
    print(root.val, end=" ")
    inOrder(root.right)

print("Inorder")
inOrder(root)
print()
print("Function Check")

iterator = BSTIterator(root)
print(iterator.hasNext())
print(iterator.next())

while(iterator.hasNext()):
    print(iterator.next(), end=" ")

print()

# Method2: Lazy loading iterators using stack. Here using controlled recursion
# Time Complexity : O(1) --- for constructor, O(h) -- for next() to keep the next batch but Amortized O(1), O(1) -- for hasNext()
# Space Complexity : O(1) -- for the constructor, O(h) for main stack + O(h) for recursive helper -- for next(), O(1) -- for hasNext()
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Iterators are lazy loading data structures. For them only the elements that are currently in the stack are important. For the rest of the 
# elements, if there added/deleted elements, iterators would be able to cater to them as well if they have already not been analysed. 
# Whatever changes are done they should be able to inculcate in their analysis as much as possible. We initialise our stack with
# elements starting from root and all the way left down while adding elements in the stack.
# So whenever we call next, we pop from top of the stack, we update the stack by going one step right and then all the way left.
# We return the popped element value
# down while keep adding elements in the stack. So in this way the top of the stack would always have the next element of the inorder traversal. 


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator(object):
    
    # helper to add in the stack
    def helper(self, root):
        if(not root):
            return

        self.stack.append(root)
        self.helper(root.left)


    def __init__(self, root):
        """
        :type root: Optional[TreeNode]
        """
        # iterative stack to keep note of next batch of elements
        self.stack = []
        self.helper(root)

    def next(self):
        """
        :rtype: int
        """
        # it is always a valid call
        curr = self.stack.pop()

        # get the next batch of elements
        # it would come by one step right, then all left down
        self.helper(curr.right)

        return curr.val

    def hasNext(self):
        """
        :rtype: bool
        """
        return (len(self.stack) > 0)


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()

iterator = BSTIterator(root)
print(iterator.hasNext())
print(iterator.next())

while(iterator.hasNext()):
    print(iterator.next(), end=" ")

print()


# Method3: Lazy loading iterators using stack. Here using controlled recursion
# Time Complexity : O(1) --- for constructor, O(h) -- for next() to keep the next batch but Amortized O(1), O(1) -- for hasNext()
# Space Complexity : O(1) -- for the constructor, O(h) for main stack-- for next(), O(1) -- for hasNext()
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here the algo is exact same as above. Just that here we are using iterative helper method to update the stack with the next batch of 
# processing for the iterators. It allows us to save O(h) recursion stack space that was being used when loading the next batch of elements

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator(object):
    
    # iterative helper to add in the stack
    def helper(self, root):
        while(root):
            self.stack.append(root)
            root = root.left


    def __init__(self, root):
        """
        :type root: Optional[TreeNode]
        """
        # iterative stack to keep note of next batch of elements
        self.stack = []
        self.helper(root)

    def next(self):
        """
        :rtype: int
        """
        # it is always a valid call
        curr = self.stack.pop()

        # get the next batch of elements
        # it would come by one step right, then all left down
        self.helper(curr.right)

        return curr.val

    def hasNext(self):
        """
        :rtype: bool
        """
        return (len(self.stack) > 0)


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()

iterator = BSTIterator(root)
print(iterator.hasNext())
print(iterator.next())

while(iterator.hasNext()):
    print(iterator.next(), end=" ")

print()