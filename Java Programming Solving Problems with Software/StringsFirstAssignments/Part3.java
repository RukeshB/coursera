
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public String twoOccurrences(String stringa, String stringb)
    {
        
        String substringb=stringb;
        int count=0;
        for(int i=0;i<stringb.length();i++)
        {
            int index = substringb.indexOf(stringa);
            if(index == -1)
            {
                break;
            }
            substringb= substringb.substring(index+stringa.length(),substringb.length());
            count++;
        }
        
        if(count>1)
        {
            return "true";
        }
        return "false";
    }

    
    public String lastPart(String stringa, String stringb){
        int index = stringb.indexOf(stringa);
        if(index != -1)
        {
            stringb = stringb.substring(index+stringa.length(),stringb.length());
        }
        return stringb;
    }
    
    public void testing(){
        String a= "a";
        String b= "banana";
        System.out.println(a +" in "+b+" -> "+twoOccurrences(a,b));
        System.out.println(lastPart(a,b));
        
        a= "atg";
        b= "ctgatggta";
        System.out.println(a +" in "+b+" -> "+twoOccurrences(a,b));
        System.out.println(lastPart(a,b));
        
        a= "atg";
        b= "ctgatagta";
        System.out.println(a +" in "+b+" -> "+twoOccurrences(a,b));
        System.out.println(lastPart(a,b));
    }
    
    public static void main(String[] args){
     Part3 p3 = new Part3();
     p3.testing();
    }
}
