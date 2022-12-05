package com.project.dashboard.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "transaction_purpose", schema = "dashboard")
public class TransactionPurpose {


    @Id
    @Column(name = "transaction_purpose_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int transaction_purpose_id;

    @NotNull
    @Column(name = "transaction_purpose_code")
    private String transaction_purpose_code;

    @NotNull
    @Column(name = "transaction_purpose_detail")
    private String transaction_purpose_detail;

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

    public int getTransaction_purpose_id() {
        return transaction_purpose_id;
    }

    public void setTransaction_purpose_id(int transaction_purpose_id) {
        this.transaction_purpose_id = transaction_purpose_id;
    }

    public String getTransaction_purpose_code() {
        return transaction_purpose_code;
    }

    public void setTransaction_purpose_code(String transaction_purpose_code) {
        this.transaction_purpose_code = transaction_purpose_code;
    }

    public String getTransaction_purpose_detail() {
        return transaction_purpose_detail;
    }

    public void setTransaction_purpose_detail(String transaction_purpose_detail) {
        this.transaction_purpose_detail = transaction_purpose_detail;
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

    @Override
    public String toString() {
        return "TransactionPurpose{" +
                "transaction_purpose_id=" + transaction_purpose_id +
                ", transaction_purpose_code='" + transaction_purpose_code + '\'' +
                ", transaction_purpose_detail='" + transaction_purpose_detail + '\'' +
                ", created_by='" + created_by + '\'' +
                ", created_date=" + created_date +
                ", updated_by='" + updated_by + '\'' +
                ", updated_date=" + updated_date +
                '}';
    }
}
