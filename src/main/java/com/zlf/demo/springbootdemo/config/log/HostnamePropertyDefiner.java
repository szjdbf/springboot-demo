package com.zlf.demo.springbootdemo.config.log;

import ch.qos.logback.core.PropertyDefinerBase;
import ch.qos.logback.core.util.ContextUtil;

import java.net.SocketException;
import java.net.UnknownHostException;

public class HostnamePropertyDefiner extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {
        try {
            return ContextUtil.getLocalHostName();
        } catch (UnknownHostException | SocketException e) {
            return "localhost";
        }
    }

}