package tv1.demotv1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tv1.demotv1.repository.JdbcMemberRepository;
import tv1.demotv1.repository.MemberRepository;
import tv1.demotv1.repository.MemoryMemberRepository;
import tv1.demotv1.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new JdbcMemberRepository(dataSource);
    }
}

//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }
//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }