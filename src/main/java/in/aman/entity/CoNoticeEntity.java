package in.aman.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class CoNoticeEntity {
	@Id
	private String noticeStatus;
	
	private Long caseNum;
	
	private String noticeUrl;

}
