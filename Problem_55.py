class Solution:

	def findIntersection(self, headA, headB):

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


# Time Complexity : O(n) 
# Space Complexity : O(1)





