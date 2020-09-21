package com.lgq.modeler.ds.search;

/**
 * 二分查找
 * Created by eric on 2019/1/2.
 *
 * @author shaofeng
 */
public class BinarySearch {
    public int searchV1(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int searchV2(int[] arr, int val) {
        int low = 0;
        int high = arr.length - 1;
        return bSearchInternal(arr, low, high, val);
    }

    private int bSearchInternal(int[] arr, int low, int high, int value) {
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1);
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] < value) {
            return bSearchInternal(arr, mid + 1, high, value);
        } else {
            return bSearchInternal(arr, low, mid - 1, value);
        }
    }

    /**
     * 查找第一个值等于给定值的元素
     *
     * @param arr
     * @param value
     * @return
     */
    public int bSearchFirst(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                // 此时 arr[mid] == value
                // if mid == 0，那这个元素已经是数组的第一个元素，那它肯定是我们要找的
                // if mid != 0，但 a[mid] 的前一个元素 a[mid-1]!=value
                if ((mid == 0) || (arr[mid - 1] != value)) {
                    return mid;
                } else {
                    //如果经过检查之后发现 a[mid] 前面的一个元素 a[mid-1] 也等于 value，
                    //那说明此时的 a[mid] 肯定不是我们要查找的第一个值等于给定值的元素。
                    //那我们就更新 high=mid-1，因为要找的元素肯定出现在 [low, mid-1] 之间。
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     *
     * @param arr
     * @param value
     * @return
     */
    public int bSearchLast(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == arr.length - 1) || (arr[mid + 1] != value)) {
                    return mid;
                } else {
                    //如果经过检查之后发现 a[mid] 前面的一个元素 a[mid+1] 也等于 value，
                    //那说明此时的 a[mid] 肯定不是我们要查找的最后一个值等于给定值的元素。
                    //那我们就更新 low=mid+1，因为要找的元素肯定出现在 [mid+1,high] 之间。
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     *
     * @param arr
     * @param value
     * @return
     */
    public int bSearchFirstGE(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] >= value) {
                if ((mid == 0) || (arr[mid - 1] != value)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     *
     * @param arr
     * @param value
     * @return
     */
    public int bSearchLastLE(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] <= value) {
                if ((mid == arr.length - 1) || (arr[mid + 1] > value)) {
                    return mid;
                } else {
                    //如果经过检查之后发现 a[mid] 前面的一个元素 a[mid+1] 也等于 value，
                    //那说明此时的 a[mid] 肯定不是我们要查找的最后一个值等于给定值的元素。
                    //那我们就更新 low=mid+1，因为要找的元素肯定出现在 [mid+1,high] 之间。
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 5, 6, 8, 8, 8, 9, 10};
        BinarySearch binarySearch = new BinarySearch();
        int val = 9;
        int searchResult = binarySearch.searchV1(arr, val);
        System.out.println(">>>Search(Using method v1) result = " + searchResult);
        searchResult = binarySearch.searchV2(arr, val);
        System.out.println(">>>Search(Using method v2) result = " + searchResult);

        searchResult = binarySearch.bSearchFirst(arr, 8);
        System.out.println(">>>Search(Using search first method) result = " + searchResult);

        searchResult = binarySearch.bSearchLast(arr, 8);
        System.out.println(">>>Search(Using search last method) result = " + searchResult);

        searchResult = binarySearch.bSearchFirstGE(arr, 8);
        System.out.println(">>>Search(Using search first greater/equal method) result = " + searchResult);

        searchResult = binarySearch.bSearchLastLE(arr, 8);
        System.out.println(">>>Search(Using search last less/equal method) result = " + searchResult);
    }
}
