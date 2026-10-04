import java.util.*;

class String_Handling {
    public static void main(String[] args) {
        // String message = "exam was conducted in monday";
        // StringBuilder sb = new StringBuilder(message);
        // sb.insert(0,"Final ");
        //  System.out.println(sb.toString());
        // sb.replace(28, 34, "Tuesday");
        // System.out.println(sb.toString());



        // StringBuilder sb = new StringBuilder("Java is");
        // sb.append(" a programming language");
        // sb.insert(7, " object-oriented");
        // System.out.println(sb.toString());
        // sb.delete(24,26);
        // System.out.println(sb.toString());
        // sb.reverse();
        // System.out.println(sb);



        // StringTokenizer st = new StringTokenizer("Java,Python,DBMS,Networking",",");
        // while(st.hasMoreTokens()){
        //     System.out.println(st.nextToken());
        // }



        //     String Details = "  Aaryan,Information technology,GTU2026  ";
        //     Details = Details.trim();
        //     System.out.println(Details);
        //     String Pattern = "^[A-Za-z0-9]+";

        //     String[] arr = Details.split(",");
        //     String name = arr[0];
        //     String branch = arr[1];
        //     String rollno = arr[2];

        //     System.out.println("Name: " + name.length());
        //     System.out.println("Branch: " + branch.toUpperCase());
        //    if(rollno.matches(Pattern)){
        //         System.out.println("valid");
        //     }
        //     else{
        //         System.out.println("invalid");
        //     }   


        // String str = "MADAM";
        // StringBuilder sb = new StringBuilder(str);
        // String check = sb.reverse().toString();
        // if(str.equals(check)){
            
        //     System.out.println("Palindrome");
        // }
        // else{
        //     System.out.println("Not Palindrome");
        // }   


        // String title = "Introduction to Java Programming";
        // if(title.contains("Java")){
        //     System.out.println("Java is present");
        // }
        // else{
        //     System.out.println("Java is not present");
        // }

//         StringBuffer sb = new StringBuffer("Hello");

// sb.delete(1, 3);

// System.out.println(sb);






    Scanner sc = new Scanner(System.in);
    String sentence = sc.nextLine();

    String[] word = sentence.trim().split(" ");
    String max = word[0];
     for(int i = 1; i< word.length ;i++){
        if(max.length() < word[i].length()){
            max = word[i];
            
        }
     }
     System.out.println("longest ="+max);

    }
}