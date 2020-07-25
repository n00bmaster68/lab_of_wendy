import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;

class SortStringArray
{
	public static String[] input (String filename ) throws FileNotFoundException
	{
		String[] str = new String [10000000];
		File fname = new File (filename);
		Scanner sc = new Scanner ( fname );
		int index = -1;

		while ( sc.hasNext() )
		{
			index += 1;
			str[index] = sc.nextLine();
		}

		sc.close();
		return str;
	}

	public static int getLength(String[] str)
	{
		int number = 0;
		while (true)
		{
			if (str[number] == null)
				break;
			number += 1;
		}
		return number;
	}

	
	public static void getMonthArrayDay (String[] str, int[] a, int[] b)
	{
		int n = getLength(str);
		for (int i = 0; i < n ; i++)
		{
			a[i] = Integer.parseInt(str[i].substring(0, 2));
			b[i] = Integer.parseInt(str[i].substring(3, 5));
		}
	}

	public static String[] sortByMonth (String[] str)
	{
		String []s = str;
		int []a = new int [10000000];
		int []b = new int [10000000];
		getMonthArrayDay(s, a, b);//a is month array, b is day array
		int n = getLength(s);
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
				if (a[i] > a[j])
				{
					String temp = s[i];
					s[i] = s[j];
					s[j] = temp;

					int temp1 = a[i];
					a[i] = a[j];
					a[j] = temp1;

					int temp2 = b[i];
					b[i] = b[j];
					b[j] = temp2;
				}
				else if (a[i] == a[j] && b[i] > b[j])
				{
					String temp = s[i];
					s[i] = s[j];
					s[j] = temp;

					int temp1 = a[i];
					a[i] = a[j];
					a[j] = temp1;

					int temp2 = b[i];
					b[i] = b[j];
					b[j] = temp2;
				}
		return str;
	}

	public static void getGameName (String[] str, String[] a)
	{
		int n = getLength(str);
		for (int i = 0; i < n; i++)
			a[i] = str[i].substring(11, str[i].length());
	}

	public static String[] sortByName(String[] str)
	{
		String[] name = new String [1000000];
		int n = getLength(str);
		getGameName(str, name);
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
				if (name[i].compareToIgnoreCase(name[j]) > 0)
				{
					String temp = name[i];
					name[i] = name[j];
					name[j] = temp;
				}
		return name; 
	}

	public static void output(String[] str, String filename)throws Exception
	{
		int n = getLength(str);
		FileWriter writer = new FileWriter(filename);
      		for (int i = 0; i < n; i++)
       			writer.write(str[i] + "\n");
      	writer.close();
	}

	public static void main (String[] args) throws FileNotFoundException, Exception
	{
		String[] str = new String [1000000];
		str = input("releasedates.txt");
		
		String[] result1 = sortByMonth(str);
		String[] result2 = sortByName(str);

		output(result1, "SortedByDate.txt");
		output(result2, "SortedByName.txt");

	}
}
