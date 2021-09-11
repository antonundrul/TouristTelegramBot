package by.undrul.touristTelegramBot.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "cities")
public class City implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "city_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public City(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
