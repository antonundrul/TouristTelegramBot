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
    private Long id;

    private String name;
    private String description;

    public City(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
