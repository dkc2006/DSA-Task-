class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy node to simplify handling the result
        ListNode current = dummy;
        int carry = 0;

        // Traverse both lists
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; // Start with the carry from the previous step

            if (l1 != null) {
                sum += l1.val; // Add value from l1 if available
                l1 = l1.next; // Move to the next node
            }

            if (l2 != null) {
                sum += l2.val; // Add value from l2 if available
                l2 = l2.next; // Move to the next node
            }

            carry = sum / 10; // Update carry for the next step
            current.next = new ListNode(sum % 10); // Create a new node for the digit
            current = current.next; // Move to the next node in the result list
        }

        return dummy.next; // Skip the dummy node and return the actual result
    }
}
