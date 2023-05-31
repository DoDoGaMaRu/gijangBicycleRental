package persistence.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serial;
    private String id;
    private String pw;
    private String name;
    private Integer age;
    private String phone;
    private String email;
    private String address;
    private String parentPhone;
}
