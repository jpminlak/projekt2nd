package tv2.demotv2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tv2.demotv2.question.Question;
import tv2.demotv2.question.QuestionRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class QuestionTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void testCreateQuestion() {
        Question q1 = new Question();
        q1.setSubject("제목은 무엇입니까1?");
        q1.setContent("내용은 무엇입니까1?");
        q1.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q1);

        Question q2 = new Question();
        q2.setSubject("제목 질문2");
        q2.setContent("내용 질문2");
        q2.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q2);
    }

    @Test
    void testQuestionFindAll() {
        List<Question> all = this.questionRepository.findAll();
        assertEquals(4, all.size());

        Question q = all.get(1);
        assertEquals("제목 질문2", q.getSubject());
    }

    @Test
    void testQuestionFindById() {
        Optional<Question> oq = this.questionRepository.findById(1);
        if (oq.isPresent()) {
            Question q = oq.get();
            assertEquals("제목은 무엇입니까1?", q.getSubject());
        }
    }

    @Test
    void testQuestionFindBySubject() {
        Question q = this.questionRepository.findBySubject("제목은 무엇입니까1?");
        assertEquals(5, q.getId());
    }

    @Test
    void testQuestionBySubjectAndContent() {
        Question q = this.questionRepository.findBySubjectAndContent
                ("제목은 무엇입니까1?", "내용은 무엇입니까1?");
        assertEquals(5, q.getId());
    }

    @Test
    void testQuestionBySubjectLike(){
        List<Question> qList = this.questionRepository.findBySubjectLike("제목%");
        Question q = qList.get(0);
        assertEquals("제목은 무엇입니까1?", q.getSubject());
    }

    @Test
    void testQuestionModifySubject(){
        Optional<Question> oq = this.questionRepository.findById(5);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        q.setSubject("수정된 제목");
        this.questionRepository.save(q);
    }
}
