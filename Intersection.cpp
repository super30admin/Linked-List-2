
TC:O(N1+N2);
SC:O(1);
// It starts by calculating the lengths of both lists and determines the difference. 
// Then, it adjusts the starting points of the lists to align them based on the difference. 
// Finally, it iterates through both lists simultaneously until an intersection node is found or 
// reaches the end, returning the intersection node or nullptr if no intersection exists

class Solution {
public:
    // Function to find the intersection node of two linked lists.
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        // If either of the lists is empty, there can't be an intersection.
        if(headA == nullptr || headB == nullptr)
            return nullptr;

        // Initialize two temporary pointers to iterate through the lists.
        ListNode* temp1 = headA;
        ListNode* temp2 = headB;

        // Variables to keep track of the lengths of the lists.
        int count1 = 0;
        int count2 = 0;

        // Count the number of nodes in the first list.
        while(temp1) {
            count1++;
            temp1 = temp1->next;
        }

        // Count the number of nodes in the second list.
        while(temp2) {
            count2++;
            temp2 = temp2->next;
        }

        // Calculate the difference in lengths between the two lists.
        int diff = abs(count1 - count2);

        // Move the pointer of the longer list ahead by the difference.
        if(count1 > count2) {
            while(diff != 0) {
                headA = headA->next;
                diff--;
            }
        }
        else {
            while(diff != 0) {
                headB = headB->next;
                diff--;
            }
        }

        // Traverse both lists until an intersection node is found.
        while(headA && headB) {
            if(headA == headB)
                return headA;

            headA = headA->next;
            headB = headB->next;
        }

        // If no intersection is found, return nullptr.
        return nullptr;
    }
};
