package com.lgq.designer.practices.jira_2678.parser;

import com.lgq.designer.practices.jira_2678.MyException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * @author lgq
 */
public class BuyBoxParser {
    public static String parseResForCartBuy(final String resContent) throws MyException {
        Document doc = Jsoup.parse(resContent);

        Element btn_buy_now = doc.getElementById("submit.buy-now-announce");
        Element btn_add_to_ubb_cart = doc.getElementById("submit.add-to-cart-ubb-announce");
        Element btn_add_to_cart = doc.getElementById("submit.add-to-cart-announce");
        Element btn_setup_now = doc.getElementById("rcx-subscribe-submit-button-announce");

        String strRet = null;
        if (btn_buy_now != null) {
            strRet = btn_buy_now.text();
        } else if (btn_add_to_ubb_cart != null) {
            strRet = btn_add_to_ubb_cart.text();
        } else if (btn_add_to_cart != null) {
            strRet = btn_add_to_cart.text();
        } else if (btn_setup_now != null) {
            strRet = btn_setup_now.text();
        }

        return strRet;
    }
}
