package com.zlf.demo.springbootdemo.config.log;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.contrib.json.classic.JsonLayout;

import java.util.Map;

public class BLJsonLayout extends JsonLayout {

    protected void addCustomDataToJsonMap(Map<String, Object> map, ILoggingEvent event) {
        add("msg", this.includeFormattedMessage, event.getFormattedMessage(), map);
        add("AppName", true, "blgroup-osp-social-api", map); //app
        map.remove("message");
    }

}