package com.ohgiraffers.mapping.section03.compositekey.subsection02.idclass;

import jakarta.persistence.*;

public class CartDTO {

    private int cartOwnerMemberNo;

    private int addedBookNo;

    private int quantity;

    public CartDTO(int quantity, int addedBookNo, int cartOwnerMemberNo) {
        this.quantity = quantity;
        this.addedBookNo = addedBookNo;
        this.cartOwnerMemberNo = cartOwnerMemberNo;
    }

    public int getCartOwnerMemberNo() {
        return cartOwnerMemberNo;
    }

    public int getAddedBookNo() {
        return addedBookNo;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "CartDTO{" +
                "cartOwnerMemberNo=" + cartOwnerMemberNo +
                ", addedBookNo=" + addedBookNo +
                ", quantity=" + quantity +
                '}';
    }
}
