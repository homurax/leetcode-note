/*
2526. Find Consecutive Integers from a Data Stream


For a stream of integers, implement a data structure that checks if the last k integers parsed in the stream are equal to value.

Implement the DataStream class:

DataStream(int value, int k) Initializes the object with an empty integer stream and the two integers value and k.
boolean consec(int num) Adds num to the stream of integers. Returns true if the last k integers are equal to value, and false otherwise. If there are less than k integers, the condition does not hold true, so returns false.


Example 1:

Input
["DataStream", "consec", "consec", "consec", "consec"]
[[4, 3], [4], [4], [4], [3]]
Output
[null, false, false, true, false]

Explanation
DataStream dataStream = new DataStream(4, 3); //value = 4, k = 3
dataStream.consec(4); // Only 1 integer is parsed, so returns False.
dataStream.consec(4); // Only 2 integers are parsed.
                      // Since 2 is less than k, returns False.
dataStream.consec(4); // The 3 integers parsed are all equal to value, so returns True.
dataStream.consec(3); // The last k integers parsed in the stream are [4,4,3].
                      // Since 3 is not equal to value, it returns False.


Constraints:

1 <= value, num <= 10^9
1 <= k <= 10^5
At most 10^5 calls will be made to consec.
*/
type DataStream struct {
	value, k, cnt int
}

func Constructor(value int, k int) DataStream {
	return DataStream{value, k, 0}
}

func (d *DataStream) Consec(num int) bool {
	if num == d.value {
		d.cnt++
	} else {
		d.cnt = 0
	}
	return d.cnt >= d.k
}
