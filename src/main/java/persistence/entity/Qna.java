package persistence.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Qna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime regdate;
    private String title;
    private String info;
    @OneToOne
    @JoinColumn(name = "question_id")
    private Qna qna;
    @ManyToOne
    @JoinColumn(name = "user_serial")
    private User user;

    public void updatePost(String title, String info) {
        this.title = title;
        this.info = info;
    }
}
