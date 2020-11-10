package sad.humanresourcemanagementsystem.model;

public class EmployeeFee {
private int id;
private String employeeCode;
private String staffName;
private int workingDays;
private long otHours;
private String basicSalary;
private double hourSalary;
private double totalSalary;
private String kpi;
private String travel;
private String equipment;
private String bonus;
private String inssurance;
private String other;
private String tax;
private String payday;
private double totalFee;
public EmployeeFee() {
	
}
public EmployeeFee(int id, String employeeCode, String staffName, int workingDays, long otHours, String basicSalary, double hourSalary, String kpi, String travel, String equipment, String bonus, String inssurance,
		String other, String tax, double totalFee) {
	super();
	this.id = id;
	this.employeeCode = employeeCode;
	this.staffName = staffName;
	this.workingDays = workingDays;
	this.otHours = otHours;
	this.basicSalary= basicSalary;
	this.hourSalary = hourSalary;
	this.kpi = kpi;
	this.travel = travel;
	this.equipment = equipment;
	this.bonus = bonus;
	this.inssurance = inssurance;
	this.other = other;
	this.tax = tax;
	this.totalFee = totalFee;
}

public EmployeeFee(int id, String employeeCode, String staffName, String basicSalary, double hourSalary, String kpi, String travel, String equipment, String bonus, String inssurance,
		String other, String tax) {
	super();
	this.id = id;
	this.employeeCode = employeeCode;
	this.staffName = staffName;
	this.basicSalary= basicSalary;
	this.hourSalary = hourSalary;
	this.kpi = kpi;
	this.travel = travel;
	this.equipment = equipment;
	this.bonus = bonus;
	this.inssurance = inssurance;
	this.other = other;
	this.tax = tax;
	
	
}

public EmployeeFee(int id, String kpi, String travel, String equipment, String bonus, String inssurance,
		String other, String tax) {
	super();
	this.id = id;
	this.kpi = kpi;
	this.travel = travel;
	this.equipment = equipment;
	this.bonus = bonus;
	this.inssurance = inssurance;
	this.other = other;
	this.tax = tax;
	
	
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}


public String getEmployeeCode() {
	return employeeCode;
}

public void setEmployeeCode(String employeeCode) {
	this.employeeCode = employeeCode;
}

public String getStaffName() {
	return staffName;
}

public void setStaffName(String staffName) {
	this.staffName = staffName;
}



public String getBasicSalary() {
	return basicSalary;
}

public void setBasicSalary(String basicSalary) {
	this.basicSalary = basicSalary;
}

public double getHourSalary() {
	return hourSalary;
}

public void setHourSalary(double hourSalary) {
	this.hourSalary = hourSalary;
}

public String getKpi() {
	return kpi;
}

public void setKpi(String kpi) {
	this.kpi = kpi;
}

public String getTravel() {
	return travel;
}

public void setTravel(String travel) {
	this.travel = travel;
}

public String getEquipment() {
	return equipment;
}

public void setEquipment(String equipment) {
	this.equipment = equipment;
}

public String getBonus() {
	return bonus;
}

public void setBonus(String bonus) {
	this.bonus = bonus;
}

public String getInssurance() {
	return inssurance;
}

public void setInssurance(String inssurance) {
	this.inssurance = inssurance;
}

public String getOther() {
	return other;
}

public void setOther(String other) {
	this.other = other;
}

public String getTax() {
	return tax;
}

public void setTax(String tax) {
	this.tax = tax;
}

public String getPayday() {
	return payday;
}

public void setPayday(String payday) {
	this.payday = payday;
}

public int getWorkingDays() {
	return workingDays;
}

public void setWorkingDays(int workingDays) {
	this.workingDays = workingDays;
}

public double getOtHours() {
	return otHours;
}

public void setOtHours(long otHours) {
	this.otHours = otHours;
}

public double getTotalSalary() {
	return totalSalary;
}

public void setTotalSalary(long totalSalary) {
	this.totalSalary = totalSalary;
}

public double getTotalFee() {
	return totalFee;
}

public void setTotalFee(double totalFee) {
	this.totalFee = totalFee;
}








}
