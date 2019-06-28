//TCS exam question 2019
import java.util.Scanner;
class Month {
	public static void main(String[] args)
	{
		System.out.println("date format should be in dd-mm-yyyy");
		String arr[] = new Scanner(System.in).nextLine().split("-");
		try{
			if(arr.length != 3)
				throw new Exception();

			boolean ch = isLeapYear(arr[2]);

			try
			{
				display(arr[0], arr[1], ch);
			}
			catch(MonthException Me)
			{
				System.out.println(Me);
			}
			catch(DateException De)
			{
				System.out.println(De);
			}
		}
		catch(Exception e)
		{
			System.out.println("Valid date format is dd-mm-yyyy");
		}
		
		
	}

	public static boolean isLeapYear(String str)
	{
		int year = Integer.parseInt(str);
		
		if(year%4 == 0)
		{
			if(year%100 == 0)
			{
				if(year%400 == 0)
					return true;
				else
					return false;
			}
			else
				return true;
		}
		else
		{
			return false;
		}
	}

	public static void display(String str_d, String str_m , boolean ch) throws MonthException,DateException
	{
		String[] arr = {"January", "February", "March", "April", "May", "June", "July", "August", "Sepetember", "October", "November", "December" };
		int[] date = {31,28,31,30,31,30,31,31,30,31,30,31};

		int curr_date = Integer.parseInt(str_d);
		int month = Integer.parseInt(str_m);

			if(month>0 && month < 12 )
			{
				if(ch)
				{
					if((month==2)&&(curr_date <= (date[1]+1)))
						System.out.println(arr[month-1]+" has "+( date[month-1]+1)+" Days.");
					else if(curr_date <= date[month-1])
						System.out.println(arr[month-1]+" has "+date[month-1]+" Days.");
					else
						throw new DateException("Entered Date is Wrong");	
				}
				else
				{
					if(curr_date <= date[month-1])
						System.out.println(arr[month-1]+" has "+date[month-1]+" Days.");
					else
						throw new DateException("Entered Date is Wrong");
				}
			}
			else
				throw new MonthException("Entered Month is Wrong");	
	}	
}


class MonthException extends Exception
{
	String str ="" ;
	
	MonthException(String st1)
	{
		str = st1;
	}

	public String toString()
	{
		return (str);
	}
}

class DateException extends Exception
{
	String str ="" ;
	
	DateException(String st1)
	{
		str = st1;
	}

	public String toString()
	{
		return (str);
	}
}
