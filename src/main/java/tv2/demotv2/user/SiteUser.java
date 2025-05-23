package tv2.demotv2.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SiteUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // 회원번호

    @Column(unique = true)
    private String username;    // 사실상 ID
    
    private String password;

    @Column(unique = true)
    private String email;
}
