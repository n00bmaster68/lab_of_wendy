import java.util.Arrays;

public class test 
{
    // public static void orderedGuests(String[] hotel)
    // {
    //     Arrays.sort(hotel);
    //     System.out.println(Arrays.toString(hotel));
    // }
    public static void main(String[] args) 
    {
        String arrString[] = { "pet er", "ta ylor", "broo ke", "frederick", "cameron" };
        Arrays.sort(arrString);
        for (int i = 0; i < arrString.length; i++)
            System.out.println(arrString[i]);
        // String s = "12/13/2001 abd edfh";
        // System.out.println(s.substring(11, s.length()));  
    }
}