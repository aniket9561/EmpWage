// anymsg
public class EmpWageComProbUC9 {
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;

	public final String company;
	public final int empRatePerHrs;
        public final int numOfWorkingDays;
        public final int maxHrsPerMonth;
	public int totalempwage;

public EmpWageComProbUC9(String company, int empRatePerHrs,
                                        int numOfWorkingDays,
                                        int maxHrsPerMonth){
	this.company = company;
	this.empRatePerHrs = empRatePerHrs;
	this.numOfWorkingDays = numOfWorkingDays;
	this.maxHrsPerMonth = maxHrsPerMonth;
}

	public void computeEmpWage() {

	int emphrs = 0;
	int totalemphrs = 0;
	int totalworkingdays = 0;
	while (totalemphrs <= maxHrsPerMonth &&
		totalworkingdays < numOfWorkingDays) {
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
	 totalempwage = totalemphrs * empRatePerHrs;
	}
	public String toString(){

	return "Total Emp wage for company: " +company+
		" is: " + totalempwage;
	}

	public static void main(String[] args){
	EmpWageComProbUC9 dMart = new EmpWageComProbUC9("dMart", 20, 2, 10);
	EmpWageComProbUC9 BigBazar = new EmpWageComProbUC9("BigBazar", 10, 3,
								20);
	dMart.computeEmpWage();
	System.out.println(dMart);

	BigBazar.computeEmpWage();
	System.out.println(BigBazar);
	}
}
