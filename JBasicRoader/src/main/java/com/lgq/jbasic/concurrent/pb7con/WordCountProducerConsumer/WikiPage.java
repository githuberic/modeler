package com.lgq.jbasic.concurrent.pb7con.WordCountProducerConsumer;

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

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
