package com.lgq.jbasic.bk.bigdecimal;

import java.math.BigDecimal;

/**
 * Created by eric on 2019/11/7.
 *
 * @author lgq
 */
public class BigDecimalV1 {
    public static void main(String[] args) {
        verifyV2();
        verifyV3();
    }

    private static void basic() {
        BigDecimal decimal = new BigDecimal("1.12345");
        System.out.println(decimal);

        BigDecimal setScale = decimal.setScale(4, BigDecimal.ROUND_HALF_DOWN);
        System.out.println(setScale);

        BigDecimal setScale1 = decimal.setScale(4, BigDecimal.ROUND_HALF_UP);
        System.out.println(setScale1);

        System.out.println(new BigDecimal(0.99));
        System.out.println(new BigDecimal("0.99"));
        System.out.println(BigDecimal.valueOf(0.99));
        System.out.println(new BigDecimal(Double.valueOf(0.99)));
        System.out.println(new BigDecimal(Double.valueOf(0.99).toString()));

    }

    private static void verifyV1() {
        //买家手续费
        BigDecimal buyerFee = new BigDecimal(1.1100);
        buyerFee = buyerFee.setScale(2, BigDecimal.ROUND_UP);

        BigDecimal buyPrice = new BigDecimal(111.0000);

        BigDecimal pay = buyerFee.add(buyPrice).setScale(2, BigDecimal.ROUND_UP);

        System.out.println(pay);
    }

    private static void verifyV2(){
        BigDecimal sellerFee = new BigDecimal(0.1900);
        BigDecimal buyPrice = new BigDecimal(9.0800);
        buyPrice = buyPrice.setScale(2,BigDecimal.ROUND_UP);
        System.out.println(buyPrice);
        BigDecimal sellerPrice = new BigDecimal(8.9000);

        BigDecimal buyPriceV1 = sellerFee.add(sellerPrice);
        buyPriceV1 = buyPriceV1.setScale(2,BigDecimal.ROUND_UP);
        System.out.println(buyPriceV1);
    }

    private static void verifyV3(){
        BigDecimal sellerFee = new BigDecimal(0.1900);
        BigDecimal buyPrice = new BigDecimal(9.0800);
        buyPrice = buyPrice.setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(buyPrice);
        BigDecimal sellerPrice = new BigDecimal(8.9000);

        BigDecimal buyPriceV1 = sellerFee.add(sellerPrice);
        buyPriceV1 = buyPriceV1.setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(buyPriceV1);
    }
}
