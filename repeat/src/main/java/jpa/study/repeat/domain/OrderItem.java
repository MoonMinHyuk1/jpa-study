package jpa.study.repeat.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "order_item")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;
    @Column(name = "item_id")
    private Long itemId;
    @Column(name = "order_id")
    private Long orderId;
    private int orderPrice;
    private int count;

    public OrderItem(Long itemId, Long orderId, int orderPrice, int count) {
        this.itemId = itemId;
        this.orderId = orderId;
        this.orderPrice = orderPrice;
        this.count = count;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", buyPrice=" + orderPrice +
                ", count=" + count +
                '}';
    }
}
