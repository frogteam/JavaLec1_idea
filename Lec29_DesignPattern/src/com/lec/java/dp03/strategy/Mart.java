package com.lec.java.dp03.strategy;

public class Mart {
    private Seller seller;
    public Mart(Seller seller) {
        this.seller = seller;
    } // end Mart()
    public void order(){
        seller.sell();
    } // end order()
} // end class
