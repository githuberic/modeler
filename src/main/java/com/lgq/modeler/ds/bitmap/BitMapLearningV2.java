package com.lgq.modeler.ds.bitmap;

/**
 * @author lgq
 */
public class BitMapLearningV2 {
    private int[] bitArr;

    public BitMapLearningV2(long size) {
        bitArr = new int[(int) (size / 32 + 1)];
    }

    public boolean isExists(int num) {
        //确定数组 index
        int arrayIndex = num >> 5;
        //确定bit index
        int bitIndex = num & 31;

        return ((bitArr[arrayIndex] & (1 << bitIndex)) != 0) ? true : false;
    }

    public void add(int  num){
        //确定数组 index
        int arrayIndex = num >> 5;
        //确定bit index
        int bitIndex = num & 31;
        //设置0
        bitArr[arrayIndex] |= 1 << bitIndex;
    }

    /**
     * 将整型数字转换为二进制字符串，一共32位，不舍弃前面的0
     *
     * @param num 整型数字
     * @return 二进制字符串
     */
    private static String get32BitBinaryString(int num) {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            sBuilder.append(num & 1);
            num = num >>> 1;
        }
        return sBuilder.reverse().toString();
    }

    public static void main(String[] args) {

        int[] arrays = new int[]{1, 2, 35, 22, 56, 334, 245, 2234, 54};

        BitMapLearningV2 bigMapTest = new BitMapLearningV2(2234-1);

        for (int i : arrays) {
            bigMapTest.add(i);
        }
        System.out.println(bigMapTest.isExists(35));
    }

    // from https://blog.csdn.net/woshilijiuyi/article/details/88778214
}
