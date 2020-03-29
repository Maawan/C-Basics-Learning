package miwok.android.example.com.learnc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import thereisnospon.codeview.CodeView;
import thereisnospon.codeview.CodeViewTheme;

public class Code extends AppCompatActivity {
    public static final String CODE="#include<fstream.h>\n" +
            "#include<conio.h>\n" +
            "#include<stdio.h>\n" +
            "class Data\n" +
            "{\n" +
            " char name[20];\n" +
            " int roll;\n" +
            " long salary;\n" +
            " public:\n" +
            " void enter();\n" +
            " void display();\n" +
            "};\n" +
            "void Data::enter()\n" +
            "{\n" +
            "  cout<<\"\\n Please enter your name\";\n" +
            "  gets(name);\n" +
            "  cout<<\"\\n Enter your Roll number\";\n" +
            "  cin>>roll;\n" +
            "  cout<<\"\\n Enter Your Salary\";\n" +
            "  cin>>salary;\n" +
            "}\n" +
            "void wfie()\n" +
            "{\n" +
            " fstream fin;\n" +
            " fin.open(\"abc.DAT\",ios::app);\n" +
            " if(!fin)\n" +
            " {\n" +
            "   cout<<\"\\n Error in Opening File\";\n" +
            " }\n" +
            " Data a;\n" +
            " a.enter();\n" +
            " fin.write((char*)&a,sizeof(a));\n" +
            " cout<<\"\\n Data Entered Successfully\";\n" +
            "}\n" +
            "\n" +
            "void rfile()\n" +
            "{\n" +
            " fstream fout;\n" +
            " fout.open(abc.DAT,ios::in);\n" +
            " if(!fout)\n" +
            "  {cout<<\"\\n Error in Retrieving Data\";}\n" +
            " Data b;\n" +
            " while(fout.read((char*)&b,sizeof(b)))\n" +
            "  {\n" +
            "   b.display();\n" +
            "  }\n" +
            "} \n" +
            " \n";
    CodeView codeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);

    }
}
