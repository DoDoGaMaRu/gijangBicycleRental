package persistence.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double distance;
    @ManyToOne
    @JoinColumn(name = "bicycle_id")
    private Bicycle bicycle;
    @ManyToOne
    @JoinColumn(name = "user_serial")
    private User user;

    public void updateRental(LocalDateTime endTime, Double distance) {
        this.endTime = endTime;
        this.distance = distance;
    }
}
