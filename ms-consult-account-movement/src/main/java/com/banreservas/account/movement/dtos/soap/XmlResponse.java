package com.banreservas.account.movement.dtos.soap;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.time.LocalDateTime;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlResponse", propOrder = {"NroTran", "Fecha", "FechaReal", "monto", "TipoMovimiento", "Concepto","Oficina", "TellerBranch", "TellerNumber", "DescOfi", "Saldo", "Ref", "Desc1", "Desc2", "Desc3", "Causal", "CodTran", "Estado", "IdPaginacion", "IdUnico", "Cantidad", "IdSalida"})
@RegisterForReflection
public class XmlResponse {

    @XmlElement(name = "NroTran")
    private Integer transactionNumber;

    @XmlElement(name = "Fecha")
    private LocalDateTime date;

    @XmlElement(name = "FechaReal")
    private LocalDateTime actualDate;

    @XmlElement(name = "Monto")
    private double amount;

    @XmlElement(name = "TipoMovimiento")
    private String movementType;

    @XmlElement(name = "Concepto")
    private String concept;

    @XmlElement(name = "Oficina")
    private String office;

    @XmlElement(name = "TellerBranch")
    private Integer tellerBranch;

    @XmlElement(name = "TellerNumber")
    private Integer tellerNumber;

    @XmlElement(name = "DescOfi")
    private String descriptionOficce;

    @XmlElement(name = "Saldo")
    private double balance;

    @XmlElement(name = "Ref")
    private double reference;

    @XmlElement(name = "Desc1")
    private String description1;

    @XmlElement(name = "Desc2")
    private String description2;

    @XmlElement(name = "Desc3")
    private String description3;

    @XmlElement(name = "Causal")
    private String causal;

    @XmlElement(name = "CodTran")
    private Integer transactionCode;

    @XmlElement(name = "Estado")
    private String state;

    @XmlElement(name = "IdPaginacion")
    private Integer idPage;

    @XmlElement(name = "IdUnico")
    private Integer idUnico;

    @XmlElement(name = "Cantidad")
    private Integer quantity;

    @XmlElement(name = "IdSalida")
    private Integer idExit;

    public XmlResponse(){

    }

    //Getters y Setters
    public Integer getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(Integer transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getActualDate() {
        return actualDate;
    }

    public void setActualDate(LocalDateTime actualDate) {
        this.actualDate = actualDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMovementType() {
        return movementType;
    }

    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public Integer getTellerBranch() {
        return tellerBranch;
    }

    public void setTellerBranch(Integer tellerBranch) {
        this.tellerBranch = tellerBranch;
    }

    public Integer getTellerNumber() {
        return tellerNumber;
    }

    public void setTellerNumber(Integer tellerNumber) {
        this.tellerNumber = tellerNumber;
    }

    public String getDescriptionOficce() {
        return descriptionOficce;
    }

    public void setDescriptionOficce(String descriptionOficce) {
        this.descriptionOficce = descriptionOficce;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getReference() {
        return reference;
    }

    public void setReference(double reference) {
        this.reference = reference;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getDescription3() {
        return description3;
    }

    public void setDescription3(String description3) {
        this.description3 = description3;
    }

    public String getCausal() {
        return causal;
    }

    public void setCausal(String causal) {
        this.causal = causal;
    }

    public Integer getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(Integer transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getIdPage() {
        return idPage;
    }

    public void setIdPage(Integer idPage) {
        this.idPage = idPage;
    }

    public Integer getIdUnico() {
        return idUnico;
    }

    public void setIdUnico(Integer idUnico) {
        this.idUnico = idUnico;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getIdExit() {
        return idExit;
    }

    public void setIdExit(Integer idExit) {
        this.idExit = idExit;
    }
}
