package com.lgq.designer.practices.jira_2678.parser;

import com.google.common.base.Strings;
import com.lgq.designer.practices.jira_2678.MyException;
import com.lgq.designer.practices.jira_2678.stat.StatInfo;
import com.lgq.designer.practices.jira_2678.utils.FileUtil;
import com.lgq.designer.practices.jira_2678.utils.LoggingUtil;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * @author lgq
 */
public class AsyncParser implements Runnable {
    private String resContent;
    private String asin;
    private StatInfo statInfo;

    public AsyncParser(String asin, String resContent, StatInfo statInfo) {
        this.resContent = resContent;
        this.asin = asin;
        this.statInfo = statInfo;
    }

    @Override
    public void run() {
        try {
            writeResContent(asin, resContent);

            // 解析请求响应结果
            String resResult = BuyBoxParser.parseResForCartBuy(resContent);
            if (!Strings.isNullOrEmpty(resResult)) {
                statInfo.incrSuccessCount();
            } else {
                statInfo.incrFailCount();
            }

            // 记录日志
            LoggingUtil.logging(asin, resResult, statInfo, null);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
    }


    private void writeResContent(final String asin, final String content) throws MyException {
        String uuid = UUID.randomUUID().toString();
        String file = String.format("./amazon/java/abuyun/%s/%s.html", asin, uuid);

        try {
            Path path = Paths.get(file);
            if (!Files.exists(path)) {
                Files.createDirectories(path.getParent());
            }

            FileUtil.write(file, content);
        } catch (Exception ex) {
            throw new MyException("WriteResContent error");
        }
    }
}
