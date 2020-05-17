import java.util.HashSet;
import java.util.Set;

public class DistinctPassword {

    public static void main(String ar[])
    {

        String input2[]={"abcdef"};
// cbadef cdabef cdebaf
        Set set=new HashSet();
        for(int i=0;i<input2.length;i++)
        {
            set.add(input2[i]);
        }

        for(int k=0;k<input2.length;k++)
        {
            if(!set.contains(input2[k]))
                continue;
            String str = input2[k];
            char chr[]=str.toCharArray();
            for (int i = 0,j=2; j < chr.length;j++) {

                if ((i + j)%2 == 0) {
                    char temp = chr[i];
                    chr[i] = chr[j];
                    chr[j] = temp;
                    i++;
                }
            }


                String res="";
                for(int m=0;m<chr.length;m++)
                {
                    res=res+chr[m];
                }
                System.out.println(""+res);
                set.remove(res);



        }
        System.out.println(""+set.size());
    }


}
