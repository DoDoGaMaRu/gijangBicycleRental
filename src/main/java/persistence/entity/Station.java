package persistence.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String coordinate;
    private String address;

    public void updateStation(String name, String coordinate, String address) {
        this.name = name;
        this.coordinate = coordinate;
        this.address = address;
    }
}
