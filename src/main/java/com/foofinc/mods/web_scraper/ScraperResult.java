package com.foofinc.mods.web_scraper;

public abstract class ScraperResult {

    protected String url;
    public ScraperResult(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }
}
