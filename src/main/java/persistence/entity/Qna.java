package persistence.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Qna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String info;
    @OneToOne
    @JoinColumn(name = "question_id")
    private Qna qna;
    @ManyToOne
    @JoinColumn(name = "user_serial")
    private User user;
}
