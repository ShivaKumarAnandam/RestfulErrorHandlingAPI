package com.rest.eh;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@NotNull(message = "User name Shouldn't be null")
	private String name;
	
	@Email(message = "Invalid email address")
	private String email;
	
	@Pattern(regexp = "^\\d{10}$",message = "Invalid mobile number entered")
	private String mobile;
	
	private String gender;
	
	@Min(18) @Max(60)
	private int age;
	
	@NotBlank
	private String nationality;
}

//	 When we post these kind of data
//	 { 
//		 "email":"facgmail.com",
//	
//		 "mobile":"734649999",
//	
//  	 "gender":"Male",
//	
//		 "age":17
// 	 }
//	 we get following Exception messages
//	 {
//		 "nationality": "must not be blank",
// 		 "mobile": "Invalid mobile number entered",
// 		 "name": "User name Shouldn't be null",
//		 "age": "must be greater than or equal to 18",
//		 "email": "Invalid email address"
//	 }

// 	 when we get the data based on id not present we get following message
// 	 {
// 	    "Id Error Message": "The user id data is not present"
//	 }

// 	 When we get the data based on Age out of range (eg.http://localhost:8080/fetch/61/62) 
//   we get following Exception message
// 	 {
//  	 "Age Data Error Message": "The user Age between data is not present"
// 	 }