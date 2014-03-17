package com.quiz.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.quiz.captcha.MyCaptcha;
import com.quiz.entity.User;
import com.quiz.jsf.utility.FacesUtil;
import com.quiz.service.UserService;

@ManagedBean(name = "userBean")
@ViewScoped
public class UserBean extends JSFBaseBean {
	
	@ManagedProperty(value = "#{userService}")
	private UserService userService;
	
	private List<User> userList;
	
	private User selectedUser;
	
	private String captchaVal;
	
	private boolean newRecord;
	

	@PostConstruct
	public void onPageLoad() {
		updateDataList();
	}

	public void addCmd() {
		this.newRecord = true;
		this.selectedUser = new User();
		this.captchaVal = null;
	}
	
	public void saveCmd(){
		if(newRecord && !isValidCaptcha()){
			FacesUtil.addErrorMsg("Invalid Captcha", "dlgForm:captchaId");
	        FacesContext.getCurrentInstance().validationFailed();
			return;
		}
		userService.saveOrUpdateUser(selectedUser);
		updateDataList();
		FacesUtil.addInfoMsg("Save successfully");
	}
	
	public void deleteCmd(User user){
		userService.deleteUser(user);
		updateDataList();
	}
	
	public void editCmd(User user){
		this.newRecord = false;
		this.selectedUser = user;
	}
	
	private void updateDataList() {
		userList = userService.fetchAllUser();
	}
	
	private boolean isValidCaptcha(){
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        javax.servlet.http.HttpSession session = request.getSession();
        String validCaptcha = (String) session.getAttribute(MyCaptcha.CAPTCHA_KEY);
		return captchaVal.equals(validCaptcha);
	}

	public UserService getUserService() {
		return userService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public List<User> getUserList() {
		return userList;
	}
	
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	public User getSelectedUser() {
		return selectedUser;
	}
	
	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}
	
	public boolean isNewRecord() {
		return newRecord;
	}
	
	public void setNewRecord(boolean newRecord) {
		this.newRecord = newRecord;
	}
	
	public String getCaptchaVal() {
		return captchaVal;
	}
	
	public void setCaptchaVal(String captchaVal) {
		this.captchaVal = captchaVal;
	}
}

