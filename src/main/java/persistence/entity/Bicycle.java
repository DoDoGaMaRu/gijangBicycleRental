package persistence.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Bicycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String state;
    @OneToOne
    @JoinColumn(name = "station_id")
    private Station station;

    public void updateState(String state) {
        this.state = state;
    }

    public void updateStation(Station station) {
        this.station = station;
    }
}
