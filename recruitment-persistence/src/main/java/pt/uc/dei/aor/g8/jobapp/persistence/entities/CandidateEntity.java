package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "candidate")
@PrimaryKeyJoinColumn(name = "id")
public class CandidateEntity extends UserEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(length = 255, nullable = false)
    private String address;
	
	@Column(length = 30, nullable = false)
    private String city;
	
	@Column(length = 30, nullable = false)
    private String country;
	
	@Column(length = 15)
    private BigInteger phone;
	
	@Column(length = 15)
    private BigInteger mobile;
	
	@Column(length = 60, nullable = false)
    private String diploma;
	
	@Column(length = 60, nullable = false)
    private String school;
	
	@Column
    private String letter;
	
	@Column
    private String cv;

	public CandidateEntity() {
		super();
	}

}
