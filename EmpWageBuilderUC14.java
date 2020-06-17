import java.util.ArrayList;

interface IComputeEmpWage{
	public void addCompanyEmpWage(String company, int empRatePerHrs,
                                        int numOfWorkingDays,
                                        int maxHrsPerMonth);
	public void computeEmpWage();
	public int getTotalWage(String company);
}


class CompanyEmpWage {
	public final String company;
	public final int empRatePerHrs;
	public final int numOfWorkingDays;
	public final int maxHrsPerMonth;
	public int totalEmpWage;

	 CompanyEmpWage(String company, int empRatePerHrs,
				int numOfWorkingDays, int maxHrsPerMonth){
	this.company = company;
	this.empRatePerHrs = empRatePerHrs;
	this.numOfWorkingDays = numOfWorkingDays;
	this.maxHrsPerMonth = maxHrsPerMonth;
	totalEmpWage = 0;
	}
	public void setTotalEmpWage(int totalEmpWage){
		this.totalEmpWage = totalEmpWage;
	}

	public String toString() {
		return "Total Emp Wage for company: " +company+" is: "+
			totalEmpWage;
	}
}
	public class EmpWageBuilderUC14 implements IComputeEmpWage {
        public static final int IS_PART_TIME = 1;
        public static final int IS_FULL_TIME = 2;

	private int numOfCompany = 0;
	private ArrayList<CompanyEmpWage> companyEmpWageArray;

	 EmpWageBuilderUC14(){
		companyEmpWageArray = new ArrayList<>();
	}

	public void addCompanyEmpWage(String company, int empRatePerHrs,
                                        int numOfWorkingDays,
                                        int maxHrsPerMonth) {
		CompanyEmpWage companyEmpWage = new CompanyEmpWage(
			company, empRatePerHrs, numOfWorkingDays,
			maxHrsPerMonth);
		companyEmpWageArray.add(companyEmpWage);
	}
	public void computeEmpWage(){
		for (int i=0; i < companyEmpWageArray.size(); i++){
			CompanyEmpWage companyEmpWage =
			companyEmpWageArray.get(i);
		companyEmpWage.setTotalEmpWage(this.computeEmpWage
			(companyEmpWage));
		System.out.println(companyEmpWage);
	}
}
	public int getTotalWage(String company){
		return companyEmpWageArray.get(company).totalEmpWage;
}
	public int computeEmpWage(CompanyEmpWage companyEmpWage){
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
	IComputeEmpWage empWageBuilder = new EmpWageBuilderUC14();
	empWageBuilder.addCompanyEmpWage("Dmart", 20, 2, 10);
	empWageBuilder.addCompanyEmpWage("BigBazar", 20, 4, 20);
	empWageBuilder.computeEmpWage();
	System.out.println("Total Wage For Dmart: " +
			empWageBuilder.getTotalWage("Dmart"));
	}
}
