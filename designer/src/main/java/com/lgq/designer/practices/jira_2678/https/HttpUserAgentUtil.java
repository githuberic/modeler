package com.lgq.designer.practices.jira_2678.https;

import com.lgq.designer.practices.jira_2678.MyException;
import com.lgq.designer.practices.jira_2678.utils.FileUtil;

import java.util.List;

/**
 * @author lgq
 */
public class HttpUserAgentUtil {

    public static List<String> readFromFile(String filePath) throws MyException {
        return FileUtil.readFileByLines(filePath);
    }
}
