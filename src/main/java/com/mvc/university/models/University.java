package com.mvc.university.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="universities")
public class University {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="City can't be empty")
	@Size(min=2, max=255, message="City must be 2-255 characters")
	private String city; // city where the university located
	
	@NotBlank(message="University name can't be empty")
	@Size(min=2, max=255, message="University name must be 2-255 characters")
	private String name; // the name of the university
	
	@NotNull(message="Enrollment field can't be empty")
	@Min(value=1, message="Number of enrollment need to be at leaste 1")
	private Integer enrollment; // number of students
	
	@NotNull(message="Must input if the university offers online course or not")
	private Boolean isOnline; // whether the university is online or not
	
	@NotNull(message="Must input if the university offers in-person course or not")
	private Boolean isInPerson; // whether if the university offers in-person courses
	
	@NotNull(message="Years of founded field can't be empty")
	@Min(value=1, message="Years of founded need to be at leaste 1")
	private Integer yearFounded; // years the university established
	
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updateAt;
	
	@PrePersist
	protected void onCreate() {
		this.createAt = new Date();
		this.updateAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updateAt = new Date();
	}
	
	public University() {}
	
	public University(
			@NotBlank(message = "City can't be empty") @Size(min = 2, max = 255, message = "City must be 2-255 characters") String city,
			@NotBlank(message = "University name can't be empty") @Size(min = 2, max = 255, message = "University name must be 2-255 characters") String name,
			@NotNull(message = "Enrollment field can't be empty") @Min(value = 1, message = "Number of enrollment need to be at leaste 1") Integer enrollment,
			@NotNull(message = "Must input if the university offers online course or not") Boolean isOnline,
			@NotNull(message = "Must input if the university offers in-person course or not") Boolean isInPerson,
			@NotNull(message = "Years of founded field can't be empty") @Min(value = 1, message = "Years of founded need to be at leaste 1") Integer yearFounded) {
		this.city = city;
		this.name = name;
		this.enrollment = enrollment;
		this.isOnline = isOnline;
		this.isInPerson = isInPerson;
		this.yearFounded = yearFounded;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Integer enrollment) {
		this.enrollment = enrollment;
	}

	public Boolean getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(Boolean isOnline) {
		this.isOnline = isOnline;
	}

	public Boolean getIsInPerson() {
		return isInPerson;
	}

	public void setIsInPerson(Boolean isInPerson) {
		this.isInPerson = isInPerson;
	}

	public Integer getYearFounded() {
		return yearFounded;
	}

	public void setYearFounded(Integer yearFounded) {
		this.yearFounded = yearFounded;
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

	
}
