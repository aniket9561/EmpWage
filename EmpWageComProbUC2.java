public class EmpWageComProbUC2{


        public static final int IS_FULL_TIME = 1;
        public static final int EMP_RATE_PER_HOUR = 20;
        int emphrs = 0;
        int empwage = 0;

	public static int computeWage(){
	int emphrs = 0;
	int empwage = 0;
	double empcheck = Math.floor(Math.random() * 10) % 2;

	 if (empcheck == IS_FULL_TIME)
                emphrs = 8;
        else
                emphrs = 0;
        empwage = emphrs * EMP_RATE_PER_HOUR;
        System.out.println("Emp Wage: " + empwage);
	return empwage;
	}

	public static void main(String[] args){

		computeWage();
	}
}
