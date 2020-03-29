package miwok.android.example.com.learnc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class program extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);
        ArrayList<Heading> title=new ArrayList<>();
//        AdView mAdView = (AdView)findViewById(R.id.adView1);
//        AdRequest.Builder adRequestBuilder = new AdRequest.Builder();
//        mAdView.loadAd(adRequestBuilder.build());
        setTitle("Programs");
//        URL url=http://www.cppexampler.com/what-is-c-how-can-we-define-it/;
        title.add(new Heading("First Program of C++ ",1));
        title.add(new Heading("Accept a number from user and display it on Screen",2));
        title.add(new Heading("Accept two numbers and calculate the sum of it ",3));
        title.add(new Heading("Program to find Area of Square ",4));
        title.add(new Heading("Program to find Area of Rectangle  ",5));
        title.add(new Heading("Program to find Area of Circle",6));
        title.add(new Heading("Accept marks of 3 Subject and print Avg",7));
        title.add(new Heading("Accept marks of 5 Subject and print Percentage and give Remarks",22));
        title.add(new Heading("A Program to calculate Simple Interest",21));
        title.add(new Heading("Accept characters from user and display it on Screen",26));
        title.add(new Heading("Accept a word from user and display it on Screen ",27));
        title.add(new Heading("Accept a sentence from user and display it on Screen ",28));
        title.add(new Heading("Accept a no and whether it is greater than 10 or smaller",8));
        title.add(new Heading("Accept two no and check which one is Greater",9));
        title.add(new Heading("Accept 5 numbers and check which one is Greater  ",10));
        title.add(new Heading("Accept a no and check whether it is odd or even ",11));
        title.add(new Heading("Accept two numbers and Swap them  ",32));

        title.add(new Heading("Program to display numbers from 1 to 50 using While loop",12));
        title.add(new Heading("Program to display numbers from 1 to 50 using FOR Loop",13));
        title.add(new Heading("Program to display numbers from 1 to 50 using DO WHILE Loop",14));
        title.add(new Heading("Display all the numbers from 8 to n",15));
        title.add(new Heading("Display all even numbers from 8 to n",16));
        title.add(new Heading("Display sum of all numbers upto n",24));
        title.add(new Heading("Accept two number and find LCM of it",23));
        title.add(new Heading("Accept a number and show factorial of it",25));
        title.add(new Heading("Accept a number from user and display table of it",17));
        title.add(new Heading("Accept a number and display its table if it is even",18));
        title.add(new Heading("Accept a number and check whether it a Palindrome or not",19));
        title.add(new Heading("Accept a number and check whether it is Prime, even or Odd",20));
        title.add(new Heading("Accept length and breadth and find the area using Function",29));
        title.add(new Heading("Display your details using function",30));
        title.add(new Heading("Calculate Simple Interest using Function ",31));
        RecyclerView list=(RecyclerView) findViewById(R.id.list);
        HeadingAdapter adapter=new HeadingAdapter(this,title);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));


    }
}
