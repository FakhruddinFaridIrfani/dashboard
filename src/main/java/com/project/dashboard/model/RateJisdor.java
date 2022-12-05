package com.project.dashboard.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "rate_jisdor", schema = "dashboard")
public class RateJisdor {

    @Id
    @Column(name = "rate_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int rate_id;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Jakarta")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "rate_date")
    private Date rate_date;

    @NotNull
    @Column(name = "rate_value")
    private BigDecimal rate_value;

    @NotNull
    @Column(name = "rate_currency")
    private String rate_currency;

    @NotNull
    @Column(name = "created_by")
    private String created_by;


    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Jakarta")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Column(name = "created_date")
    private Date created_date;


    @Column(name = "updated_by")
    private String updated_by;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Jakarta")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Column(name = "updated_date")
    private Date updated_date;

    public int getRate_id() {
        return rate_id;
    }

    public void setRate_id(int rate_id) {
        this.rate_id = rate_id;
    }

    public Date getRate_date() {
        return rate_date;
    }

    public void setRate_date(Date rate_date) {
        this.rate_date = rate_date;
    }

    public BigDecimal getRate_value() {
        return rate_value;
    }

    public void setRate_value(BigDecimal rate_value) {
        this.rate_value = rate_value;
    }

    public String getRate_currency() {
        return rate_currency;
    }

    public void setRate_currency(String rate_currency) {
        this.rate_currency = rate_currency;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }
}
