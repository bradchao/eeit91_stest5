package tw.brad.stest5.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.brad.stest5.model.Member;
import tw.brad.stest5.repository.MemberRepository;
import tw.brad.stest5.util.BCrypt;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	public void addMember(Member member) {
		member.setPasswd(BCrypt.hashpw(member.getPasswd(), BCrypt.gensalt()));
		memberRepository.save(member);
	}
	
	public Member loginMember(Member loginMember) {
		Optional<Member> opt = memberRepository.findByAccount(loginMember.getAccount());
		Member member = opt.get();
		if (member != null) {
			if (!BCrypt.checkpw(loginMember.getPasswd(), member.getPasswd())) {
				member = null;
			}
		}
		return member;
	}
	
	
}
