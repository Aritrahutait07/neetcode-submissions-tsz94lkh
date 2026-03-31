/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {

        int peak = findpeak(mountainArr, 0, mountainArr.length() - 1);

        // search left (ascending)
        int left = search(mountainArr, 0, peak, target, true);
        if (left != -1) return left;

        // search right (descending)
        return search(mountainArr, peak + 1,
                mountainArr.length() - 1, target, false);
    }

    // -------- FIND PEAK (RECURSIVE) ----------
    public int findpeak(MountainArray m, int left, int right) {

        if (left == right) {
            return left;
        }

        int mid = left + (right - left) / 2;

        // compare mid with mid+1 (SAFE)
        if (m.get(mid) < m.get(mid + 1)) {
            // still climbing → peak right side
            return findpeak(m, mid + 1, right);
        } else {
            // descending → peak at mid or left
            return findpeak(m, left, mid);
        }
    }

    // -------- RECURSIVE BINARY SEARCH ----------
    public int search(MountainArray mountainArr,
                      int left,
                      int right,
                      int target,
                      boolean ascending) {

        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        int value = mountainArr.get(mid);

        if (value == target) {
            return mid;
        }

        if (ascending) {
            // normal binary search
            if (value > target)
                return search(mountainArr, left, mid - 1, target, true);
            else
                return search(mountainArr, mid + 1, right, target, true);
        } else {
            // reverse binary search (descending part)
            if (value > target)
                return search(mountainArr, mid + 1, right, target, false);
            else
                return search(mountainArr, left, mid - 1, target, false);
        }
    }
}
