package com.mvc.university.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="halls")
public class Hall {

//	----- Variables -----
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Hall name can't be blank")
	@Size(min=3, max=126, message="Hall name must be 3-126 characters")
	private String hallName;
	
	@NotNull(message="Cannot leave floor count empty")
	@Min(value=1, message="Must has at leaste 1 floor")
	private Integer floors;
	
	@NotNull(message="Must select whether this hall has housing")
	private Boolean isResidential;
	
	@NotNull(message="Must select whether this hall has lecture room")
	private Boolean hasLectureRoom;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createAt;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updateAt;

	@PrePersist
	protected void onCreate() {
		this.createAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updateAt = new Date();
	}
	
	
//	----- Constructor -----
	public Hall() {}
	
	public Hall(
			@NotBlank(message = "Hall name can't be blank") @Size(min = 3, max = 126, message = "Hall name must be 3-126 characters") String hallName,
			@NotNull(message = "Cannot leave floor count empty") @Min(value = 1, message = "Must has at leaste 1 floor") Integer floors,
			@NotNull(message = "Must select whether this hall has housing") Boolean isResidential,
			@NotNull(message = "Must select whether this hall has lecture room") Boolean hasLectureRoom,
			University university) {
		this.hallName = hallName;
		this.floors = floors;
		this.isResidential = isResidential;
		this.hasLectureRoom = hasLectureRoom;
		this.university = university;
	}



	//	Set up on 'Many2One' side
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="university_id")
	private University university;

	
//	Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHallName() {
		return hallName;
	}

	public void setHallName(String hallName) {
		this.hallName = hallName;
	}

	public Integer getFloors() {
		return floors;
	}

	public void setFloors(Integer floors) {
		this.floors = floors;
	}

	public Boolean getIsResidential() {
		return isResidential;
	}

	public void setIsResidential(Boolean isResidential) {
		this.isResidential = isResidential;
	}

	public Boolean getHasLectureRoom() {
		return hasLectureRoom;
	}

	public void setHasLectureRoom(Boolean hasLectureRoom) {
		this.hasLectureRoom = hasLectureRoom;
	}

	public Date getCreateAt() {
		return createAt;
	}

//	public void setCreateAt(Date createAt) {
//		this.createAt = createAt;
//	}

	public Date getUpdateAt() {
		return updateAt;
	}

//	public void setUpdateAt(Date updateAt) {
//		this.updateAt = updateAt;
//	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}
	
	
	
}
