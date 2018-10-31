package FirstJenkinsJob.Artifact1;


public class InheritanceTester {
	public static void main(String[] args){
		SoftwareEngineer se = new SoftwareEngineer();
		TeamLead tl = new TeamLead();
		
		se.setEmployeeId(5001);
		se.setEmployeeName("David");
		se.setProjectName("Health Care");
		
		tl.setEmployeeId(2001);
		tl.setEmployeeName("James");
		tl.setNumberOfProjectsManaged(3);
		
		System.out.println("Software Engineer details: ");
		System.out.println("Name: " + se.getEmployeeName());
		System.out.println("ID: " + se.getEmployeeId());
		System.out.println("Project Name: " + se.getProjectName());
		
		System.out.println();
		System.out.println("Team Lead details: ");
		System.out.println("Name: " + tl.getEmployeeName());
		System.out.println("ID: " + tl.getEmployeeId());
		System.out.println("Number of projects managed: " + tl.getNumberOfProjectsManaged());
		
	}
}
