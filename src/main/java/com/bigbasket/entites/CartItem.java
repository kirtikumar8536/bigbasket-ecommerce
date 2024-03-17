package com.bigbasket.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cart_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;
    @Column(name = "product_price")
    private Double productPrice;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "discount")
    private Double discount;

    @ManyToOne
    @JoinColumn(name="cart_id",//name of column in table
    nullable = false,
    referencedColumnName = "cartId",//id comes from cart's cartId
    foreignKey = @ForeignKey(name = "cart_cartitem_fk"))
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false,
    referencedColumnName = "product_id", // name of column of table product(not entity field name)
    foreignKey = @ForeignKey(name = "product_cartitem_fk"))
    private Product product;
}
