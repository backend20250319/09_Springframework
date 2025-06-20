package com.ohgiraffers.mapping.section03.compositekey.subsection02.idclass;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_cart")
@IdClass(CartCompositeKey.class)
public class Cart {

    @Id
    @Column(name = "cart_owner")
    private int cartOwner;

    @Id
    @Column(name = "added_book")
    private int addedBook;

    @Column(name = "quantity")
    private int quantity;

    public Cart() {
    }

    public Cart(int quantity, int addedBook, int cartOwner) {
        this.quantity = quantity;
        this.addedBook = addedBook;
        this.cartOwner = cartOwner;
    }

    // 조회용으로 getter만 추가
    public int getCartOwner() {
        return cartOwner;
    }

    public int getAddedBook() {
        return addedBook;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartOwner=" + cartOwner +
                ", addedBook=" + addedBook +
                ", quantity=" + quantity +
                '}';
    }
}
