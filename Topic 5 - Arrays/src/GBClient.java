import java.io.FileNotFoundException;
import java.text.DecimalFormat;


public class GBClient 
{
	public static void main(String[] args)
	{
		Gradebook gb = null;
		try
		{
			gb = new Gradebook(7, 5, "grades.txt");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
			System.exit(0);
		}
		
		System.out.println(gb);
		
		Student top = gb.findTopStudent();
		System.out.println("Top Student: " + top);
		Student bottom = gb.findStrugglingStudent();
		System.out.println("Struggling Student: " + bottom);
		
		Student top1 = gb.findTopStudentForAssignment(2);
		Student bottom1 = gb.findStrugglingStudentForAssignment(2);
		System.out.println("Top Student: " + top1);
		System.out.println("Struggling Student: " + bottom1);
		
		double[] studAvs = gb.findStudentAverages();
		double[] assignAvs = gb.findAssignmentAverages();
		
		print(studAvs);
		print(assignAvs);
	}
	
	public static void print(double[] ar)
	{
		DecimalFormat df = new DecimalFormat("###.00%");
		for(double d : ar)
			System.out.print(df.format(d) + "\t");
		System.out.println();
	}
}
