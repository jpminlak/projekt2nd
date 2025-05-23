package tv2.demotv2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tv2.demotv2.question.QuestionService;

@SpringBootTest
public class PagingTest {
    @Autowired
    private QuestionService questionService;

/*    @Test
    void generate300Text(){
        for (int i=1; i<=300; i++){
            String subject = String.format("테스트 데이터입니다:[%03d]", i);
            String content = "내용 없음";
            this.questionService.create(subject, content, null);
        }
    }*/
}
