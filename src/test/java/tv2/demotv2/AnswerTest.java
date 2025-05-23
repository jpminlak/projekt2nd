package tv2.demotv2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import tv2.demotv2.answer.Answer;
import tv2.demotv2.answer.AnswerRepository;
import tv2.demotv2.question.Question;
import tv2.demotv2.question.QuestionRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@SpringBootTest
public class AnswerTest {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @Test
    void testCreateAnswer(){
        Optional<Question> oq = this.questionRepository.findById(2);
        System.out.println("oq = " + oq);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        Answer a = new Answer();
        a.setContent("답변 내용1");
        a.setQuestion(q);
        a.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(a);
    }

    @Test
    void testAnswerFindById(){
        Optional<Answer> oa = this.answerRepository.findById(1);
        assertTrue(oa.isPresent());
        Answer a = oa.get();
        assertEquals(2, a.getQuestion().getId());
    }

    // 클래스에 @Transactional 코드를 쓰지 않으면 테스트 코드에서만 오류가 발생한다.
    // 이는 q.getAnswerList() 이후 세션이 종료되어 발생하는 오류이나, 실제 실행 때는 DB 세션이 종료되지 않아 발생하지 않음.
    @Test
    void testAnswerFromQuestion(){
        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        List<Answer> answerList = q.getAnswerList();
        assertEquals(1, answerList.size());
        assertEquals("답변 내용1", answerList.get(0).getContent());
    }
}
