# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
## when dealing with an iterator, we should be very clear of the definition of iterator. an iterator is a dynamic data structure.
## it does not care about the future elements its going to process. so keeping this in  mind we realize that we only process the next node as needed
## for this reason we go to depth of stack on the left side and put it in a stack. and when we try to get next we pop the element
## and go to its right once and go left on depth. we are basically perfoming inorder in a controlled manner. 
class solution:
    def __init__(self, root):
        self.stack= []

        while root:
            root = root.left
            self.stack.append(root)

    def next(self):
        curr = self.stack.pop()
        result = curr.right
        while result:
            self.stack.append(result)
            result = result.left
        return curr.val

    
    def hasNext(self):
        return self.stack

