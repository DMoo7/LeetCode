// Problem

// 539. Minimum Time Difference

// Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.

// Example 1:

// Input: timePoints = ["23:59","00:00"]
// Output: 1
// Example 2:

// Input: timePoints = ["00:00","23:59","00:00"]
// Output: 0

// Constraints:

// 2 <= timePoints.length <= 2 * 104
// timePoints[i] is in the format "HH:MM".

function findMinDifference(timePoints: string[]): number {
  let mins: boolean[] = new Array(24 * 60).fill(false);

  for (let i = 0; i < timePoints.length; i++) {
    const [hours, minis] = timePoints[i].split(":");
    let totalMins = parseInt(hours, 10) * 60 + parseInt(minis, 10);

    if (mins[totalMins]) return 0;
    else mins[totalMins] = true;
  }

  let prev: number = -1;
  let minDiff: number = Infinity;
  let firstValue: number = -1;

  for (let curr = 0; curr < 1440; curr++) {
    if (mins[curr]) {
      if (prev === -1) {
        firstValue = curr;
        prev = curr;
      } else {
        minDiff = Math.min(minDiff, curr - prev);
        prev = curr;
      }
    }
  }

  if (prev !== -1) {
    minDiff = Math.min(minDiff, 1440 + firstValue - prev);
  }
  return minDiff;
}

console.log(findMinDifference(["00:00", "23:59", "00:00"]));
