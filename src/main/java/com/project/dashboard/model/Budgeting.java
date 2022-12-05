package com.project.dashboard.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "budgeting_transaction", schema = "dashboard")
public class Budgeting {

    @Id
    @Column(name = "budgeting_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int budgeting_id;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Jakarta")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "billing_date")
    private Date billing_date;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Jakarta")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "payment_plan_date")
    private Date payment_plan_date;

    @NotNull
    @Column(name = "contract_number")
    private String contract_number;

    @NotNull
    @Column(name = "invoice_number")
    private String invoice_number;

    @NotNull
    @Column(name = "amount")
    private BigDecimal amount;

    @NotNull
    @Column(name = "currency")
    private String currency;

    @NotNull
    @Column(name = "primary_energy_type")
    private String primary_energy_type;

    @NotNull
    @Column(name = "payment_destination_entity")
    private String payment_destination_entity;

    @NotNull
    @Column(name = "pln_entity")
    private String pln_entity;

    @NotNull
    @Column(name = "budgeting_status")
    private String budgeting_status;

    @NotNull
    @Column(name = "data_status")
    private String data_status;

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

    @NotNull
    @Column(name = "from_account")
    private String from_account;

    @NotNull
    @Column(name = "beneficiary_account_type")
    private String beneficiary_account_type;

    @NotNull
    @Column(name = "beneficiary_account_to")
    private String beneficiary_account_to;

    @NotNull
    @Column(name = "beneficiary_instruction_mode_type")
    private String beneficiary_instruction_mode_type;

    @NotNull
    @Column(name = "beneficiary_notifications_flag")
    private String beneficiary_notifications_flag;

    @NotNull
    @Column(name = "beneficiary_notifications_email")
    private String beneficiary_notifications_email;

    @Column(name = "beneficiary_file")
    private String beneficiary_file;

    @Column(name = "remark")
    private String remark;

    @Column(name = "remitter_reference_number")
    private String remitter_reference_number;

    @Column(name = "beneficiary_reference_number")
    private String beneficiary_reference_number;

    @NotNull
    @Column(name = "budgeting_transfer_type")
    private String budgeting_transfer_type; //[Inhouse,Domestic,International]

//    INHOUSE DATA

    @NotNull
    @Column(name = "inhouse_transaction_type")
    private String inhouse_transaction_type; // [SINGLE CURRENCY /MULTIPLE]

    @NotNull
    @Column(name = "transaction_purpose")
    private String transaction_purpose;

