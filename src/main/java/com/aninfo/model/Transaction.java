package com.aninfo.model;



public class Transaction {
    private Long cbu;
    private String type;
    private Double amount;


    public Transaction(Long cbu, String type, Double amount){
        this.cbu = cbu;
        this.type = type;
        this.amount = amount;
    }
    public Double readTransaction(){
        return amount;
    };
}
