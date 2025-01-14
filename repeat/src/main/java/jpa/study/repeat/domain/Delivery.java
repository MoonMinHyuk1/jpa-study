package jpa.study.repeat.domain;

import jakarta.persistence.*;
import jpa.study.repeat.domain.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "delivery")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Delivery extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;
    @OneToOne(mappedBy = "delivery")
    private Order order;
    private String city;
    private String street;
    private String zipcode;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @Builder
    public Delivery(String city, String street, String zipcode, DeliveryStatus status) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.status = status;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