// #DOMESTIC

    @NotNull
    @Column(name = "exchange_rate")
    private String exchange_rate;

    @NotNull
    @Column(name = "exchange_rate_value")
    private BigDecimal exchange_rate_value;


    @NotNull
    @Column(name = "services")
    private String services;

    @NotNull
    @Column(name = "charge_to")
    private String charge_to;

    public int getBudgeting_id() {
        return budgeting_id;
    }

    public void setBudgeting_id(int budgeting_id) {
        this.budgeting_id = budgeting_id;
    }

    public Date getBilling_date() {
        return billing_date;
    }

    public void setBilling_date(Date billing_date) {
        this.billing_date = billing_date;
    }

    public Date getPayment_plan_date() {
        return payment_plan_date;
    }

    public void setPayment_plan_date(Date payment_plan_date) {
        this.payment_plan_date = payment_plan_date;
    }

    public String getContract_number() {
        return contract_number;
    }

    public void setContract_number(String contract_number) {
        this.contract_number = contract_number;
    }

    public String getInvoice_number() {
        return invoice_number;
    }

    public void setInvoice_number(String invoice_number) {
        this.invoice_number = invoice_number;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPrimary_energy_type() {
        return primary_energy_type;
    }

    public void setPrimary_energy_type(String primary_energy_type) {
        this.primary_energy_type = primary_energy_type;
    }

    public String getPayment_destination_entity() {
        return payment_destination_entity;
    }

    public void setPayment_destination_entity(String payment_destination_entity) {
        this.payment_destination_entity = payment_destination_entity;
    }

    public String getPln_entity() {
        return pln_entity;
    }

    public void setPln_entity(String pln_entity) {
        this.pln_entity = pln_entity;
    }

    public String getBudgeting_status() {
        return budgeting_status;
    }

    public void setBudgeting_status(String budgeting_status) {
        this.budgeting_status = budgeting_status;
    }

    public String getData_status() {
        return data_status;
    }

    public void setData_status(String data_status) {
        this.data_status = data_status;
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

    public String getFrom_account() {
        return from_account;
    }

    public void setFrom_account(String from_account) {
        this.from_account = from_account;
    }

    public String getBeneficiary_account_type() {
        return beneficiary_account_type;
    }

    public void setBeneficiary_account_type(String beneficiary_account_type) {
        this.beneficiary_account_type = beneficiary_account_type;
    }

    public String getBeneficiary_account_to() {
        return beneficiary_account_to;
    }

    public void setBeneficiary_account_to(String beneficiary_account_to) {
        this.beneficiary_account_to = beneficiary_account_to;
    }

    public String getBeneficiary_instruction_mode_type() {
        return beneficiary_instruction_mode_type;
    }

    public void setBeneficiary_instruction_mode_type(String beneficiary_instruction_mode_type) {
        this.beneficiary_instruction_mode_type = beneficiary_instruction_mode_type;
    }

    public String getBeneficiary_notifications_flag() {
        return beneficiary_notifications_flag;
    }

    public void setBeneficiary_notifications_flag(String beneficiary_notifications_flag) {
        this.beneficiary_notifications_flag = beneficiary_notifications_flag;
    }

    public String getBeneficiary_notifications_email() {
        return beneficiary_notifications_email;
    }

    public void setBeneficiary_notifications_email(String beneficiary_notifications_email) {
        this.beneficiary_notifications_email = beneficiary_notifications_email;
    }

    public String getBeneficiary_file() {
        return beneficiary_file;
    }

    public void setBeneficiary_file(String beneficiary_file) {
        this.beneficiary_file = beneficiary_file;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemitter_reference_number() {
        return remitter_reference_number;
    }

    public void setRemitter_reference_number(String remitter_reference_number) {
        this.remitter_reference_number = remitter_reference_number;
    }

    public String getBeneficiary_reference_number() {
        return beneficiary_reference_number;
    }

    public void setBeneficiary_reference_number(String beneficiary_reference_number) {
        this.beneficiary_reference_number = beneficiary_reference_number;
    }

    public String getBudgeting_transfer_type() {
        return budgeting_transfer_type;
    }

    public void setBudgeting_transfer_type(String budgeting_transfer_type) {
        this.budgeting_transfer_type = budgeting_transfer_type;
    }

    public String getInhouse_transaction_type() {
        return inhouse_transaction_type;
    }

    public void setInhouse_transaction_type(String inhouse_transaction_type) {
        this.inhouse_transaction_type = inhouse_transaction_type;
    }

    public String getTransaction_purpose() {
        return transaction_purpose;
    }

    public void setTransaction_purpose(String transaction_purpose) {
        this.transaction_purpose = transaction_purpose;
    }

    public String getExchange_rate() {
        return exchange_rate;
    }

    public void setExchange_rate(String exchange_rate) {
        this.exchange_rate = exchange_rate;
    }

    public BigDecimal getExchange_rate_value() {
        return exchange_rate_value;
    }

    public void setExchange_rate_value(BigDecimal exchange_rate_value) {
        this.exchange_rate_value = exchange_rate_value;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getCharge_to() {
        return charge_to;
    }

    public void setCharge_to(String charge_to) {
        this.charge_to = charge_to;
    }

    @Override
    public String toString() {
        return "budgeting{" +
                "budgeting_id=" + budgeting_id +
                ", billing_date=" + billing_date +
                ", payment_plan_date=" + payment_plan_date +
                ", contract_number=" + contract_number +
                ", invoice_number=" + invoice_number +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", primary_energy_type='" + primary_energy_type + '\'' +
                ", payment_destination_entity='" + payment_destination_entity + '\'' +
                ", pln_entity='" + pln_entity + '\'' +
                ", budgeting_status='" + budgeting_status + '\'' +
                ", data_status='" + data_status + '\'' +
                ", created_by='" + created_by + '\'' +
                ", created_date=" + created_date +
                ", updated_by='" + updated_by + '\'' +
                ", updated_date=" + updated_date +
                ", from_account=" + from_account +
                ", beneficiary_account_type='" + beneficiary_account_type + '\'' +
                ", beneficiary_account_to=" + beneficiary_account_to +
                ", beneficiary_instruction_mode_type='" + beneficiary_instruction_mode_type + '\'' +
                ", beneficiary_notifications_flag='" + beneficiary_notifications_flag + '\'' +
                ", beneficiary_notifications_email='" + beneficiary_notifications_email + '\'' +
                ", beneficiary_file='" + beneficiary_file + '\'' +
                ", remark='" + remark + '\'' +
                ", remitter_reference_number='" + remitter_reference_number + '\'' +
                ", beneficiary_reference_number='" + beneficiary_reference_number + '\'' +
                ", budgeting_transfer_type='" + budgeting_transfer_type + '\'' +
                ", inhouse_transaction_type='" + inhouse_transaction_type + '\'' +
                ", transaction_purpose='" + transaction_purpose + '\'' +
                ", exchange_rate='" + exchange_rate + '\'' +
                ", exchange_rate_value=" + exchange_rate_value +
                ", services='" + services + '\'' +
                ", charge_to='" + charge_to + '\'' +
                '}';
    }
}
