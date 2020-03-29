package miwok.android.example.com.learnc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import org.w3c.dom.Text;

import java.net.URL;

import thereisnospon.codeview.CodeView;
import thereisnospon.codeview.CodeViewTheme;

import static miwok.android.example.com.learnc.Code.CODE;

public class WebView extends AppCompatActivity {
    int roll;

    TextView ques,exp;
    InterstitialAd mInterstitialAd;
    int a,b;
    public static final String SHARED_PREF="sharedPref";
    public static final String VALUE="value";

    @Override
    public void onBackPressed() {
        loaddata();
        b=a%4;
        a++;
        savedata();
        if(b==0){
            if(mInterstitialAd.isLoaded()){
                mInterstitialAd.show();
                mInterstitialAd.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {
                        super.onAdClosed();
                        WebView.super.onBackPressed();
                    }
                });
            }
            else{super.onBackPressed();}
        }else
        {super.onBackPressed();}
    }

    CodeView codeView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setTitle();
        setContentView(R.layout.activity_web_view);
        AdView mAdView = (AdView)findViewById(R.id.adView1);
        AdRequest.Builder adRequestBuilder = new AdRequest.Builder();
        mAdView.loadAd(adRequestBuilder.build());
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-5627293645158234/6640091784");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        exp=(TextView)findViewById(R.id.exp);
        ques=(TextView)findViewById(R.id.ques);
        codeView=(CodeView)findViewById(R.id.codeview);
        codeView.setTheme(CodeViewTheme.ANDROIDSTUDIO).fillColor();
        int ref=0;
        //CODE is your code which  you want to show,type is String
        //codeView.showCode(CODE);


        Intent intent = getIntent();
        if (intent!=null) {
            roll= intent.getIntExtra("Roll",2000);
        }
        if(roll==1){
            setTitle("Introduction to C++");
            ques.append(" Introduction to C++ . A Basic Program");
              String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{\n" +
                    "cout<<\"Hello World\";\n" +
                    "}";
              codeView.showCode(code);
              exp.setText("Here, we have used iostream header file because it consist of cout function which help us to display anything on Screen \nIn new co" +
                      "mpilers ony #include<iostream> can work.\n\n" +"" +
                      "void main is a starting part and a neccessary part of a Program .Compiler used to execute the program line by line .\ncout is used to display the text on screen ." +
                      "" +
                      "\n\nRemember : Terminator ( ; ) is just like a full stop in programming language .You have to place these terminators after every executable line .");}
        else if(roll==2) {
            setTitle("User Input");
            ques.append(" Accept a number from user and display it on Screen");
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{\n" +
                    "int a;\n" +
                    "cout<<\"Enter any Number \";\n" +
                    "cin>>a;\n" +
                    "cout<<\"The number entered is\"<<a;\n" +
                    "}";
            codeView.showCode(code);
            exp.setText("Here , we have used cin which is used to accept any number from the user.\n" +
                    "We have used a int type variable to store the number/\n\n"+
                    "Remember: The text inside the \"\" are as it is displayed on the screen and the the text without \"\" are not display as it is .Their actual value is displayed.  ");


        }
        else if (roll==4){
            setTitle("Area of Square");
            ques.append(" Program to find area of Square");
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{\n" +
                    "int s,a;\n" +
                    "cout<<\"\\n Enter the side of Square \";\n" +
                    "cin>>s;\n" +
                    "a=s*s;\n" +
                    "cout<<\"\\n Area of Square is \"<<a;\n" +
                    "}";
            codeView.showCode(code);
            exp.setText("Here , First we have asked user to input the side of square by using cin command in 's' variable ." +
                    "" +
                    "\nWe have also taken another variabe 'a' in which we can store the area by the formula (side*side)." +
                    "\nAfter this we have dispayed the area on the screen by using cout commands \n\n" +
                    "Remember :'/n' is used the display the command in new line .     ");



        }
        else if(roll==3)
        {   setTitle("Input and Output Basic ");
            ques.append(" Accept two number and display the sum of it");
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{\n" +
                    "int a,b,c;\n" +
                    "cout<<\"Please enter First number\";\n" +
                    "cin>>a;\n" +
                    "cout<<\"Please enter Second number\";\n" +
                    "cin>>b;\n" +
                    "c=a+b;\n" +
                    "cout<<\"Sum of two numbers is \"<<c;\n" +
                    "}\n";
            codeView.showCode(code);

            exp.setText("Here ,we have used 3 int type variable .First two variables 'a' and 'b' are used to enter the numbers and the third variable 'c' is " +
                    "used to store sum of it.\nFor input cin command is used .After the input the sum of both is saved in 'c'.After this c is displayed on the screen .");


        }
        else if(roll==5){
            setTitle("Area of Square");
            ques.append(" Accept length and breadth of Rectangle and display its area");
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{\n" +
                    "int l,b,a;\n" +
                    "cout<<\"\\n Please enter length of Rectangle\";\n" +
                    "cin>>l;\n" +
                    "cout<<\"\\n Please enter Breadth of Rectangle\";\n" +
                    "cin>>b;\n" +
                    "a=l*b;\n" +
                    "cout<<\"\\n Area of Rectangle is \"<<a;\n" +
                    "}\n";
            codeView.showCode(code);
            exp.setText("Here ,we have used three variables.\nint l -> for storing length of rect." +
                    "\nint b ->for storing breadth of rect.\nint a ->for storing area by formula (length*breadth).\n" +
                    "Rest all are basic commands and can be understood from earlier programs");



        }
        else if (roll==6){
            setTitle("Area of Circle");
            ques.append(" Accept radius of circle and display its Area");
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{\n" +
                    "int r;\n" +
                    "float a;\n" +
                    "cout<<\"\\n Please enter radius of Circle\";\n" +
                    "cin>>r;\n" +
                    "a=3.14*r*r;\n" +
                    "cout<<\"\\n Area of Circle is \"<<a;\n" +
                    "}\n";
            codeView.showCode(code);
            exp.setText("The main thing is this program is that we have taken 'a' as  float type variable.\n" +
                    "This is because to calculate the area the circle we have to multiply the radius with 3.14 (π pi value)which is a deciaml value.So, obviously when we multiply anything with decimal value" +
                    " then result will be a decimal value and which can be stored in float type variable." +
                    "\n\nWe may take 'a' as a int type variable but then it will not display any decimal value.It will display only till whole number .\n\nex int a=567.1\n" +
                    "when we display it.It wil show only 567.");


        }
        else if(roll==7){
            setTitle("Calcualte Average");
            ques.append(" Accept marks of 3 Subjects and print it average");
            String code="#include<iostream.h>\n" +
                    "#include<conio.h>\n" +
                    "void main()\n" +
                    "{\n" +
                    "int eng,comp,math;\n" +
                    "float avg;\n" +
                    "cout<<\"\\n Please enter Marks for English\";\n" +
                    "cin>>eng;\n" +
                    "cout<<\"\\n Please enter Marks for Computer\";\n" +
                    "cin>>comp;\n" +
                    "cout<<\"\\n Please enter Marks for Maths\";\n" +
                    "cin>>math;\n" +
                    "avg=(eng+math+comp)/3;\n" +
                    "cout<<\"\\n The Average Marks is \"<<avg;\n" +
                    "}";
             codeView.showCode(code);
             exp.setText("Here ,we have taken 3 int type variables to store the marks of three subject and have taken variable 'avg' of type float because Average can be in decimal. So, for decimal values we use float data types," +
                     "\n\n\nRemember : Formula for Average is =(Sum of Marks of all three subjects )/total number of subjects");






        }
        else if(roll==8)
        { ques.append(" Accept a number and check whether it is greater than 10 or smaller than 10");
         setTitle("If Else Basic Program");
         String code="#include<iostream.h>\n" +
                 "void main()\n" +
                 "{int a; \n" +
                 " cout<<\"\\n Please enter any number\";\n" +
                 " cin>>a;\n" +
                 " if(a>10)\n" +
                 "   {\n" +
                 "     cout<<\"\\n Number is Greater than 10\";\n" +
                 "   }\n" +
                 " else\n" +
                 "   {\n" +
                 "     cout<<\"\\n Number is less than 10\";\n" +
                 "   }\n" +
                 "}";
         codeView.showCode(code);
         exp.setText("Here ,first we have accepted a number from used by using 'cin>>' command and stored it in Integer type variabe 'a'.\nAfter storing value in a,we have to compare 'a' whether it is smaller " +
                 "or greater than 10.\nIf you don't know about If-Else statement ,then you may study about it from Learn section of this App.\nWe have compared 'a' one time ,whether it is greater than 10 or not.If it will " +
                 "be greater than Message wil display 'Number is Greater than 10'.\nIf this condition id not true then it will display 'Numer is less than 10'.\n\nOutput:\n //Suppose user enter 9\nNumber is Smaller than 10  ");



        }
        else if(roll==9)
        {
            ques.append(" Accept two no and check which one is Greater");
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{\n" +
                    "  int a,b,gr_no;\n" +
                    "  cout<<\"\\n Please enter any two number\";\n" +
                    "  cin>>a>>b;\n" +
                    "  if(a>b)\n" +
                    "   { \n" +
                    "      gr_no=a;\n" +
                    "   }\n" +
                    "  else\n" +
                    "   {\n" +
                    "      gr_no=b; \n" +
                    "   }\n" +
                    "  cout<<\"\\n Greater nmber is \"<<gr_no;\n" +
                    "}";
            codeView.showCode(code);

            exp.setText("Here , First input two numbers by using 'cin>>' command and stored them in 'a' and 'b'.\nWe have taken another variable 'gr_no' in which we will store the value of greater no." +
                    "\n\nAfter this we have compared value of two variables using If else statement .If first condition will be true then value of a will be stored in gr_no otherwise if it is false then value of b wil be stored in gr_no." +
                    "\nTo copy the value of one variable to another we need to equate them by using an '=' sign.\n\nRemember :\nThe value of only right variable is coppied to the left variable.\nex-- a=b;  " +
                    "\\\\Here ,value of 'b' will be copied to 'a' .Value of 'a' will not be copied to 'b'.\n\n\nOutput :\n\\\\Suppose user enters 5 and 7" +
                    "\nGreater number is 7  ");
        }
        else if (roll==10)
        {
            ques.append(" Accept 5 numbers and check which one is Greater ");
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{\n" +
                    " int a,b,c,d,e,gr_no;\n" +
                    " cout<<\"\\n Please enter 5 number\";\n" +
                    " cin>>a>>b>>c>>d>>e;\n" +
                    " gr_no=a;\n" +
                    " if(b>gr_no)\n" +
                    "   {\n" +
                    "    gr_no=b;\n" +
                    "   }\n" +
                    " if(b>gr_no)\n" +
                    "   {\n" +
                    "    gr_no=b;\n" +
                    "   }\n" +
                    " if(c>gr_no)\n" +
                    "   {\n" +
                    "    gr_no=c;\n" +
                    "   }\n" +
                    " if(d>gr_no)\n" +
                    "   {\n" +
                    "    gr_no=d;\n" +
                    "   }\n" +
                    " if(e>gr_no)\n" +
                    "   {\n" +
                    "    gr_no=e;\n" +
                    "   }\n" +
                    "cout<<\"\\n Largest number is \"<<gr_no;\n" +
                    "}";
            codeView.showCode(code);
            setTitle("Comparing 5 Numbers");
            exp.setText("Here ,first we have  accepted 5 number from user by using 'cin' command and stored in 5 variables i.e., 'a','b','c','d' and 'e'." +
                    "\nNow ,we suppose the 'a' has the largest value. So we have copied the value of a into 'gr_no' variable for reference.\nNow ,for remaining 4 variables ,we have " +
                    "checked whether if its value is greater than 'gr_no' by using IF Statement.If this happens then ,value of that variable is copied into 'gr_no'.So, at the end of all IF Statement we will get the maximum value in 'gr_no' variable.After that we have displayed the" +
                    " value of 'gr_no' which will greater of all numbers entered  \n\nOutput :(Suppose user enters 2,4,6,8,4)\nLargest number is 8");
        }
        else if(roll==11)
        {
            setTitle("Even or Odd");
            ques.append(" Accept a no and check whether it is odd or even");
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{ \n" +
                    " int number,a;\n" +
                    " cout<<\"\\n Enter any number\";\n" +
                    " cin>>number;\n" +
                    " a=number%2;\n" +
                    " if(a==0){ \n" +
                    "    cout<<\"\\n Number is Even\";\n" +
                    "     }\n" +
                    "  else{\n" +
                    "   cout<<\"\\n Number is Odd\";\n" +
                    "    }\n" +
                    "}";
            codeView.showCode(code);
            exp.setText("To check a number whether is even or odd we have to divide it by 2 .If remainder is 0 then it is a even number otherwise it is odd." +
                    "In Programming to find out remainder, we use '%' sign.\nex-- a=number%2;\nSo,the remainder will be stored in a.So, finally we have to check whether 'a' is 0 or any other number/" +
                    "\nIf 'a' is 0 then number is even.\n\nRemember :\nTo compare two variable we use two '==' signs. Single '=' sign is just used to copy the value.\n\nOutput:(Suppose user enters 5)\n" +
                    "Number is Odd");

        }
        else if(roll==12)
        {
            setTitle("Loop Programming");
            ques.append(" Program to display numbers from 1 to 50");
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{ \n" +
                    " int number=1;\n" +
                    " while(number<=50)\n" +
                    "     { cout<<number;\n" +
                    "       number=number+1;\n" +
                    "      }\n" +
                    "}";
            codeView.showCode(code);
            exp.setText("Here ,we are using While loop to show the numbers from 1 to 50 because it is difficult a task to manually write code of each number.If you are unfamiliar with loop then goto " +
                    "learn section of this app and have a look at it. \n" +
                    "First we have taken a variabe 'number' with value 1.Taken the condition for while loop, that it will execute the same code till value of 'number' is less than" +
                    " or equal to 50.Each time we increase the value of 'number' by one.So, when value of 'number exede then loop stops and program is finished .\n\nOutput:\n1 2 3" +
                    " 4 5 6 7 8 9 10 11 12 13 14 16.............49 50");
        }
        else if(roll==13){
            setTitle("Loop Programming");
            ques.append(" Program to display numbers from 1 to 50 using FOR Loop");
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{\n" +
                    " for(int number=1;number<=50;number++)\n" +
                    "  {   cout<<number;}\n" +
                    "}";
            codeView.showCode(code);
            exp.setText("Here, we have used FOR loop to show the numbers from 1 to 50 ,if you want to see this program in while loop or do while then check the Program section of this App." +
                    "\nFOR loop make a lot of work easy because of its Syntax.In its Syntax it has 3 section ,one for counter variable declaration,one for condition and other for increament or decrement of counter variable." +
                    "To know more about FOR loop then head towards Learn Section.Here ,we have given counter variable 'number' of value 1 ,because we need to display the number from 1 to 50.\n" +
                    "In body of loop we have used 'cout' to display the value of 'number' each time loop is executed .Every time the value of 'number' is increased by one till it gets to 50, and each time " +
                    "it gets displayed .\n\nOutput :\n1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 ..... 49 50");
        }
        else if(roll==14){
            setTitle("Loop Programming");
            ques.append(" Program to display numbers from 1 to 50 using DO WHILE Loop");
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{\n" +
                    " int number=1;\n" +
                    "  do{\n" +
                    "     cout<<number<<endl;\n" +
                    "     number=number+1;\n" +
                    "    }while(n<=50);\n" +
                    "\n" +
                    "}";
            codeView.showCode(code);
            exp.setText("Here, we have used DO WHILE to do this this Program, head towards previous programs for better understanding of Loops.\nDo While is a same loop as While " +
                    "loop but the main difference is that, it checks the condition after execution of body of Loop whereas in While Loop, it checks condition before execution of Body of Loop.\n" +
                    "Due to this, every time if condition is true or false ,one time Body of loop is executed.\n\nRemember :\nHere, we have used 'endl' which might be new for you.\n" +
                    "'endl' is used to display the output in vertical order because it changes the line of cursor to the line.So, every time in loop line gets changed.\n\nOutput :\n1" +
                    "\n2\n3\n4\n5\n6\n7\n8\n.\n.\n.\n.\n49\n50");
        }
        else if(roll==15)
        {
            setTitle("8 to n");
            ques.append(" Display all the numbers from 8 to n");
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{\n" +
                    " int n;\n" +
                    " cout<<\"\\n Please enter value of n\";\n" +
                    " cin>>n;\n" +
                    " for(int number=8;number<=n;number++)\n" +
                    "   { cout<<number<<endl;}\n" +
                    "}";
            codeView.showCode(code);
            exp.setText("Here, we have used FOR loop for this, you may try this doing with Do While and While Loop.\nWe have taken a variable 'n' to take input from user and store" +
                    " in it. In for loop we have defined a variable 'number' as a counter variable of initial value 8 because we want to display numbers form 8 and taken conditon as loop will work till value of 'number' reach to n.Each time, value of 'number' will increase by one.\n\nOutput :(Suppose user enters 14)\n" +
                    "8\n9\n10\n11\n12\n13\n14");
        }
        else if(roll==16){
            setTitle("Even number from 8 to n");
            ques.append(" Display all even numbers from 8 to n");
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{\n" +
                    " int n,r;\n" +
                    " cout<<\"\\n Please enter value of n\";\n" +
                    " cin>>n;\n" +
                    " for(int number=1;number<=n;number++)\n" +
                    "   {  r=number%2;\n" +
                    "      if(r==0)\n" +
                    "      {cout<<number<<endl;}\n" +
                    "   }\n" +
                    "}";
            codeView.showCode(code);
            exp.setText(" To check whether a number is even or Odd, we need to divide it 2 ,if remainder is 0 then it is a even number otherwise it is a odd number.\n" +
                    "In Programming to calculate remainder we need to use '%' sign instead of '/' sign. ex-- r=number%2; (Here r has the remainder)\n" +
                    "In this program all things are same as previous program but here we need calculate a remainder in a variable 'r' to check whether it has value 0 or not.In body " +
                    "of loop we check whether value of r is 0, if it is zero then we display that number on screen .For checking we have used IF Statement .\nYou may try this program" +
                    " for odd numbers by yourself .\n\nOutput :(Suppose user enter 17)\n8\n10\n12\n14\n16");
        }
        else if(roll==17)
        {    setTitle("Table of a Number");
            ques.append(" Accept a number from user and display table of it");
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{\n" +
                    "  int n;\n" +
                    "  cout<<\"\\n PLease enter any number\";\n" +
                    "  cin>>n;\n" +
                    "  for(int i=1;i<=10;i++)\n" +
                    "  {cout<<n*i<<endl; }\n" +
                    "}";
            codeView.showCode(code);
            exp.setText(" Generally, we need to have tables till 10 times, so we are only displaying tables till 10 times.First we taken variable 'n' so that we can store the value that " +
                    "user enters.In for loop we have taken variable 'i' as a counter variable with value 1.Taken the conditon of loop as it will work till value of i does not touch 10.\n" +
                    "In body of For loop we have multiplied 'i' to the user enterd value 'n' so that it can result as a table. \nex (suppose i=2 n=4)\n4*2\n\nOutput :(Suppose user enter 4)\n" +
                    "4\n8\n12\n16\n20\n24\n28\n32\n36\n40   ");
        }
        else if(roll==18)
        {
           setTitle("Displaying Table");
           ques.append(" Accept a number and display its table if it is even");
           String code="#include<iostream.h>\n" +
                   "void main()\n" +
                   "{ int n;\n" +
                   "  cout<<\"\\n Please enter any number\";\n" +
                   "  cin>>n;\n" +
                   "  for(int i=1;i<=10;i++)\n" +
                   "    {    if(n%2==0)\n" +
                   "         {cout<<n*i<<endl;}\n" +
                   "         else\n" +
                   "         { cout<<\"\\n Number entered is Odd\";}\n" +
                   "    }\n" +
                   "}";
           codeView.showCode(code);
           exp.setText(" All things are similar from prevoius program but before displaying table we check the user entered number whether it is even or odd.\nIf it is even then we have displayed" +
                   " the table of it otherwise displayed that number is odd.\n\nOutput :(Suppose user enters 7)\n" +
                   "Number entered is Odd ");
        }
        else if(roll==19)
        {
            setTitle("Palindrome or not");
            ques.append(" Accept a number and check whether it a Palindrome or not");
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{ int n,h,p=0,a;\n" +
                    "  cout<<\"\\n Enter no\";\n" +
                    "  cin>>n;\n" +
                    "  h=n;\n" +
                    "  while(h>0){ a=h%10;\n" +
                    "              p=(p*10)+a;\n" +
                    "              h=h/10; }\n" +
                    "             \n" +
                    " if(h==p)\n" +
                    " {cout<<\"\\n Entered number is Palindrome\";}\n" +
                    " else\n" +
                    " {cout<<\"\\n Entered number is not Palindrome\";}\n" +
                    "}\n";
            codeView.showCode(code);
            exp.setText("Palindrome is a number which is same on reading from left to right and right to left. ex 454 is a Palindrome number.\n" +
                    "We have entered a number by user and stored in n. Copied the value of n to h, so that we compare to values afterwords.\nAfter this ,we will do all the modifications in h \n" +
                    "so that the actual entered value will not be changed and will be safely stored in n.Taken a while loop with condition such that it will work if value of h is greater than 0.\n" +
                    "In 'a' we calculate remainder by diving by 10.Then we copied this remainder in p with multiplying it by 10.Dividing h by 10 reduces its value .This is a little tricky thing, so try to imagine .\n" +
                    "Suppose entered value is 66 so, value of h will also be 66.\n" +
                    "In first loop 'a' will be 6 because it calculates remainder .Value of P is initially 0 so after multiplying it by 10 will not change it and then added a.So value of p will be 6.\n" +
                    "Now, value of h will reduce 6 because h  is of integer type variable and will not take decimal values.\n" +
                    "Value of h is now 6 and still loop can work according to condition so, loop will work once again.Now, value of 'a' will 6 .We add this to p by multiplying it with 10 .Now , value of p will be 66.Value " +
                    "of h will now gets 0 because if we divide 6 by 10 then it will be some about 0.6 but h will only take 0." +
                    "\n Now, see the entered value and value of P, they both are same .Now we compare it and display the result.\nn\nOutput :(Suppose user enters 343)\n Entered number is Palindrome ");
        }
        else if(roll==20){
            setTitle("Prime, even, Odd");
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{ int n,f=0;\n" +
                    "  cout<<\"\\n PLease enter any number\";\n" +
                    "  cin>>n;\n" +
                    "  if(n==2)\n" +
                    "  {cout<<\"\\n No is Prime Odd\";}\n" +
                    "  else if(n%2==0)\n" +
                    "  { cout<<\"\\n Number is Even\";}\n" +
                    "  else\n" +
                    "  {\n" +
                    "    for(int i=2;i<n;i++)\n" +
                    "    {if(n%i==0)\n" +
                    "       {f=1;\n" +
                    "        break;}\n" +
                    "     }\n" +
                    "   }\n" +
                    "  if(f==0)\n" +
                    "   {cout<<\\n \"Number is Prime and Odd\";}\n" +
                    "  else if(f==1)\n" +
                    "   {cout<<\"\\n Number is Odd\";}\n" +
                    "}\n";
            ques.append(" Accept a number and check whether it is Prime, even or Odd");
            codeView.showCode(code);
            exp.setText(" 2 is a only number which is Prime as well Even, so we have taken special case of it.To check even numbers, its remainder should be zero when we divide it by 2.\n" +
                    "To check whether a number is Prime and odd, then we need to divide it by all numbers from 2 to that number.If in between its remainder becomes zero then it is a Odd otherwise " +
                    "it is a Prime and Odd number");
        }
        else if(roll==21){
            setTitle("Simple Interest");
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{ int p;\n" +
                    " float r,t,SI,amount; \n" +
                    " cout<<\"\\n Please enter the Principal amount\";\n" +
                    " cin>>p;\n" +
                    " cout<<\"\\n Enter the rate \";\n" +
                    " cin>>r;\n" +
                    " cout<<\"\\n PLease enter time (in Years)\";\n" +
                    " cin>>t;\n" +
                    " SI=(p*r*t)/100;\n" +
                    " amount=p+SI;\n" +
                    " cout<<\"\\n Interest for \"<<p<<\"will be Rs\"<<SI;\n" +
                    " cout<<\"\\nTotal Payable Amount is\"<<amount\";\n" +
                    "}";
            codeView.showCode(code);
            exp.setText("Formula to calculate Simple Interest is (Principal*Rate*Time)/100. We have taken floating type variables because rate, time ,SI and amount can in decimal format." +
                    "\nAccepted Principal amount, time and rate from user by using 'cin' command.Then we placed formula equal to SI, so that it can calculate the SI and store in it.\nTo calculate " +
                    "total amount we have to add Principal amount to Principal Amount.\n\nOutput :(Suppose user enters Principal as 10000, rate as 5 and time as 2)\nInterest for 10000 will be Rs 1000\nTotal amount is 11000");
            ques.append(" A Program to calculate Simple Interest");
        }
        else if(roll==22){
            setTitle("Calculate Percentage");
            ques.append(" Accept marks of 5 Subject and print Percentage and give Remarks");
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{ int eng,hindi,maths,computer,social;\n" +
                    "  float per;\n" +
                    "  cout<<\"\\n Please enter marks of English\";\n" +
                    "  cin>>eng;\n" +
                    "  cout<<\"\\n Please enter marks of Hindi\";\n" +
                    "  cin>>hindi;\n" +
                    "  cout<<\"\\n Please enter marks of Maths\";\n" +
                    "  cin>>maths;\n" +
                    "  cout<<\"\\n Please enter marks of Social\";\n" +
                    "  cin>>social;\n" +
                    "  cout<<\"\\n Please enter marks of Computer\";\n" +
                    "  cin>>computer;\n" +
                    "  per=(eng+maths+hindi+social+computer)*100/500;\n" +
                    "  cout<<\"\\n Your Percentage is \"<<per<<\" %\";\n" +
                    "  if(per<50)\n" +
                    "   {cout<<\"\\n You need to do HardWork\";}\n" +
                    "  else if(per>50 && per<75)\n" +
                    "   {cout<<\"\\n Need to do more hardwork\";}\n" +
                    "  else if(per>75)\n" +
                    "  {cout<<\"\\n Excellent! keep up the Good Work\";}\n" +
                    "}";
            codeView.showCode(code);
            exp.setText(" To Accept marks of each we have taken variables of Integer type but for Percentage we have taken variable of Float type because Percentage can be in decimal.\n" +
                    "Accept Marks of 5 subjects by using 'cin' command.\n\nRemember : Formula for calculating Percentage is Total Marks (Obtained /Sum of Maximum Marks)*100 \n" +
                    "To give remarks we have used IF Else statement.It will give remark, according to Percentage Obtained.\n\nOutput :(Suppose user enters 56,37,57,45 & 67)\n" +
                    "Your Percentage is 52.4 %\nNeed to do More Hardwork");
        }
        else if(roll==23){
            setTitle("LCM");
            ques.append(" Accept two number and find LCM of it");
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{\n" +
                    " int n1,n2,max;\n" +
                    " cout<<\"\\n Please enter two numbers\";\n" +
                    " cin>>n1,n2;\n" +
                    " if(n1>n2)\n" +
                    "      {max=n1;}\n" +
                    " else\n" +
                    "      {max=n2;}\n" +
                    " while(1){\n" +
                    "          if((max%n1==0) && (max%n2==0))\n" +
                    "           {cout<<\"\\n LCM is \"<<max;\n" +
                    "            break;}\n" +
                    "           max=max+1;\n" +
                    "         }\n" +
                    "}";
            codeView.showCode(code);
            exp.setText(" LCM full form is least common factor meaning least number which can divide the two numbers completly without leaving remainder." +
                    "We have taken 3 variables, two for storing numbers and one for storing max number.Accepted 2 numbers from user by using 'cin' commmand.By using IF Else statement we checked " +
                    "which one is greater, and copy that number into 'max' variable.We have taken an unstoppable loop by taking condition as, it will work till 1 exist and it will exist forever.\n" +
                    "By using IF statement, we checked that max is completly dividing n1 and n2 .If it is dividing then 'max' is LCM .We have used break so that when this condition is arrises then loop gets over. If " +
                    "this condition is not true then we increase the value of 'max' by one .\n\nOutput :(Suppose user enters 3 and 9 )\nLCM is 9   ");
        }
        else if(roll==24){
            setTitle(" Sum of Natural Numbers");
            ques.append(" Display sum of all numbers upto n");
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{\n" +
                    "  double sum;\n" +
                    "  int n;\n" +
                    "  cout<<\"\\n Please enter number till where you want the sum\";\n" +
                    "  cin>>n;\n" +
                    "  for(int i=1;i<=n;i++)\n" +
                    "   {sum=sum+i;}\n" +
                    " cout<<\"\\n Sum is \"<<sum;\n" +
                    "}";
            codeView.showCode(code);
            exp.setText("To calculate sum we need to add all numbers from 1 to n. We have taken a variable 'sum' to store sum of type double because sum can be too large and Integer type variale cannot hold it.\n" +
                    "Taken a variable 'n' to accept a number from user .Here ,we have taken FOR loop with variable i=1 as counter variable.Taken the condition as, loop will work till value of 'i' touches 'n'." +
                    "\nIn every loop we added 'i' value to 'sum' variable.After loop, we get sum in 'sum' then display the value of 'sum' \n\n" +
                    "Output :(Suppose user enters 7)\n Sum is 28");
        }
        else if(roll==25){
            setTitle("Factorial");
            ques.append(" Accept a number and show factorial of it");
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{ int num;\n" +
                    "  double fact=1;\n" +
                    "  cout<<\"\\n Please enter any number\";\n" +
                    "  cin>>number;\n" +
                    "  for(int i=1;i<=num;i++)\n" +
                    "   {fact=fact*i;}\n" +
                    "  cout<<\"\\n Factorial is \"<<fact;\n" +
                    "}\n";
            codeView.showCode(code);
            exp.setText("Factorial of number means multipling that number with all number which below it .ex factorial of 4 is 4*3*2*1=24 .We have taken one variable 'fact' of value one because " +
                    "if we take its value as 0 then it will make all the numbers zero, which will get multiplied with it.Accepted a number from user and stored in 'num'.Taken a for loop and give the condition as it will work til counter variable reaches value of 'num'." +
                    "In every time it is getting multiplied with counter variable and store in variable 'fact'.After this display the value of fact\n\nOutput :(User enters 5)\nFactorial is 120");

        }
        else if(roll==26)
        {setTitle("Accepting a Characters and Displaying it");
            ques.append(" Accept a character from user and display it on Screen");
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{ char a; //It will store only one character\n" +
                    "  cin>>a;\n" +
                    "  cout<<\"\\n Entered characters are \"<<a;\n" +
                    "}";
            codeView.showCode(code);
            exp.setText("This program is same as displaying Accepting a number from user and displaying it. The difference between this program is that, here we have to take variable" +
                    " of type 'Char' so that they can hold Character data .\n\nRemember :" +
                    "To store more characters than one, then you need to specify the length of Char variable. By default its length is one." +
                    "\n\nOutput :(Suppose user enters HayatSoft)" +
                    "\nEntered character is H");




        }
        else if(roll==27){
            setTitle("Accepting a Word from user");
            ques.append(" Accept a word from user and display it on Screen ");
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{ char a[10]; //It will store only one character\n" +
                    "  cin>>a;\n" +
                    "  cout<<\"\\n Entered word is \"<<a;\n" +
                    "}";
            codeView.showCode(code);
            exp.setText("The basic difference between this program and Previous Program is that, here we need to specify the length of Char variable. For reference here we have 10 because no word " +
                    "will be larger than 10.\n\nRemember : Using 'cin' command for accepting numbers from user will only store variables till space comes. It will not store any data after the space.\n\nOutput :" +
                    "(Suppose user enters hayatsoft is made by Maawan Ahmad)\n" +
                    "Enterd word is hayatsoft");
        }else if(roll==28){
            setTitle(" Accepting Sentence from User");
            ques.append("Accept Sentence from user and display it on Screen");
            String code="#include<iostream.h>\n" +
                    "#include<stdio.h>\n" +
                    "void main()\n" +
                    "{ char a[100];\n" +
                    "  cout<<\"\\n Please enter any Sentence\"; \n" +
                    "  gets(a); //This will input characters upto 100\n" +
                    "  cout<<\"\\n Entered Sentence is \"<<a;\n" +
                    "}";
            codeView.showCode(code);
            exp.setText(" Here,we have taken the length a character variable as 100 because no Sentence will be larger than this. This depends on your choice you may increase or increase" +
                    " it.gets will help to input full Sentence with Spaces unlike 'cin' command. After storing we have displayed it on Screen.\n\nOutput :(Suppose user enters Easy or West" +
                    " hayatsoft is the best)\nEntered Sentence is East or West hayatsoft is the best");

        }
        else if(roll==29){
            setTitle("Using fuction");
            ques.append(" Accept length and breadth and find the area using Function");
            String code="#include<iostream.h>\n" +
                    "void area(int a,int b)   // function with two parameters\n" +
                    " {\n" +
                    "  cout<<\"\\n Area is \"<<a*b;\n" +
                    " }\n" +
                    "void main()\n" +
                    " { int l,b;\n" +
                    "   cout<<\"\\n Enter length\";\n" +
                    "   cin>>l;\n" +
                    "   cout<<\"\\n Enter Breadth\";\n" +
                    "   cin>>b;\n" +
                    "   area(l,b);   //using function\n" +
                    " }\n" +
                    "\n";
            codeView.showCode(code);
            exp.setText(" If you are unaware of functions then goto Learn section of this app. Here, we have defined a function 'area' with two integer type Parameters which will carry " +
                    "length and breadth. Inside the function we have multiplied both the parameters for the area and displayed into screen. In main part we have accepted two value i.e., length and breadth " +
                    "by using 'cin' command .Afterwords we have passed the variables in the function so that its value would reflect in the variables of function 'a' and 'b'\n\nOutput :(Suppose user enters 2 4)\nArea is 8 ");
        }
        else if(roll==30){
            setTitle("Function");
            ques.append(" Display your details using function");
            String code="#include<iostream.h>\n" +
                    "void show_details()\n" +
                    " {\n" +
                    "  cout<<\"\\n My Name is Maawan Ahmad\";\n" +
                    "  cout<<\"\\n App name is C++ Basics Learning\";\n" +
                    " }\n" +
                    "void main()\n" +
                    " { \n" +
                    "    show_details();\n" +
                    " }\n" +
                    "\n";
            codeView.showCode(code);
            exp.setText("Here, we have created a function 'show_details' which will show details which are inside the function. This function does not have any Parameter because we not " +
                    "dealing with variables and calculations.The main work of this function is to display some details on the Screen. This type of Program is not useful and is only Show to make you clear about " +
                    "the Parameters\n\nOutput :\nMy Name is Maawan Ahmad\nApp name is C++ Baiscs Learning");
        }
        else if(roll==31) {
            setTitle("Simple Interest (Function)");
            ques.append(" Calculate Simple Interest using Function or Modular Programming");
            String code = "#include<iostream.h>\n" +
                    "#include<conio.>\n" +
                    "void interest(int p,float r,float t)\n" +
                    "{ float SI,amount;\n" +
                    "  SI=(p*r*t)/100;\n" +
                    "  amount=SI+p;\n" +
                    "  cout<<\"\\n Interest to be Paid \"<< SI;\n" +
                    "  cout<<\"\\n Total Amount to be paid\"<< amount;\n" +
                    "}\n" +
                    "void main()\n" +
                    "{ int pri;\n" +
                    "  float rate,time;\n" +
                    "  cout<<\"\\n Enter Principal Amount\";\n" +
                    "  cin>>pri;\n" +
                    "  cout<<\"\\n Enter Time Period\";\n" +
                    "  cin>>time;\n" +
                    "  cout<<\"\\n Enter Rate \";\n" +
                    "  cin>>rate;\n" +
                    "  interest(pri,rate,time);\n" +
                    "} ";
            codeView.showCode(code);
            exp.setText("Output :(Suppose user enters 12000 for 2 years at rate of 5%)\n Interest to be Paid 1200\n Total Amount to be Paid 13200\n\nExplanation :\n" +
                    "Here, we have created a function named interest with 3 parameters for principal , rate and time.When we call the function in main part, then by the help of Parameters all the value reach to the function and get " +
                    "executed.");
        }
        else if(roll==32)
        {setTitle("Swap two numbers");
          ques.append(" Accept two numbers and Swap them");
          String code="#include<iostream.h>\n" +
                  "#include<conio.h>\n" +
                  "void main()\n" +
                  "{ int fir,sec,temp;\n" +
                  "  cout<<\"\\n Enter First number\";\n" +
                  "  cin>>fir;\n" +
                  "  cout<<\"\\n Enter Second number\";\n" +
                  "  cin>>sec;\n" +
                  "   temp=fir;\n" +
                  "   fir=sec;\n" +
                  "   sec=temp;\n" +
                  "  cout<<\"\\n After Swapping :\";\n" +
                  "  cout<<\"\\n First Number :\"<<fir;\n" +
                  "  cout<<\"\\n Second Number :\"<<sec;\n" +
                  "  getch();\n" +
                  "}";
          codeView.showCode(code);
          exp.setText(" Output :\n Enter First number \n 4\n Enter Second number\n 7\n After Swapping :\n First Number : 7\n Second number :4" +
                  "\n\nExplanation :\n Here, we have used 3 int type variable to store 2 number and one 'temp' variable is used for storing data for temporary purpose\n First, we have taken 2 values from" +
                  " user then have copied first value into 'temp' variable . Now , we have copied 2 variable's value into first and then copied 'temp' value to Second variable. After doing all this we have displayed result on the screen");


        }
    }
    public void loaddata(){
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREF,MODE_PRIVATE);
        a=sharedPreferences.getInt(VALUE,0);


    }
    public void savedata(){
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREF,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt(VALUE,a);
        editor.apply();

    }

}
