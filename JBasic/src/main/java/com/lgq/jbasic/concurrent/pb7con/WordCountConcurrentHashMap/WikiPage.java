package com.lgq.jbasic.concurrent.pb7con.WordCountConcurrentHashMap;

/**
 * @author lgq
 */
public class WikiPage extends Page {
    private String title;
    private String text;

    public WikiPage(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getText() {
        return text;
    }
}
