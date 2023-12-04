package ms.library.mylibrary.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Requester {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
	String name;
	String mobile;
	String examTarget;
	String bookRequest;
	String address;
	String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getExamTarget() {
		return examTarget;
	}
	public void setExamTarget(String examTarget) {
		this.examTarget = examTarget;
	}
	public String getBookRequest() {
		return bookRequest;
	}
	public void setBookRequest(String bookRequest) {
		this.bookRequest = bookRequest;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
