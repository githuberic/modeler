package com.lgq.jbasic.concurrent.pb7con.HttpDownloadFixed;

import java.net.URL;

/**
 * @author lgq
 */
public class HttpDownload {
    public static void main(String[] args) throws Exception {
        URL from = new URL("http://download.wikimedia.org/enwiki/latest/enwiki-latest-pages-articles.xml.bz2");
        Downloader downloader = new Downloader(from, "download.out");
        downloader.start();
        downloader.addListener(new ProgressListener() {
            public void onProgress(int n) { System.out.print("\r"+n); System.out.flush(); }
            public void onComplete(boolean success) {}
        });
        downloader.join();
    }
}
