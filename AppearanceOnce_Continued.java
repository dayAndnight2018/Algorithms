public int FindNumAppearOnce(int[] array) {
        if (array == null || array.length < 1) {
            return -1;
        }

        int[] bitSum = new int[8 * 4];// 所有元素的各个bit分别相加

        for (int i = 0; i < array.length; i++) {
            int bitFlag = 1;  // bit & 1 = bit 如：xxx & 010 = 0x0
            for (int j = 31; j >= 0; j--) {
                int bit = array[i] & bitFlag;  
                bitSum[j] += bit == 0 ? 0 : 1; 
                bitFlag = bitFlag << 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result += bitSum[i] % 3;
        }

        return result;
    }
