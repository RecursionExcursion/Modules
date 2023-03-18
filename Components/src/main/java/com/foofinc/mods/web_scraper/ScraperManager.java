package com.foofinc.mods.web_scraper;

public abstract class ScraperManager {

    //TODO Use Record instead?
    public ScraperResult processOrder(ScraperOrder order) {
        String[] results = new WebScraper(order).run();
        ScraperResult result = buildResult(results, order);
        return result;
    }

    protected abstract ScraperResult buildResult(String[] data, ScraperOrder order);
}
