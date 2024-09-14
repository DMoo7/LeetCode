// 2419. Longest Subarray With Maximum Bitwise AND

// You are given an integer array nums of size n.

// Consider a non-empty subarray from nums that has the maximum possible bitwise AND.

// In other words, let k be the maximum value of the bitwise AND of any subarray of nums. Then, only subarrays with a bitwise AND equal to k should be considered.
// Return the length of the longest such subarray.

// The bitwise AND of an array is the bitwise AND of all the numbers in it.

// A subarray is a contiguous sequence of elements within an array.

 

// Example 1:

// Input: nums = [1,2,3,3,2,2]
// Output: 2
// Explanation:
// The maximum possible bitwise AND of a subarray is 3.
// The longest subarray with that value is [3,3], so we return 2.
// Example 2:

// Input: nums = [1,2,3,4]
// Output: 1
// Explanation:
// The maximum possible bitwise AND of a subarray is 4.
// The longest subarray with that value is [4], so we return 1.



function longestSubarray(nums: number[]): number {
  const maxi = Math.max(...nums);
  const n = nums.length;
  let ans = 1,
    cnt = 1;
  

  for (let i = 0; i < n; i++) {
    if (nums[i] === nums[i - 1]) {
      cnt++;
    } else {
      if (nums[i - 1] === maxi) {
        ans = Math.max(cnt, ans);
      }
      cnt = 1;
    }
  }

  if (nums[n - 1] === maxi) {
    ans = Math.max(cnt, ans);
  }
  return ans;
}
