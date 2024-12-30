package tw.brad.stest5.service;

import java.util.Base64;
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
		Member saveMember = memberRepository.save(member);
		System.out.println("debug1:" + member.getIcon().length);
		System.out.println("debug2:" + member.getIconBase64());
	}
	
	public Member loginMember(Member loginMember) {
		Optional<Member> opt = memberRepository.findByAccount(loginMember.getAccount());
		try {
			Member member = opt.get();
			if (member != null) {
				if (!BCrypt.checkpw(loginMember.getPasswd(), member.getPasswd())) {
					member = null;
				}else {
					member.setIconBase64(Base64.getEncoder().encodeToString(member.getIcon()));
				}
			}
			return member;
		}catch(Exception e) {
			return null;
		}
	}
	
	
}
