
 class CompanyEmpWage {

	public final String company;
	public final int empRatePerHrs;
	public final int numOfWorkingDays;
	public final int maxHrsPerMonth;
	public int totalEmpWage;

	public CompanyEmpWage(String company, int empRatePerHrs,
				int numOfWorkingDays, int maxHrsPerMonth){
	this.company = company;
	this.empRatePerHrs = empRatePerHrs;
	this.numOfWorkingDays = numOfWorkingDays;
	this.maxHrsPerMonth = maxHrsPerMonth;
	}
	public void setTotalEmpWage(int totalEmpWage){
		this.totalEmpWage = totalEmpWage;
	}

	public String toString() {
		return "Total Emp Wage for company: " +company+" is: "+
			totalEmpWage;
	}
}
	public class EmpWageBuilderArray extends CompanyEmpWage {
        public static final int IS_PART_TIME = 1;
        public static final int IS_FULL_TIME = 2;

	private int numOfCompany = 0;
	private CompanyEmpWage[] companyEmpWageArray;

	 EmpWageBuilderArray(){
		companyEmpWageArray = new CompanyEmpWage[5];
	}

	public void addCompanyEmpWage(String company, int empRatePerHrs,
                                        int numOfWorkingDays,
                                        int maxHrsPerMonth) {
		companyEmpWageArray[numOfCompany] = new CompanyEmpWage(
			company, empRatePerHrs, numOfWorkingDays,
			maxHrsPerMonth);
		numOfCompany++;
	}
	private void computeEmpWage(){
		for (int i=0; i < numOfCompany; i++){
			companyEmpWageArray[i].setTotalEmpWage(
			this.computeEmpWage(companyEmpWageArray[i]));
			System.out.println(companyEmpWageArray[i]);
	}
}
	private int computeEmpWage(CompanyEmpWage companyEmpWage){
	int emphrs = 0;
	int totalemphrs = 0;
	int totalworkingdays = 0;
	while (totalemphrs <= companyEmpWage.maxHrsPerMonth &&
		totalworkingdays < companyEmpWage.numOfWorkingDays) {
	totalworkingdays++;
	int empcheck = (int) Math.floor(Math.random() * 10) % 3;

	switch (empcheck) {
		case IS_PART_TIME:
	 		emphrs = 8;
			break;
		case IS_FULL_TIME:
			emphrs = 12;
			break;
		default:
			emphrs = 0;
		}
		totalemphrs += emphrs;
		System.out.println("Day#: " + totalworkingdays + " Emp Hr: "
					+emphrs);
		}
	 return totalemphrs * companyEmpWage.empRatePerHrs;
	}

	public static void main(String[] args){
	EmpWageBuilderArray empWageBuilder = new EmpWageBuilderArray();
	empWageBuilder.addCompanyEmpWage("Dmart", 20, 2, 10);
	empWageBuilder.addCompanyEmpWage("BigBazar", 20, 4, 20);
	empWageBuilder.computeEmpWage();
	}
}
