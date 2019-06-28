//TCS exam question 2019
import java.util.Scanner;
class Month {
	public static void main(String[] args)
	{
		//String s = new Scanner(System.in).nextLine();
		//String arr[] = s.split("-");
		System.out.println("date format should be in dd-mm-yyyy");
		String arr[] = new Scanner(System.in).nextLine().split("-");
		if(arr.length > 3)
			System.out.println("It is not a valid date.");

		int ch = isLeapYear(arr[2]);
		if(ch == 0 || ch == 1)
			display(arr[0], arr[1], ch);
		else
			System.out.println("Enter Valid Date-Month-Year");
	}

	public static int isLeapYear(String str)
	{
		int year = Integer.parseInt(str);
		if(year < 0)
			return -1;
		
		if(year%4 == 0)
		{
			if(year%100 == 0)
			{
				if(year%400 == 0)
					return 1;
				else
					return 0;
			}
			else
				return 1;
		}
		else
		{
			return 0;
		}
	}

	public static void display(String str_d, String str_m , int ch)
	{
		String[] arr = {"January", "February", "March", "April", "May", "June", "July", "August", "Sepetember", "October", "November", "December" };
		int[] date = {31,28,31,30,31,30,31,31,30,31,30,31};

		int curr_date = Integer.parseInt(str_d);
		//System.out.println(curr_date);
		int month = Integer.parseInt(str_m);
		//System.out.println(month);
		if(month>0 && month < 12 )
		{
			if(ch == 0)
			{
				if(curr_date <= date[month-1])
					System.out.println(arr[month-1]+" has "+date[month-1]+" Days.");
				else
					System.out.println("Enter a valid Date.");						
			}
			else
			{
				if((month==2)&&(curr_date <= (date[1]+1)))
					System.out.println(arr[month-1]+" has "+( date[month-1]+1)+" Days.");
				else if(curr_date <= date[month-1])
					System.out.println(arr[month-1]+" has "+date[month-1]+" Days.");
				else
					System.out.println("Enter a valid Date.");	
			}
		}
		else
			System.out.println("Entered Month is Wrong");
	}	
}
