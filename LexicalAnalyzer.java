package cd_programs;

import java.util.*;

public class LexicalAnalyzer 
{
    static List<String> keywords = Arrays.asList("if", "while", "for", "else", "do", "int", "float", "double");
    static String symbols = ",./;']<>?:/\"\\{}|()+-*^%!=" ;
    
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter input string : ");
        String str = sc.nextLine();
        StringBuilder temp = new StringBuilder();
        char x[] = str.toCharArray();
        
        for(int i=0;i<x.length;i++)
        {
            if(Character.isLetterOrDigit(x[i]) || x[i]=='_')
                temp.append(x[i]); 
            else
            {
                if( keywords.contains(temp) )
                {
                    System.out.println("( Key word  "+temp+" )");
                    temp=new StringBuilder();
                }
                else
                {
                    try
                    {
                        int num = Integer.valueOf(temp.toString());
                        System.out.println("( Number  "+num+" )");
                    }
                    catch(Exception e)
                    {
                        if(!symbols.contains(temp))
                        System.out.println(" ( Identifier  "+temp +" )");
                    }
                    temp=new StringBuilder();
                }
                if(symbols.contains(x[i]+""))
                {
                    System.out.print(" ( Symbol  "+x[i]);       
                	if(i != x.length - 1 && symbols.contains(x[i+1]+""))
                	System.out.print(x[i++]);
                	System.out.println(" )");
                }
            }
        }
    }
}