public class EmpWageComProb {
	public static void main(String[] args){
	System.out.println("Welcome to Employee Wage Computation Problem");

	int isPresent = 1;
	double randomcheck = Math.floor(Math.random() % 10) % 2;

	if (randomcheck == isPresent)
		System.out.println("Present");
	else
		System.out.println("Absent");
	}

}
