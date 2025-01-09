package jpa.study.repeat.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;
    @Column(name = "member_id")
    private Long memberId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Builder
    public Order(Long memberId, Date orderDate, OrderStatus status) {
        this.memberId = memberId;
        this.orderDate = orderDate;
        this.status = status;
    }
}
