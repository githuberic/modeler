package com.lgq.jbasic.concurrent.pb7con.WordCount;

import java.util.HashMap;

/**
 * @author lgq
 */
public class WordCount {
    private static final HashMap<String, Integer> counts = new HashMap<String, Integer>();

    private static void countWord(String word) {
        Integer currentCount = counts.get(word);
        if (currentCount == null) {
            counts.put(word, 1);
        } else {
            counts.put(word, currentCount + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        Iterable<Page> pages = new Pages(100000, "enwiki.xml");
        for (Page page : pages) {
            Iterable<String> words = new Words(page.getText());
            for (String word : words) {
                countWord(word);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (end - start) + "ms");

        // for (Map.Entry<String, Integer> e: counts.entrySet()) {
        //   System.out.println(e);
        // }
    }
}
