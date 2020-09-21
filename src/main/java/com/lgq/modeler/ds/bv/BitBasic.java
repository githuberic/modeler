package com.lgq.modeler.ds.bv;

/**
 * Created by eric on 2019/1/30.
 */
public class BitBasic {
    public static void main(String[] args) {
        int n = 3;
        int result = n << 1;
        System.out.printf("%b", result);
        System.out.println(Integer.toBinaryString(result));

        //n * 2 等价于 n << 1； n * 5 等价于 n << 2 + 1； n / 2 等价于 n >> 1


        // 1. 获得int型最大值；2147483647的十六进制为0x7FFFFFFF,其中最高位为符号位
        System.out.println((1 << 31) - 1);// 2147483647， 由于优先级关系，括号不可省略
        System.out.println(~(1 << 31));// 2147483647

        // 2. 获得int型最小值
        System.out.println(1 << 31);
        System.out.println(1 << -1);

        // 3. 判断一个数n是不是2的幂
        n = 16;
        System.out.println((n & (n - 1)) == 0);
        /*如果是2的幂，n一定是100... n-1就是1111....
        所以做与运算结果为0
        16=00000000 00000000 00000000 00010000
        15=00000000 00000000 00000000 00001111
        */

        // 4. 计算2的n次方 n>0
        int m = 5;
        System.out.println(2 << (m - 1));

        // 5. 从低位到高位,将n的第m位置为0
        System.out.println(Integer.toBinaryString(n & ~(1 << (m - 1))));
        /* 将1左移 m-1位找到第m位，取反后变成111...0...1111
        n再和这个数做与运算*/

        // 7. 从低位到高位.将n的第m位置为1
        System.out.println(n | (1 << (m - 1)));
        /*将1左移m-1位找到第m位，得到000...1...000
        n在和这个数做或运算*/

        int x = 1;
        int y = 2;
        System.out.println((x + y) >> 1);

        // 13. 不用临时变量交换两个数
        /*
        * x=1=0000 0001
        * y=2=0000 0010
        * x ^= y, x=0000 0011
        * y ^= x, y=0000 0001
        * x ^= y, x=0000 0010
        * */
        x ^= y;
        y ^= x;
        x ^= y;
        System.out.println(y);
    }
}
