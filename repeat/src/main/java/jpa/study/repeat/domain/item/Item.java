package jpa.study.repeat.domain.item;

import jakarta.persistence.*;
import jpa.study.repeat.domain.Category;
import jpa.study.repeat.domain.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "item")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Item extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    protected Long id;
    protected String name;
    protected int price;
    protected int stockQuantity;
    @ManyToMany(mappedBy = "items")
    protected List<Category> categories = new ArrayList<Category>();

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
