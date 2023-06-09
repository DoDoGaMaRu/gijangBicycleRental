package persistence.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

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
    private LocalDate birthDate;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String parentPhone;

    public void User(String id, String pw, LocalDate birthDate, String name, String phone, String email, String address, String parentPhone) {
        this.id = id;
        this.pw = pw;
        this.birthDate = birthDate;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.parentPhone = parentPhone;
    }

    public void updateUser(String pw, String name, String phone, String email, String address, String parentPhone) {
        this.pw = pw;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.parentPhone = parentPhone;
    }
}
