/*
3440. Reschedule Meetings for Maximum Free Time II


You are given an integer eventTime denoting the duration of an event. You are also given two integer arrays startTime and endTime, each of length n.

These represent the start and end times of n non-overlapping meetings that occur during the event between time t = 0 and time t = eventTime, where the ith meeting occurs during the time [startTime[i], endTime[i]].

You can reschedule at most one meeting by moving its start time while maintaining the same duration, such that the meetings remain non-overlapping, to maximize the longest continuous period of free time during the event.

Return the maximum amount of free time possible after rearranging the meetings.

Note that the meetings can not be rescheduled to a time outside the event and they should remain non-overlapping.

Note: In this version, it is valid for the relative ordering of the meetings to change after rescheduling one meeting.



Example 1:

Input: eventTime = 5, startTime = [1,3], endTime = [2,5]

Output: 2

Explanation:



Reschedule the meeting at [1, 2] to [2, 3], leaving no meetings during the time [0, 2].


Example 2:

Input: eventTime = 10, startTime = [0,7,9], endTime = [1,8,10]

Output: 7

Explanation:



Reschedule the meeting at [0, 1] to [8, 9], leaving no meetings during the time [0, 7].


Example 3:

Input: eventTime = 10, startTime = [0,3,7,9], endTime = [1,4,8,10]

Output: 6

Explanation:



Reschedule the meeting at [3, 4] to [8, 9], leaving no meetings during the time [1, 7].


Example 4:

Input: eventTime = 5, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]

Output: 0

Explanation:

There is no time during the event not occupied by meetings.



Constraints:

1 <= eventTime <= 10^9
n == startTime.length == endTime.length
2 <= n <= 10^5
0 <= startTime[i] < endTime[i] <= eventTime
endTime[i] <= startTime[i + 1] where i lies in the range [0, n - 2].
*/
// 找最大的三个区域 a b c
// 遍历每一个区域, 如果两边没有 a/b/c, 则移动到 a/b/c
// 可以移动, ans = max(ans, 区域两边空区域场地之和加上移动的区域长度)
// 无法移动, 则只能移动到左右两边相邻的区域, ans = max(ans, 区域两边空区域场地之和)
func maxFreeTime(eventTime int, startTime []int, endTime []int) int {
	n := len(startTime)
	get := func(i int) int {
		if i == 0 {
			return startTime[0]
		}
		if i == n {
			return eventTime - endTime[n-1]
		}
		return startTime[i] - endTime[i-1]
	}

	a, b, c := 0, -1, -1
	for i := 1; i <= n; i++ {
		sz := get(i)
		if sz > get(a) {
			a, b, c = i, a, b
		} else if b < 0 || sz > get(b) {
			b, c = i, b
		} else if c < 0 || sz > get(c) {
			c = i
		}
	}

	ans := 0
	for i, e := range endTime {
		sz := e - startTime[i]
		if i != a && i+1 != a && sz <= get(a) ||
			i != b && i+1 != b && sz <= get(b) ||
			sz <= get(c) {
			ans = max(ans, get(i)+sz+get(i+1))
		} else {
			ans = max(ans, get(i)+get(i+1))
		}
	}
	return ans
}
