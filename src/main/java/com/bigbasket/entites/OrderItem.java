package com.bigbasket.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "order_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long orderItemId;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "ordered_product_price")
    private Double orderedProductPrice;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "oder_id",
                nullable = false,
    referencedColumnName = "order_id",
    foreignKey = @ForeignKey(name = "order_orderitem_fk"))
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id",
                referencedColumnName = "product_id",
                foreignKey = @ForeignKey(name = "product_orderitems_fk"))
    private Product product;

}
