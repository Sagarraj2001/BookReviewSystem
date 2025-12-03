package com.backend.Backend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String userName;
	private Long mobNo;
	@Column(unique = true,nullable = true)
	private String email;
	@JsonIgnore
	private String password;


}
