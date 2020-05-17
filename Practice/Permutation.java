import java.util.*;

/**
 * This program is used to generate all possible permutations of a given string by using iterative method.
 * Complexity : Order of n^2*n!
 * Auxiliary Space: n!
 * Example : "abc"
 * Permutations Generated: abc,acb,bac,bca,cab,cba
 *  
 */


public class Permutation
{

public static void main(String ar[])
{
    String str="abc";
    generatePermute(str).stream().forEach(p->System.out.print(p+","));

}

    private static List generatePermute(String str)
    {
        List permutations=new ArrayList();
        permutations.add("");
        int count=0;
        while(count<str.length())
        {
            List tempList=new ArrayList();
            for (char c : str.toCharArray())
            {

                for(int i=0;i<permutations.size();i++)
                {
                    if(!permutations.get(i).toString().contains(c+""))
                        tempList.add(c+""+permutations.get(i));
                }
            }
            count++;
            permutations=tempList;
        }


        return permutations;
    }




}
