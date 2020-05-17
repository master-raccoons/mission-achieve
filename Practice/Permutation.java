import java.util.*;

public class Permutation
{

public static void main(String ar[])
{
    System.out.println("abc".contains("u"));
    String str="abc";
    //generatePermute(str).stream().forEach(s->System.out.println(s));
    HashSet set=new HashSet();
    generatePermute(str,3);
}

    private static List generatePermute(String str)
    {
        List list=new ArrayList();
        list.add("");
        int count=0;
        while(count<str.length())
        {
            List list1=new ArrayList();
            for (char c : str.toCharArray())
            {

                for(int i=0;i<list.size();i++)
                {
                    if(!list.get(i).toString().contains(c+""))
                    list1.add(c+""+list.get(i));
                }
            }
            count++;
            list=list1;
        }


        return list;
    }


    private static void generatePermute(String s,int len)
    {

// convert string to a character array (Since String is immutable)
        char[] chars = s.toCharArray();

        // Weight index control array
        int[] p = new int[s.length()];

        // i, j represents upper and lower bound index resp. for swapping
        int i = 1, j = 0;

        // Print given string, as only its permutations will be printed later
        System.out.print(s);

        while (i < s.length())
        {
            //Arrays.stream(p).forEach(a->System.out.print(a));
            System.out.println();
            if (p[i] < i)
            {
                // if i is odd then j = p[i], otherwise j = 0
                j = (i % 2) * p[i];

                // swap(a[j], a[i])
                char ch = chars[i];
                chars[i] = chars[j];
                chars[j] = ch;


                // Print current permutation
                //System.out.print(p[0]+":"+p[1]+":"+p[2]+"- " + String.valueOf(chars));

                p[i]++;	// increase index "weight" for i by one
                i = 1;	// reset index i to 1
            }
            // otherwise p[i] == i
            else {
                // reset p[i] to zero
                p[i] = 0;

                // set new index value for i (increase by one)
                i++;
            }
        }



    }


}
