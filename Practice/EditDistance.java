import java.util.HashSet;

public class EditDistance {
private static int noOfFuncCalled=0;
static HashSet set=new HashSet();
    public static void main(String ar[])
    {
        System.out.println("---Edit Distance program---");
        String s1="acfg";
        String s2="adcfgji";
        System.out.print(count(s1,s2,0,0));
        System.out.println("called.."+noOfFuncCalled);
        System.out.println("repeated calls.."+set.size());
        set.stream().forEach(val->System.out.println(val));

    }

    private static int count(String s1,String s2,int index1,int index2)
    {
        noOfFuncCalled++;

        int count=0;
        if(s1.length()==0)
        {
            return s2.length();
        }
        if(s2.length()==0)
        {
            return s1.length();
        }
        if(s1.length()<=index1 && s2.length()<=index2)
        {
            return 0;
        }
        if(s1.length()<=index1 && s2.length()>index2)
        {
            return s2.length()-s1.length();
        }
        if(s2.length()<=index2 && s1.length()>index1)
        {
            return s1.length()-s2.length();
        }
        if(s1.charAt(index1)== s2.charAt(index2))
        {
            return count(s1,s2,index1+1,index2+1);
        }

        count=1+count(s1,s2,index1+1,index2+1);

        count=Math.min(count,1+count(s1,s2,index1,index2+1));

        count=Math.min(count,1+count(s1,s2,index1+1,index2));

        return count;

    }

}
