package in.aman.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ELIG_DTLS")
@Setter
@Getter	
public class EligEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer edgTraceId;
	
	private String planId;
	
	private Long caseNum;
	
	private String planStatus;
	
	private Double benifitAmt;
	
	private LocalDate eligStartDate;
	
	private LocalDate eligEndDate;
	
	private String deialRsn;

}
