package persistence.entity;

import lombok.*;
import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime regdate;
    private Integer amount;
    private String paymentMethod;
    private String state;
    @ManyToOne
    @JoinColumn(name = "user_serial")
    private User user;
    @OneToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

    public void updateState(String state) {
        this.state = state;
    }
}
