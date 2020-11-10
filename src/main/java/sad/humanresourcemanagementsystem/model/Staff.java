package sad.humanresourcemanagementsystem.model;

public class Staff {
private int id;
private int departmentId;
private String departmentName;
private String role;
private int status;
private String employeeCode;
private String fullName;
private String cmnd;
private int sex;
private String email;
private String phone;
private String dateOfBirth;
private String address;
private int marriageStatus;
private String contact;
private int activity;
private int profileStatus;
private String graduateInstitution;
private String major;
private String degree;
private String graduateYear;
private String overseaEducation;
public Staff() {}

public Staff(int id, String departmentName , String role, int status, String employeeCode, String fullName, String cmnd, int sex, String email, String phone, String dateOfBirth,
		String address,int marriageStatus, String contact, int activity,
		int profileStatus, String graduateInstitution, String major, String degree, String graduateYear,
		String overseaEducation) {
	super();
this.id = id;
	this.departmentName = departmentName;
	this.role = role;
	this.status = status;
	this.employeeCode = employeeCode;
	
	this.fullName = fullName;
	this.cmnd = cmnd;
	this.sex = sex;
	this.email = email;
	this.phone = phone;
	this.dateOfBirth = dateOfBirth;
	this.address = address;
	this.marriageStatus = marriageStatus;
	this.contact = contact;
	this.activity = activity;
	
	this.profileStatus = profileStatus;
	this.graduateInstitution = graduateInstitution;
	this.major = major;
	this.degree = degree;
	this.graduateYear = graduateYear;
	this.overseaEducation = overseaEducation;
}

public Staff(int id, int departmentId , String role, int status, String employeeCode, String fullName, String cmnd, int sex, String email, String phone, String dateOfBirth,
		String address, int marriageStatus, String contact, int activity,
		int profileStatus, String graduateInstitution, String major, String degree, String graduateYear,
		String overseaEducation) {
	super();
this.id = id;
	this.departmentId = departmentId;
	this.role = role;
	this.status = status;
	this.employeeCode = employeeCode;
	this.fullName = fullName;
	this.cmnd = cmnd;
	this.sex = sex;
	this.email = email;
	this.phone = phone;
	this.dateOfBirth = dateOfBirth;
	this.address = address;	
	this.marriageStatus = marriageStatus;
	this.contact = contact;
	this.activity = activity;
	this.profileStatus = profileStatus;
	this.graduateInstitution = graduateInstitution;
	this.major = major;
	this.degree = degree;
	this.graduateYear = graduateYear;
	this.overseaEducation = overseaEducation;
}

public Staff(int departmentId, String role, int status, String employeeCode, String fullName, String cmnd, int sex, String email, String phone, String dateOfBirth,
		String address,int marriageStatus, String contact, int activity, int profileStatus, String graduateInstitution, String major, String degree, String graduateYear,
		String overseaEducation) {
	super();
	this.departmentId = departmentId;
	this.role = role;
	this.status = status;
	this.employeeCode = employeeCode;
	this.fullName = fullName;
	this.cmnd = cmnd;
	this.sex = sex;
	this.email = email;
	this.phone = phone;
	this.dateOfBirth = dateOfBirth;
	this.address = address;
	this.marriageStatus = marriageStatus;
	this.contact = contact;
	this.activity = activity;
	this.profileStatus = profileStatus;
	this.graduateInstitution = graduateInstitution;
	this.major = major;
	this.degree = degree;
	this.graduateYear = graduateYear;
	this.overseaEducation = overseaEducation;
}

public Staff(String fullName, int sex, String email, String phone, String dateOfBirth, String address,
		int marriageStatus, String contact, String graduateInstitution, String major, String degree,
		String graduateYear, String overseaEducation) {
	super();
	this.fullName = fullName;
	this.sex = sex;
	this.email = email;
	this.phone = phone;
	this.dateOfBirth = dateOfBirth;
	this.address = address;
	this.marriageStatus = marriageStatus;
	this.contact = contact;
	this.graduateInstitution = graduateInstitution;
	this.major = major;
	this.degree = degree;
	this.graduateYear = graduateYear;
	this.overseaEducation = overseaEducation;
}




public Staff( String fullName, int sex, String email, String phone, String dateOfBirth,
		String address) {
	super();
	this.fullName = fullName;
	this.sex = sex;
	this.email = email;
	this.phone = phone;
	this.dateOfBirth = dateOfBirth;
	this.address = address;
}



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}


public int getDepartmentId() {
	return departmentId;
}

public void setDepartmentId(int departmentId) {
	this.departmentId = departmentId;
}

public String getDepartmentName() {
	return departmentName;
}


public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}


public void setContact(String contact) {
	this.contact = contact;
}


public String getRole() {
	return role;
}


public void setProfileStatus(int profileStatus) {
	this.profileStatus = profileStatus;
}
public void setRole(String role) {
	this.role = role;
}
public String getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(String dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public String getEmployeeCode() {
	return employeeCode;
}
public void setEmployeeCode(String employeeCode) {
	this.employeeCode = employeeCode;
}

public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
public String getCmnd() {
	return cmnd;
}
public void setCmnd(String cmnd) {
	this.cmnd = cmnd;
}
public int getSex() {
	return sex;
}
public void setSex(int sex) {
	this.sex = sex;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}

public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

public int getMarriageStatus() {
	return marriageStatus;
}
public void setMarriageStatus(int marriageStatus) {
	this.marriageStatus = marriageStatus;
}
public String getContact() {
	return contact;
}
public void setContract(String contact) {
	this.contact = contact;
}

public int getActivity() {
	return activity;
}
public void setActivity(int activity) {
	this.activity = activity;
}

public int getProfileStatus() {
	return profileStatus;
}
public void setProfileConfirm(int profileStatus) {
	this.profileStatus = profileStatus;
}
public String getGraduateInstitution() {
	return graduateInstitution;
}
public void setGraduateInstitution(String graduateInstitution) {
	this.graduateInstitution = graduateInstitution;
}
public String getMajor() {
	return major;
}
public void setMajor(String major) {
	this.major = major;
}
public String getDegree() {
	return degree;
}
public void setDegree(String degree) {
	this.degree = degree;
}
public String getGraduateYear() {
	return graduateYear;
}
public void setGraduateYear(String graduateYear) {
	this.graduateYear = graduateYear;
}
public String getOverseaEducation() {
	return overseaEducation;
}
public void setOverseaEducation(String overseaEducation) {
	this.overseaEducation = overseaEducation;
}


}
