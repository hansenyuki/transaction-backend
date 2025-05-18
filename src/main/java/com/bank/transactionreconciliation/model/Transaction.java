package com.bank.transactionreconciliation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "transactions")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "primary_id")
    @JsonProperty("primary_id")
    private String primaryId;

    @Column(name = "secondary_id")
    @JsonProperty("secondary_id")
    private String secondaryId;

    @Column(name = "event_type")
    private String eventType;

    @Transient
    private Map<String, String> event;

    @Column(name = "event_date")
    private LocalDateTime eventDate;

    @Transient
    @JsonProperty("date")
    private String rawDate;

    @Column(name = "valid_date")
    private Boolean validDate;

    @Column(name = "event_rank")
    private Integer eventRank;

    @Column(name = "step_rank")
    private Integer stepRank;

    @JsonProperty("event")
    public void unpackEvent(Map<String, String> event) {
        this.event = event;
        this.eventType = event.get("eventType");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimaryId() {
        return primaryId;
    }

    public void setPrimaryId(String primaryId) {
        this.primaryId = primaryId;
    }

    public String getSecondaryId() {
        return secondaryId;
    }

    public void setSecondaryId(String secondaryId) {
        this.secondaryId = secondaryId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Map<String, String> getEvent() {
        return event;
    }

    public void setEvent(Map<String, String> event) {
        this.event = event;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public String getRawDate() {
        return rawDate;
    }

    public void setRawDate(String rawDate) {
        this.rawDate = rawDate;
    }

    public Boolean getValidDate() {
        return validDate;
    }

    public void setValidDate(Boolean validDate) {
        this.validDate = validDate;
    }

    public Integer getEventRank() {
        return eventRank;
    }

    public void setEventRank(Integer eventRank) {
        this.eventRank = eventRank;
    }

    public Integer getStepRank() {
        return stepRank;
    }

    public void setStepRank(Integer stepRank) {
        this.stepRank = stepRank;
    }
}
