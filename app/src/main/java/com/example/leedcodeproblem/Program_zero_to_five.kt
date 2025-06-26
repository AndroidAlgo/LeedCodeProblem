package com.example.leedcodeproblem

import android.util.Log

class Program_zero_to_five {


    fun firstProblem() {
        var nums = intArrayOf(10, 40, 30, 20, 50)
        val target = 30
        Log.e("hjuhiuhgyu", "" + twoSum(nums, target).get(1))

    }

    fun twoSum(nums: IntArray, target: Int): IntArray {

        var map = mutableMapOf<Int, Int>()
//            optional for loop
//            for ((indes, value) in nums.withIndex()) {
//                map.put(indes, value)
//            }
        nums.forEachIndexed { index, value ->
            map.put(value, index)
        }
        nums.forEachIndexed { index, value ->

            var diff = target - value
            if (map.contains(diff)) {
                return intArrayOf(index, map.get(diff) as Int)
            }
        }
        return intArrayOf()
    }

}





