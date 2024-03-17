package com.bigbasket.entites;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "product")
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "discount")
    private Double discount;
    @Column(name = "price", nullable = false)
    private Double price;

    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id",
            nullable = false,
            referencedColumnName = "category_id",
            foreignKey = @ForeignKey(name = "categories_product_fk"))
    private Categories categories;

    @OneToMany(mappedBy = "product",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.EAGER)
    private List<CartItem> products = new ArrayList<>();

    @OneToMany(mappedBy = "product",
            cascade = {CascadeType.PERSIST,
                    CascadeType.MERGE})
//           ,fetch = FetchType.EAGER)
    private List<OrderItem> orderItems = new ArrayList<>();
}
// in owning entity mappedBy =name of the field in that entity
/* in refrencedColumnName=name of column in that table (categories)
[org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]:
Invocation of init method failed; nested exception is org.hibernate.MappingException:
Unable to find column with logical name: productId in org.hibernate.mapping.Table(product)
and its related supertables and secondary tables*/

//simultaneously fetch multiple bags:[com.bigbasket.entites.Product.products, com.bigbasket.entites.Product.orderItems]