package com.lec.java.dp01.adapter;

public class ToyAdapter implements NewtypeToy {
    OldtypeToy oldtype;
    // 구모델을 생성자를 통해 받음
    public ToyAdapter(OldtypeToy oldtype) {
        this.oldtype = oldtype;
    }
     
    @Override
    public void use() {
        oldtype.use();
    } // end use()
 
    // 구모델 충전 타입을 USB로 전환 후 충전 함.
    @Override
    public void onUSBCharge() {
        System.out.println(oldtype.getName() + ": change USB MODE !!");
        oldtype.onPlug();
    } // end onUSBCharge()
 
    @Override
    public String getName() {
        return oldtype.getName();
    } // end getName()
}  // end class
