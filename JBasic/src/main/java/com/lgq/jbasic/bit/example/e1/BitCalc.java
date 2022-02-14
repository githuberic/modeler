package com.lgq.jbasic.bit.example.e1;

import com.lgq.jbasic.bit.example.Output;
import org.junit.Test;

/**
 * @author lgq
 */
public class BitCalc {
    @Test
    public void testCalc() {
        // 0x01=16进制 = 1*16^0 + 0*16^1
        int x01 = 0x01;

        // 0x02=16进制 = 2*16^0 + 0*16^1
        int x02 = 0x02;

        int y = x01 | x02;
        Output.print(y);

        int y1 = y & x01;
        Output.print(y1);

        int y2 = y & x02;
        Output.print(y2);
    }
}
