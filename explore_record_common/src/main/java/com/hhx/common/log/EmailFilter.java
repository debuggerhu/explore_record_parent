package com.hhx.common.log;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * @Author su Lichen
 * @Date 2020/3/25 9:00
 */
public class EmailFilter extends Filter<ILoggingEvent> {
    @Override
    public FilterReply decide(ILoggingEvent event) {
        if (event.getLoggerName().contains("com.hhx.pacs")) {
            return FilterReply.DENY;
        }

        return FilterReply.ACCEPT;
    }
}
