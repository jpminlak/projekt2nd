package tv1.demotv1.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import tv1.demotv1.domain.Member;
import tv1.demotv1.entity.Question;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
    private MemoryMemberRepositoryTest questionRepository;

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        //given
        Member member = new Member();
        member.setName("spring");
        //when
        repository.save(member);
        //then
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
//        Question q1 = new Question();
//        q1.setSubject("테스트를 왜 하나요");
//        q1.setContent("테스트를 진행하는 이유에 대해서 궁금합니다.");
//        q1.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q1);
//
//        Question q2 = new Question();
//        q2.setSubject("Jpa에 관하여");
//        q2.setContent("Jpa는 무엇이며, 사용하는 이유는 무엇인가요?");
//        q2.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q2);
    }
    @Test
    public void findByName() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
        //when
        Member result = repository.findByName("spring1").get();
        //then
        assertThat(result).isEqualTo(member1);
    }
    @Test
    public void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
        //when
        List<Member> result = repository.findAll();
        //then
        assertThat(result.size()).isEqualTo(2);
    }
}
