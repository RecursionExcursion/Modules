package com.foofinc.mods.selenium.bot_navigation;

import java.util.HashMap;
import java.util.Map;

public class JobFilters {


    public void onsiteRemoteFilter() {


    }

    private Map<String, String> getLocationIDMap() {
        Map<String, String> onSiteRemoteIdMap = new HashMap<>();
        onSiteRemoteIdMap.put("OnSite", "advanced-filter-workplaceType-1");
        onSiteRemoteIdMap.put("Remote", "advanced-filter-workplaceType-2");
        onSiteRemoteIdMap.put("Hybrid", "advanced-filter-workplaceType-3");
        return onSiteRemoteIdMap;
    }

    private Map<String, String> getExperianceIDMap() {
        Map<String, String> experianceIdMap = new HashMap<>();
        experianceIdMap.put("Internship", "advanced-filter-experience-1");
        experianceIdMap.put("Entry Level", "advanced-filter-experience-2");
        experianceIdMap.put("Associate", "advanced-filter-experience-3");
        experianceIdMap.put("Mid-Senior Level", "advanced-filter-experience-4");
        experianceIdMap.put("Director", "advanced-filter-experience-5");
        experianceIdMap.put("Executive", "advanced-filter-experience-6");
        return experianceIdMap;
    }
}
