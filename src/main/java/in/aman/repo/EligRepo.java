package in.aman.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.aman.entity.EligEntity;

public interface EligRepo extends JpaRepository<EligEntity, Integer> {
	
	public EligEntity findByCaseNum(Long caseNum);

}
