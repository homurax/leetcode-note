/*
1124. Longest Well-Performing Interval


We are given hours, a list of the number of hours worked per day for a given employee.

A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.

A well-performing interval is an interval of days for which the number of tiring days is strictly larger than the number of non-tiring days.

Return the length of the longest well-performing interval.



Example 1:

Input: hours = [9,9,6,0,6,6,9]
Output: 3
Explanation: The longest well-performing interval is [9,9,6].


Example 2:

Input: hours = [6,6,6]
Output: 0


Constraints:

1 <= hours.length <= 10^4
0 <= hours[i] <= 16
*/

func longestWPI(hours []int) int {
	ans := 0
	cur := 0
	seen := make(map[int]int)
	for i, v := range hours {
		if v > 8 {
			cur++
		} else {
			cur--
		}
		if cur > 0 {
			ans = i + 1
		} else {
			if _, ok := seen[cur-1]; ok {
				if i-seen[cur-1] > ans {
					ans = i - seen[cur-1]
				}
			}
			if _, ok := seen[cur]; !ok {
				seen[cur] = i
			}
		}
	}
	return ans
}
