import java.util.*;

/**
 * This program is used to generate all possible permutations of a given string by using iterative method.
 * 1st Approach Complexity : Order of n^2*n!
 * Auxiliary Space: n!
 * Example : "abc"
 * Permutations Generated: abc,acb,bac,bca,cab,cba
 *
 * 2nd Approach Complexity : Order of n*n!
 */


public class Permutation
{

public static void main(String ar[])
{
    String str="abc";
    //generatePermute(str).stream().forEach(p->System.out.print(p+","));
    System.out.println();
    Set set=new HashSet();
    generatePermutationRecursively("",str,set).stream().forEach(s->System.out.println(s));


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


    /*This method will work in those cases also, where characters are duplicate*/
    private static Set generatePermutationRecursively(String result,String choices,Set set)
    {

        for(int i=0;i<choices.length();i++)
        {
            generatePermutationRecursively(result+choices.charAt(i)+"",choices.substring(0,i)+choices.substring(i+1),set);
        }
        if(choices.length()==0){
            set.add(result);
            return set;
        }
       return set;
    }



}
