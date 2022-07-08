package com.springboot.pubgtracker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.pubgtracker.model.LoginUser;
import com.springboot.pubgtracker.model.User;
import com.springboot.pubgtracker.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") Long userId){
        return userService.findById(userId);
    }

    @GetMapping("/users/getAll")
    public List<User> getAllUsers(){
        return userService.getUser();
    }

    @RequestMapping(path = "/updateUser", method = RequestMethod.PUT, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE })
    public User updateUser(@ModelAttribute FormWrapper formWrapper) throws IOException {
        User user=new User();
        user.setUserId(formWrapper.getUserId());
        user.setPassword(formWrapper.getPassword());
        user.setUserName(formWrapper.getUserName());
        user.setEmailAddress(formWrapper.getEmailAddress());
        user.setData(formWrapper.getData().getBytes());
        return userService.update(user,user.getUserId());
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PostMapping("/validate")
    public User validateUser(@RequestBody LoginUser loginUser){
        User user = userService.validateUser(loginUser.getEmailAddress());
        if(user.getPassword().equals(loginUser.getPassword()))
            return user;
        return null;
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class FormWrapper{
    private Long userId;
    private String userName;
    private String emailAddress;
    private String password;
    private MultipartFile data;
    
    
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public MultipartFile getData() {
		return data;
	}
	public void setData(MultipartFile data) {
		this.data = data;
	}
	public FormWrapper(Long userId, String userName, String emailAddress, String password, MultipartFile data) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.emailAddress = emailAddress;
		this.password = password;
		this.data = data;
	}
	public FormWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	@Override
	public String toString() {
		return "FormWrapper [userId=" + userId + ", userName=" + userName + ", emailAddress=" + emailAddress
				+ ", password=" + password + ", data=" + data + "]";
	}
    
    
}
