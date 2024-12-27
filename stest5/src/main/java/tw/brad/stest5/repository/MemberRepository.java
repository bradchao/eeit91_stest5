package tw.brad.stest5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.brad.stest5.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

}