package com.lgq.ds.extension.trietree.practice.ansj;

import love.cq.domain.Forest;
import love.cq.library.Library;
import love.cq.splitWord.GetWord;

import java.io.BufferedReader;
import java.io.StringReader;

/**
 * @author lgq
 */
public class AnsjTest {
    public static void main(String[] args) throws Exception {
        /**
         * 词典的构造.一行一个词后面是参数.可以从文件读取.可以是read流.
         */
        String dic =
                "中国\t1\tzg\n" +
                        "人名\t2\n" +
                        "中国人民\t4\n" +
                        "人民\t3\n" +
                        "孙健\t5\n" +
                        "CSDN\t6\n" +
                        "java\t7\n" +
                        "java学习\t10\n";
        Forest forest = Library.makeForest(new BufferedReader(new StringReader(dic)));

        /**
         * 删除一个单词
         */
        Library.removeWord(forest, "中国");
        /**
         * 增加一个新词
         */
        Library.insertWord(forest, "中国人");
        String content = "中国人名识别是中国人民的一个骄傲.孙健人民在CSDN中学到了很多最早iteye是java学习笔记叫javaeye但是java123只是一部分";
        GetWord udg = forest.getWord(content);

        String temp = null;
        while ((temp = udg.getFrontWords()) != null)
            System.out.println(temp + "\t\t" + udg.getParam(1) + "\t\t" + udg.getParam(2));
    }
}
