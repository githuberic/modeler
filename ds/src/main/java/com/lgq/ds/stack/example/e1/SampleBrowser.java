package com.lgq.ds.stack.example.e1;

import com.google.common.base.Strings;
import com.lgq.ds.stack.LinkedListBasedStack;

/**
 * @author lgq
 */
public class SampleBrowser {
    private String currentPage;
    private LinkedListBasedStack<String> backStack;
    private LinkedListBasedStack<String> forwardStack;

    public SampleBrowser() {
        this.backStack = new LinkedListBasedStack();
        this.forwardStack = new LinkedListBasedStack();
    }

    public void open(String url) {
        if (!Strings.isNullOrEmpty(this.currentPage)) {
            this.backStack.push(this.currentPage);
            this.forwardStack.clear();
        }
        showUrl(url, "Open");
    }

    public String goBack() {
        if (this.canGoBack()) {
            this.forwardStack.push(this.currentPage);
            String backUrl = this.backStack.pop();
            showUrl(backUrl, "Back");
            return backUrl;
        }
        System.out.println(">>>Cannot go back, no pages behind.");
        return null;
    }

    public String goForward() {
        if (this.canGoForward()) {
            this.backStack.push(this.currentPage);
            String forwardUrl = this.forwardStack.pop();
            showUrl(forwardUrl, "Forward");
            return forwardUrl;
        }
        System.out.println(">>>Cannot go forward, no pages ahead.");
        return null;
    }

    public boolean canGoBack() {
        return this.backStack.getSize() > 0;
    }

    public boolean canGoForward() {
        return this.forwardStack.getSize() > 0;
    }

    public void showUrl(String url, String prefix) {
        this.currentPage = url;
        System.out.println(prefix + " page == " + url);
    }

    public void checkCurrentPage() {
        System.out.println("Current page is: " + this.currentPage);
    }
}
