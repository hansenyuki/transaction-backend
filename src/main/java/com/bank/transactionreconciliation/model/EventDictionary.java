package com.bank.transactionreconciliation.model;

import jakarta.persistence.*;

@Entity
@Table(name = "event_dictionary")
public class EventDictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String stepCode;
    private Integer stepRank;
    private Integer eventRank;
    private String eventType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStepCode() {
        return stepCode;
    }

    public void setStepCode(String stepCode) {
        this.stepCode = stepCode;
    }

    public Integer getStepRank() {
        return stepRank;
    }

    public void setStepRank(Integer stepRank) {
        this.stepRank = stepRank;
    }

    public Integer getEventRank() {
        return eventRank;
    }

    public void setEventRank(Integer eventRank) {
        this.eventRank = eventRank;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}

