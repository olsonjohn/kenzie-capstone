package com.kenzie.appserver.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.List;

public class UserScheduleUpdateRequest {
    @JsonProperty("scheduleId")
    private String scheduleId;
    @JsonProperty("start")
    private ZonedDateTime start;
    @JsonProperty("end")
    private ZonedDateTime end;
    @JsonProperty("scheduledEventIds")
    private List<String> scheduledEventIds;
    @JsonProperty("userId")
    private String userId;

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public ZonedDateTime getStart() {
        return start;
    }

    public void setStart(ZonedDateTime start) {
        this.start = start;
    }

    public ZonedDateTime getEnd() {
        return end;
    }

    public void setEnd(ZonedDateTime end) {
        this.end = end;
    }
    public List<String> getScheduledEventIds() {
        return scheduledEventIds;
    }

    public void setScheduledEventIds(List<String> scheduledEventIds) {
        this.scheduledEventIds = scheduledEventIds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
