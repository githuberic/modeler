package com.lgq.designer.practices.jira_2678.utils;

import com.google.common.base.Strings;
import com.lgq.designer.practices.jira_2678.MyException;
import com.lgq.designer.practices.jira_2678.stat.StatInfo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lgq
 */
public class LoggingUtil {
    static final String RESULT_FILE = "abuyun_buybox_mt_log.txt";

    public static void logging(String asin, String content, StatInfo statInfo, MyException ex) throws MyException {
        StringBuilder sb = new StringBuilder();

        // 时间s
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatDate = simpleDateFormat.format(new Date());
        sb.append(String.format("Time=%s", formatDate));

        if (!Strings.isNullOrEmpty(asin)) {
            sb.append(String.format(",Asin=%s", asin));
        }

        if (statInfo != null) {
            sb.append(String.format(",Total=%d", statInfo.getTotal()));
            sb.append(String.format(",Success=%d", statInfo.getSuccessCount()));
            sb.append(String.format(",Fail=%d", statInfo.getFailCount()));
        }

        if (ex != null) {
            sb.append(String.format(",error=%s", ex.getMessage()));
        }
        sb.append(String.format(",content=%s", content));
        sb.append("\n");

        FileUtil.write(RESULT_FILE, sb.toString());
    }
}
