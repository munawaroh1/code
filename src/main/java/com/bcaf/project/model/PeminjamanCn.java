package com.bcaf.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "tbl_pinjam")

public class PeminjamanCn {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_pinjam_index")
	@TableGenerator(name = "tbl_pinjam_index", table = "tbl_index",
				pkColumnName = "index_id", valueColumnName = "index_value", 
				allocationSize = 1, initialValue = 0)
	@Column(name = "id", nullable = false)
	private Long id; 
	
	@Column(name = "followup_id")
	private Long followupId;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "status_pinjam")
	private String statusPinjam;
	
	//pinjam -- followup 
	@ManyToOne
	@JoinColumn(name = "followup_id", foreignKey = @ForeignKey(name = "fk_pinjam_followup_id"), insertable = false, updatable = false)
	public FollowUp followUp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFollowupId() {
		return followupId;
	}

	public void setFollowupId(Long followupId) {
		this.followupId = followupId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getStatusPinjam() {
		return statusPinjam;
	}

	public void setStatusPinjam(String statusPinjam) {
		this.statusPinjam = statusPinjam;
	}

	public FollowUp getFollowUp() {
		return followUp;
	}

	public void setFollowUp(FollowUp followUp) {
		this.followUp = followUp;
	} 
	
	//pinjam -- USER 
//	@ManyToOne
//	@JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_pinjam_user_id"), insertable = false, updatable = false)
//	public User user;

	
}
