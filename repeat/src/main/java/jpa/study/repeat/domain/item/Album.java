package jpa.study.repeat.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("A")
public class Album extends Item {

    private String artist;
    private String etc;

    @Builder
    public Album(String name, int price, int stockQuantity, String artist, String etc) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.artist = artist;
        this.etc = etc;
    }
}
