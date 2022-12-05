package com.project.dashboard.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "vendor", schema = "dashboard")
public class Vendor {

    @Id
    @Column(name = "vendor_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int vendor_id;

    @NotNull
    @Column(name = "vendor_name")
    public String vendor_name;

    @NotNull
    @Column(name = "vendor_account_number")
    public String vendor_account_number;

    @NotNull
    @Column(name = "vendor_account_name")
    public String vendor_account_name;

    @NotNull
    @Column(name = "vendor_account_currency")
    public String vendor_account_currency;

    @NotNull
    @Column(name = "vendor_primary_energy_type")
    public String vendor_primary_energy_type;

    @NotNull
    @Column(name = "vendor_pln_entity")
    public String vendor_pln_entity;
    @NotNull
    @Column(name = "created_by")
    private String created_by;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Jakarta")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "created_date")
    private Date created_date;

    @NotNull
    @Column(name = "updated_by")
    private String updated_by;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Jakarta")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "updated_date")
    private Date updated_date;

    public int getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(int vendor_id) {
        this.vendor_id = vendor_id;
    }

    public String getVendor_name() {
        return vendor_name;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }

    public String getVendor_account_number() {
        return vendor_account_number;
    }

    public void setVendor_account_number(String vendor_account_number) {
        this.vendor_account_number = vendor_account_number;
    }

    public String getVendor_account_name() {
        return vendor_account_name;
    }

    public void setVendor_account_name(String vendor_account_name) {
        this.vendor_account_name = vendor_account_name;
    }

    public String getVendor_account_currency() {
        return vendor_account_currency;
    }

    public void setVendor_account_currency(String vendor_account_currency) {
        this.vendor_account_currency = vendor_account_currency;
    }

    public String getVendor_primary_energy_type() {
        return vendor_primary_energy_type;
    }

    public void setVendor_primary_energy_type(String vendor_primary_energy_type) {
        this.vendor_primary_energy_type = vendor_primary_energy_type;
    }

    public String getVendor_pln_entity() {
        return vendor_pln_entity;
    }

    public void setVendor_pln_entity(String vendor_pln_entity) {
        this.vendor_pln_entity = vendor_pln_entity;
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
        return "Vendor{" +
                "vendor_id=" + vendor_id +
                ", vendor_name='" + vendor_name + '\'' +
                ", vendor_account_number='" + vendor_account_number + '\'' +
                ", vendor_account_name='" + vendor_account_name + '\'' +
                ", vendor_account_currency='" + vendor_account_currency + '\'' +
                ", vendor_primary_energy_type='" + vendor_primary_energy_type + '\'' +
                ", vendor_pln_entity='" + vendor_pln_entity + '\'' +
                ", created_by='" + created_by + '\'' +
                ", created_date=" + created_date +
                ", updated_by='" + updated_by + '\'' +
                ", updated_date=" + updated_date +
                '}';
    }
}
