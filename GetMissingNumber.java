//对于长度为n-1的数组，是递增有序的，每个数字都在0~n-1之间，有且仅有一个数字不在数组中，找出这个数字。
public class GetMissingNumber {
    public int getMissingNumber(int[] array) {
        if (array == null || array.length < 1) {
            return -1;
        }
        //设置头指针
        int low = 0;
        //设置尾指针
        int high = array.length-1;
        //设置中间指针
        int middle = 0;
        //如果元素与索引一致，说明没有缺失，继续递增。如果不一致，如果是第一个元素，那就是第一个不在数组，如果前一个一致，当前不一致，那就是当前元素。
        //否则继续二分查找
        while (low <= high) {
            middle = low + ((high - low) >> 1);
            if (array[middle] != middle) {
                if (middle == 0 || array[middle-1] == middle-1) {
                    return mid;
                }
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }

        if (low == array.length-1) {
            return array.length;
        }
        return -1;
    }
