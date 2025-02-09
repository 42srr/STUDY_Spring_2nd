//package hello.hello_spring.sevice;
//
//import hello.hello_spring.domain.Member;
//import hello.hello_spring.repository.MemoryMemberRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.config.RuntimeBeanReference;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//class MemberServiceTest {
//    MemberService memberService = new MemberService();
//    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
//
//    @AfterEach
//    public void afterEach(){
//        MemoryMemberRepository repository;
//    }
//    @Test
//    void 회원가입(){
//        //given -> 무언가 주어졌을때
//        Member member = new Member();
//        member.setName("hello");
//        //when -> 실행했을때
//        Long saveId = memberService.join(member);
//        //then -> 이런 결과가 나와야한다
//        Member findMember = memberService.findOne(saveId).get();
//        Assertions.assertThat(member.getId()).isEqualTo(findMember.getId());
//    }
//
//    @Test
//    public void 중복_회원_예외(){
//        //given
//        Member member1 = new Member();
//        member1.setName("spring");
//
//        Member member2 = new Member();
//        member2.setName("spring");
//        //when
//        memberService.join(member1);
//       IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//       assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
////            memberService.join(member2);
////            fail();
////        } catch (IllegalStateException e){
////            assertThat(e.getMessage().isEqualTo("이미 존재하는 회원입니다."));
////
////        }
//        memberService.join(member2); //중복으로 인한 validateDuplicateMember
//        //then
//    }
//    @Test
//    void findMembers() {
//    }
//
//    @Test
//    void findOne() {
//    }
//}