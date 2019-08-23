class Problem3:
	def findIntersection1(self, headA, headB):
		# Time Complexity : O(n) we are going over both the lists simultaneously where n is the number of elements in the longer list
		# Space Complexity : Not using any extra space
		# Accepted in leetcode
		tempA = headA
		tempB = headB
		while tempA != tempB:
			if tempA == None:
				tempA = headB
			else:
				tempA = tempA.next
			if tempB == None:
				tempB = headA
			else:
				tempB = tempB.next
		return tempA

	def findIntersection2(self, headA, headB):
		# Time Complexity : O(n^2) we are going over the entire list B for every node in list A
		# Space Complexity : Not using any extra space
		# Time limit exceeded in leetcode
		tempA = headA
		while tempA != None:
			tempB = headB
			while tempB != None:
				if tempA == tempB:
					return tempA
				tempB = tempB.next
			tempA = tempA.next
		return None

	def findIntersection2(self, headA, headB):
		# Time Complexity : O(n) we are going over the entire list only once where n is the number of elements in the longer list
		# Space Complexity : O(n) where n is the number of nodes in headA because we are storing the entire list in a dictionary
		# Accepted on the leetcode
		list_dict = dict() # dictionary to store the elements of headA
		tempA = headA
		while tempA != None:
            if tempA not in list_dict:
                list_dict[tempA] = tempA.val
            tempA = tempA.next
        tempB = headB
        while tempB != None:
            if tempB in list_dict: # we check if that node is already visited by the first list by checking the dictionary
                return tempB # if the dictionary contains the node then that is the intersection
            tempB = tempB.next
        return None