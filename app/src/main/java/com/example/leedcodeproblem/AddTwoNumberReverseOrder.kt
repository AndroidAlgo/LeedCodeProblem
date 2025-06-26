package com.example.leedcodeproblem


// Jitendra Created this class on 26-06-2025

class AddTwoNumberReverseOrder {
    fun SecondProblem() {
        val l1 = createLinkedList(listOf(2, 4, 3)) // Represents 342
        val l2 = createLinkedList(listOf(5, 6, 4)) // Represents 465

        val result = addTwoNumbers(l1, l2) // Should return 7 -> 0 -> 8

        print("Result: ${result}")
        printLinkedList(result)
    }

    // Helper function to create a linked list from a list of integers
    fun createLinkedList(nums: List<Int>): ListNode? {
        val dummy = ListNode(0)
        var current = dummy
        for (num in nums) {
            current.next = ListNode(num)
            current = current.next!!
        }
        return dummy.next
    }

    // Helper function to print a linked list
    fun printLinkedList(node: ListNode?) {
        var current = node
        while (current != null) {
            print("${current.`val`}")
            if (current.next != null) print(" -> ")
            current = current.next
        }
        println()
    }

}

// Function to add two numbers represented as linked lists
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val dummyHead = ListNode(0)
    var p = l1
    var q = l2
    var current = dummyHead
    var carry = 0

    while (p != null || q != null) {
        val x = p?.`val` ?: 0
        val y = q?.`val` ?: 0
        val sum = carry + x + y
        carry = sum / 10
        current.next = ListNode(sum % 10)
        current = current.next!!
        if (p != null) p = p.next
        if (q != null) q = q.next
    }

    if (carry > 0) {
        current.next = ListNode(carry)
    }

    return dummyHead.next
}


// Definition for singly-linked list.
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
