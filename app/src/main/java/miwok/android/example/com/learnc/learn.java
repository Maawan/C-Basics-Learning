package miwok.android.example.com.learnc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Random;

import thereisnospon.codeview.CodeView;
import thereisnospon.codeview.CodeViewTheme;
;

public class learn extends AppCompatActivity {
    int b,a=0;


    CodeView codeView;
    private InterstitialAd mInterstitialAd;
    String code;
    public static final String SHARED_PREFS="sharedPrefs";
    public static final String TEXT="text";
    public static final int INT=1;
    TextView title,ans,output,out;
    ImageView image;int roll;

    @Override
    public void onBackPressed() {
      loaddata();
      b=a%2;
      a++;
      savedata();
      if(b==0){
          if(mInterstitialAd.isLoaded())
          {mInterstitialAd.show();
              mInterstitialAd.setAdListener(new AdListener() {
                  @Override
                  public void onAdClosed() {
                      super.onAdClosed();
                      learn.super.onBackPressed();
                  }
              });

          }
          else{super.onBackPressed();}
      }
      else{super.onBackPressed();}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        title=(TextView)findViewById(R.id.title);
        ans=(TextView)findViewById(R.id.ans);
        output=(TextView)findViewById(R.id.output);
        out=(TextView)findViewById(R.id.out);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-5627293645158234/6640091784");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        AdView mAdView = (AdView)findViewById(R.id.adView1);
        AdRequest.Builder adRequestBuilder = new AdRequest.Builder();
        mAdView.loadAd(adRequestBuilder.build());
        codeView=(CodeView)findViewById(R.id.codeview);
        codeView.setTheme(CodeViewTheme.ANDROIDSTUDIO).fillColor();
        image=(ImageView)findViewById(R.id.image);


        Intent intent = getIntent();
        if (intent!=null) {
            roll= intent.getIntExtra("Roll",2000);
            }

        if(roll==101)
        {
        setTitle("Introduction to C++");
        title.setText("What is C++ ? How can we start coding in it");
        ans.setText("The C++ programming language was developed at AT and T Bell Laboratories in the early 1980s by Bjarne Stroustrup . He found 'C' lacking for simulations and decided to extend the language by adding features from his favorite language, Simula 67 . After adding these improvements, C language was named C++.\nThe name C++ was given because in programming language when we want to increase the value of any variable by unity then we write two ++ in front it .ex--a++.That why after improvements in C it is named as C++." +
                "\n\nTo start coding in C++ these things will be needed :-" +
                "\n ->  A laptop/Desktop with any version of Windows " +
                "\n ->  Turbo C++ software installed in it\n" +
                "\nAfter this you just need to know C++ to start coding and which you can learn here .A number of C++ Program are given in Program Section of this App  ");
        out.setVisibility(View.GONE);
       // codeView.setVisibility(View.GONE);
        code="#include<iostream.h>\n" +
                "#include<conio.h>\n" +
                "void main()\n" +
                "{\n" +
                "cout<<\"Hello World\";\n" +
                "}";
        image.setImageResource(R.drawable.c_fr);
        //output.setText("Hello World");

        //codeView.showCode(code);
    }else if(roll==102){
            setTitle("Variables");
            title.setText("What are Variables ?");
            ans.setText("Variables are used to store information to be referenced and manipulated in a computer program. They also provide a way of labeling data with a descriptive name, so our programs can be understood more clearly by the reader and ourselves. It is helpful to think of variables as containers that hold information" +
                    ".\n\n Their sole purpose is to label and store data in memory. This data can then be used throughout your program.");
            image.setImageResource(R.drawable.vari);
            out.setText("Here, 'a' is a Variable which stores value of 500");

        }
        else if(roll==103){
            setTitle("Identifier");
            title.setText("What are Identifier ?");
            ans.setText("Identifier is a User Defined name given to a part of a Program i.e., variable,object,function etc.\nIdentifier are not reserved .They are defined by the user and can have letters ,digits and a symbol underscore ");
            String code="#include<iostream.h>\n" +
                    "#include<conio.h>\n" +
                    "void abc()\n" +
                    "{\n" +
                    "cout<<a+a;\n" +
                    "}\n" +
                    "void main()\n" +
                    "{\n" +
                    "int a=500;\n" +
                    "}";
            codeView.showCode(code);
            image.setVisibility(View.GONE);
            out.setTextSize(15);
            out.setText("Here, 'abc' and 'a' are Identifiers .abc is a name of function which you will study later on & a is a variable");

        }
        else if(roll==104){
            setTitle("Data Type");
            title.setText("What is Data Type ? How many are the type of it .");
            ans.setText("A data type, in programming, is a classification that specifies which type of value a variable has and what type of mathematical, relational or logical operations can be applied to it without causing any error. \nA char (character), for example, is a data type that is used to classify text and\n An int (Integer) is a data type used to classify whole numbers.\nThere are two types of Data Type \n" +
                    "Primitive and User Defined Data types.But now we will only study about Primitive data types.\n" +
                    "These are those data types which are already declared in language itself.\n\n" +
                    "->Integer Type :\nThis is a data type to store Integer type value i.e., any integer value without decimal .The memory Size of Integer Type variable is 2 bytes.\nex-int a=5;\n\n" +
                    "->Floating Type :\nThis is a data type to store decimal kind of value .The memory size of Floating type variabe is 4 bytes.\nex float a=54.56;\n\n" +
                    "->Double type:\nThis is a data type to store long decimal values.Its memory is twice than float and 4th times of int type which is 8 bytes.\nEx double a=6773786783.8373;\n\n" +
                    "->Character type:\nThis is a data type to store Alphabetical Charcter.By default it stores only one character but we can expand it by giving the required no of length infront of it .This creates a Array of characters which act as a Word/phrase .For character constant its memory is 1 byte but on creating Array of characters it size increases.   \nEx char a='l'; Here, size of a is 1 byte ,\nchar b[4]='love'; Here, size of b is 4 bytes   " );
            String code="#include<iostream.h>\n" +
                    "#include<conio.h>\n" +
                    "void main()\n" +
                    "{\n" +
                    "int a=5;            //Integer Type\n" +
                    "float b=67.70;          //Float Type\n" +
                    "double c=754747.3434;    //Double type\n" +
                    "char d='l';             //Character Constant\n" +
                    "char s[4]='love';  //Character Array Type\n" +
                    "}";
            codeView.showCode(code);
            image.setVisibility(View.GONE);
            out.setVisibility(View.GONE);


        }
        else if(roll==105){
            setTitle("void main( )");
            title.setText("What is main part of Program and why it is so important");
            ans.setText("Main part is basically a prefedined function in C++ from where the C++ compiler starts to execute the program line by line.It is important because from here only execution of program starts and if this won't be there then your program can't run.");
            String code="#include<iostream.h>\n" +
                    "#include<conio.h>\n" +
                    "void main()\n" +
                    "{\n" +
                    "cout<<\"\\n The above void main is called main part .And this statement is written under the main part\";\n" +
                    "}";
            image.setVisibility(View.GONE);
            codeView.showCode(code);
            out.setVisibility(View.GONE);




        }
        else if(roll==108){
            setTitle("If-Else");
            title.setText("What is If-Else statement ?");
            ans.setText("If-Else statement is a statement which is used in decision making Programing. It executes one block of code when condition is true, executes another block of code when codition is false.\n" +
                    "It is not necessary to use both If and Else statements, we may use only if also .");
            String code="#include<iostream.h>\n" +
                    "#include<conio.h>\n" +
                    "void main()\n" +
                    "{\n" +
                    "int a=5;\n" +
                    "if(a>4)\n" +
                    "    {\n" +
                    "     cout<<\"\\n Number is Greater than 4\";\n" +
                    "    }\n" +
                    "else\n" +
                    "   {\n" +
                    "    cout<<\"\\n Number is less than 4\";\n" +
                    "   } \n" +
                    "\n" +
                    "}";
            image.setVisibility(View.GONE);
            codeView.showCode(code);
            output.setText("Number is Greater then 4");



        }
        else if(roll==107){
            setTitle("Keywords");
            title.setText("What are Keywords ?");
            ans.setText("Keywords are reserved words in a language and which cannot be used to name any variable ,function,class etc." +
                    "Writing any keyword changes its colour from default to white which indicates that it is a keyword and cannot be used for naming purposes." +
                    "\nThis concept of keywords is applicable for all languages but the reserved words can be different according to that language." +
                    "\n\nList of some keywords are given below :-");
            image.setImageResource(R.drawable.keywords);
            //Toast.makeText(context, "Roll no Id is "+currentheading.getInt(), Toast.LENGTH_SHORT).show();
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1 =new Intent(learn.this,image.class).putExtra("Roll",roll);

                    startActivity(intent1);
                }
            });

            out.setVisibility(View.GONE);

        }
        else if(roll==106){
            setTitle("Relational Operators");
            title.setText("What are Relational Operators ?");
            ans.setText("In C++, to compare two variables value we need to use Relational Operators.\n\nThere are " +
                    "6 type of Relational Operators.\n--> '>' Greater than\n--> '>=' Greater than or equal to\n--> '==' is equal to" +
                    "\n--> '!=' is not equal to\n--> '<' less than\n--> '<=' less than or equal to\n\nExample of each is given below");
            image.setImageResource(R.drawable.operators);
            String code="#include<iostream.h>\n" +
                    "#include<conio.h>\n" +
                    "void main()\n" +
                    "{int a=5;\n" +
                    "   if(a>10)\n" +
                    "     {cout<<\"Number is Greater than 10\";}\n" +
                    "   if(a>=10)\n" +
                    "     {cout<<\"Number is Greater than 10 or equal to 10\";}\n" +
                    "   if(a==10)\n" +
                    "     {cout<<\"Number is 10\";}\n" +
                    "   if(!a=10)\n" +
                    "     {cout<<\"Number is not equal to 10\";}\n" +
                    "   if(a<10)\n" +
                    "     {cout<<\"Number is less than 10\";}\n" +
                    "   if(a<=10)\n" +
                    "     {cout<<Number is less than 10 or equal to 10\";}\n" +
                    "}";
            codeView.showCode(code);
            out.setVisibility(View.GONE);

        }
        else if(roll==109)
        {
            setTitle("Loops");
            title.setText("What is loop ? ");
            ans.setText("Loop is a condition in Programming in which compiler reads a particular line or group of lines many times until any specific condition is not fulfilled." +
                    "\nA Basic Flowchart is given below for Basic understanding.  ");
            image.setImageResource(R.drawable.loop);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1 =new Intent(learn.this,image.class).putExtra("Roll",roll);

                    startActivity(intent1);
                }
            });
            out.setVisibility(View.GONE);
        }
        else if(roll==110)
        {
            setTitle("Types of Loops");
            title.setText(" Types of Loops in C++ ?");
            ans.setText(" In C++ there are three Types of Loops.\n\n--> While Loops-- It Executes a given line or group of lines until the condition is true.\n\n--> For Loop-- " +
                    "for loops are counter-controlled, meaning that they are normally used whenever the number of iterations is known in advance.\n\n" +
                    "--> Do While Loop-- This loop is same as While loop but it check the condition at the end, but while loop check the condition first before executing the body of loop." +
                    " So, if condition is false also then in Do While, one time code is executed.");
            image.setImageResource(R.drawable.types_loops);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1 =new Intent(learn.this,image.class).putExtra("Roll",roll);

                    startActivity(intent1);
                }
            });
            out.setVisibility(View.GONE);
        }
        else if(roll==111)
        {
            setTitle("Do While Loop");
            title.setText("Do While Loop ");
            ans.setText("Do While Loop is a loop which checks the condition after the execution of code .Due to this, if condition is false then also ,one time code is executed.\nA Basic flowchart and Program " +
                    "of Do While loop is given Below ");
            image.setImageResource(R.drawable.do_flowchart);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1 =new Intent(learn.this,image.class).putExtra("Roll",roll);

                    startActivity(intent1);
                }
            });
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{\n" +
                    " int number=1;\n" +
                    "  do{ \n" +
                    "      cout<<\"\\n No is\"<<number;\n" +
                    "      number=number+1\n" +
                    "     }while(number<5);\n" +
                    "}";
            codeView.showCode(code);
            output.setText("No is 1\nNo is 2\nNo is 3\nNo is 4");


        }
        else if (roll==112)
        {
            setTitle("For Loop");
            title.setText("For Loops");
            ans.setText("for loops are counter-controlled, meaning that they are normally used whenever the number of iterations is known in advance.In its syntax ,it has special place for " +
                    "increament variable and its initial value.");
            image.setImageResource(R.drawable.forloop);
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{\n" +
                    " for(int number=1;number<5;number++)\n" +
                    "  {\n" +
                    "       cout<<\"\\n No is<<number; \" \n" +
                    "  }\n" +
                    "}";
            codeView.showCode(code);
            output.setText("No is 1\nNo is 2\nNo is 3\nNo is 4");
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1 =new Intent(learn.this,image.class).putExtra("Roll",roll);

                    startActivity(intent1);
                }
            });
        }
        else if(roll==113)
        {
            setTitle("While Loop");
            title.setText("While Loop");
            ans.setText("While Loop is a loop in which condition is checked before the execution of Body of Loop.Do While and while are same loop but the main difference is that," +
                    "in Do while it checks the condtion at the end but whereas in While loop it checks condition at first.A Basic flowchart is given below.");
            image.setImageResource(R.drawable.whiel);
            output.setText("No is 1\nNo is 2\nNo is 3\nNo is 4");
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1 =new Intent(learn.this,image.class).putExtra("Roll",roll);

                    startActivity(intent1);
                }
            });
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{\n" +
                    " int number=1;\n" +
                    " while{ cout<<\"\\n No is\"<<number;\n" +
                    "        number=number+1;\n" +
                    "      }\n" +
                    "}";
            codeView.showCode(code);
            output.setText("No is 1\nNo is 2\nNo is 3\nNo is 4");
        }
        else if(roll==114)
        {
            setTitle("Nested Loops");
            title.setText(" What are Nested loops ?");
            ans.setText("Nested Loop is a situation in which one loop is inside the other loop.\nThe placement of one loop inside the body of another loop is called Nesting of loops.  Is it not necessary that only two loops may be nested .There may be number of loops nested, it depends on Programmer that how many loops he wants." +
                    "We can Nest any Inner loop i.e., it can be for loop ,While Loop or Do While loop ,inside any outer loop.A Basic flowchart is given for understanding basic concept of Nesting  ");
            image.setImageResource(R.drawable.while_loop);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1 =new Intent(learn.this,image.class).putExtra("Roll",roll);

                    startActivity(intent1);
                }
            });
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{ int number=1;\n" +
                    " for(int x=1;x<=5;x++)\n" +
                    "  {\n" +
                    "   while(number<=5){\n" +
                    "                     cout<<\"\\n No is\"<<number;\n" +
                    "                     number=number+1;                   \n" +
                    "                   }              \n" +
                    "  }\n" +
                    "}";
            codeView.showCode(code);
            output.setText("No is 1\nNo is 2\nNo is 3\nNo is 4\nNo is 5");
        }
        else if (roll==115){
            title.setText("What are Literals ?");
            ans.setText("A literal is a value that is expressed as itself. For example, the number 25 or the string \"Hello World\" are both literals.");
            image.setImageResource(R.drawable.literal_exp);
            out.setVisibility(View.GONE);
            image.setImageResource(R.drawable.literal_exp);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1 =new Intent(learn.this,image.class).putExtra("Roll",roll);

                    startActivity(intent1);
                }
            });
        }
        else if(roll==116){
            setTitle("Compiler and Interpreter");
            title.setText(" What is compiler and Interpreter ?");
            ans.setText(" We generally write a computer program using a high-level language. A high-level language is one which is understandable by us humans. It contains words and phrases from the English (or other) language.\n" +
                    "Our Computers cannot understand this language, it can only understand 0's and 1's.The code which we write in Programming Language(high-level language) is called Source Code. To convert this Source code into Computer" +
                    " understandable language i.e., 0's and 1's, Compiler and Interpreters are used. The main work of Compiler and Interpreter is to convert Source code into Machine Language.\n\n" +
                    "Compiler--> Translates whole Souce code into Machine language in one go and gives errors at the end\n\nInterpreter--> Translates Source code line by line and gives the error when first error is met. Hence, debugging " +
                    "is easy in Interpreter.");
            out.setVisibility(View.GONE);
        }
        else if(roll==117){
            setTitle("Switch");
            title.setText("What is Switch and why it is used ?");
            ans.setText("A Switch is a statement which is used when a variable is compared to several values." +
                    " Switch case statements are a substitute for long if statements that compare a variable to several integral values. Switch cases have special default case which is quite similar to else case in IF ELSE statement.When any case does not matches, then default case gets " +
                    "executed.\nRemember : Unlike IF Else statement, break is used in Switch so that if any case matches then it will stop the switch and continue the program.");
            image.setImageResource(R.drawable.cswitch);

            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1 =new Intent(learn.this,image.class).putExtra("Roll",roll);

                    startActivity(intent1);
                }
            });
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{ int a;\n" +
                    " cout<<\"\\n Please enter any Number\";\n" +
                    " cin>>a;\n" +
                    " switch(a)\n" +
                    "  {\n" +
                    "   case 1:cout<<\"\\n Value of a is 1\";\n" +
                    "\n" +
                    "   case 2:cout<<\"\\n Value of a is 2\";\n" +
                    "   \n" +
                    "   case 3:cout<<\"\\nValue of a is 3\";\n" +
                    "  \n" +
                    "   default:cout<<\"\\n Value of a is greater 3\";\n" +
                    "  }\n" +
                    "}";
            codeView.showCode(code);
            output.setText("(Suppose value is a is 2)\nValue of a is 2\n\n(Suppose value of a is either than 1,2,and 3)\nValue of a is greater than 3");
        }
        else if(roll==118){
            setTitle(" Break and Continue ");
            title.setText(" What are Break and Continue Statements ?");
            ans.setText("Break is a statement which is predefined in C++ and is used to break the loop or switch i.e., when break is read by the compiler then it comes " +
                    "out of loop or Switch and do not preform any futhur task with loop or Switch.\nContinue is also a statement in C++ which is predefined and is used when " +
                    "we do not want to execute the code of loop for certain iteration, after this compiler jump for next iteration and continues the loop. It is generally used in Loops not in Switches");
            String code="#include<iostream.h>\n" +
                    "void main()\n" +
                    "{\n" +
                    " for(int i=1;i<=10000;i++)\n" +
                    " {  if(i==5)\n" +
                    "      {continue;}\n" +
                    "     else if(i==8)\n" +
                    "      {break;}\n" +
                    "   cout<<i;\n" +
                    " } \n" +
                    "}";
            image.setImageResource(R.drawable.break1);
            codeView.showCode(code);
            out.setText("Output :\n123467\n\nExplanation :");
            output.setText("Here , we have used both the statements .When value of 'i' will be equal to 5 then it will not execute the rest of the code and will continue its loop work." +
                    "\nDue to this 5 will not be displayed be displayed .\nThis loop is meant to displat numbers from 1 to 10000 but when value of 'i' will be equal to 8 then loop will break and no loop work will " +
                    "be done after words.So it will display numbers 1 to 8 but not display 5 due to 'continue' statement ");
        }
        else if(roll==119){
            setTitle("Procedural and Modular Programming");
            title.setText("What is Procedural Programming and Modular Programming ?");
            ans.setText("Procedural Programming :\n\nProcedural Programming is a programming technique which follow top to bottom approach. In this kind a Programmer have to write code on the bases of Events.\n" +
                    "Due to top to bottom approach, sometimes programmer have to write same code many times.\n\nModular Programming :\n\nModular Programming is a programming technique" +
                    " in which program is divided into modules i.e., functions or subprograms. Programmer's time is saved in this kind as he don't have to write same code again and again. He just have to specify function or subprogram name there.");
            image.setImageResource(R.drawable.module2);
            out.setVisibility(View.GONE);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1 =new Intent(learn.this,image.class).putExtra("Roll",roll);

                    startActivity(intent1);
                }
            });

        }
        else if(roll==120){
            setTitle("Function");
            title.setText("What is a Function ?");
            ans.setText("A function is a group of statements which together performs a task. Every C++ Program have at least one function, which is void main. We can create as many function as we " +
                    "want. It truely depends on Programmer. Functions are used to avoid writing same code again and again rather than defining it at one place.\n\nThere are Two types of it \n\n" +
                    "Predefined Functions :\nThese are the functions which are already defined in header files and ready to use .Ex-- gets(); is function which is defined in stdio.h header file." +
                    "\n\nUser Defined Functions :\nThese are the functions which a Programmer creates according to its need. We need to declare these functions before using unlike Predefined Functions.\n" +
                    "\n Parameters :\nA Function is a part of program which is separate out of main function as a Module. For modification in variables which are declared in main function then we need to declare the parameters of function \n" +
                    "Below is simple User Defined Program with parameters.");
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
            image.setImageResource(R.drawable.func);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1 =new Intent(learn.this,image.class).putExtra("Roll",roll);

                    startActivity(intent1);
                }
            });

            codeView.showCode(code);
            out.setText("Explanation :");
            output.setText(" Here, we have declared a function using void /function name/ . We will discuss the use of 'void' in later programs .Parameters are declared inside the braces with their Data Types.\n" +
                    "It is not necessary that in main part we have to pass variables in the function, we can directly give values from main part.\nEx-- void main()\narea(5,6)\nOutput :\n Area is 30\n" +
                    "");

        }
        else if(roll==121)
        {
            setTitle("Parameters in Functions");
            title.setText(" What are Parameters in Function ?");
            ans.setText("Parameters are the special kind of variables which are the not defined inside the function and are passed from other part of program where the function " +
                    "is used or called. \n Ex-");
            image.setVisibility(View.GONE);
            String code="#include<iostream.h>\n" +
                    "#include<conio.h>\n" +
                    "void func(int value)\n" +
                    " {\n" +
                    "   cout<<\"\\n Value passed in Fuction is\"<<value;\n" +
                    " }\n" +
                    "void main()\n" +
                    " {\n" +
                    "  int a=5;\n" +
                    "  func(a);\n" +
                    " }";
            codeView.showCode(code);
            out.setText("Output :\nValue passed in Function is 5 \n" +
                    "\nExplaination :");
            output.setText(" Here , we have made a fuction named 'func' with a int type Parameter. From main part when we push a value into function, then the parameter takes " +
                    "up the value and uses in the function.");

        }
//        else if(roll==122)
//        {
//            setTitle("& in Parameters");
//            title.setText(" Why '&' sign is used in Parameters of a function ?");
//            ans.setText("");
//
//        }



  }
  public void savedata(){
      SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
      SharedPreferences.Editor editor=sharedPreferences.edit();
      editor.putInt(TEXT,a);
      editor.apply();
  }
  public void loaddata(){
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        a=sharedPreferences.getInt(TEXT,0);
  }

}
