package tv2.demotv2.answer;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tv2.demotv2.question.Question;
import tv2.demotv2.user.SiteUser;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    @ManyToOne
    private Question question;

    @ManyToOne
    private SiteUser author;
}
