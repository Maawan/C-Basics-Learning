package miwok.android.example.com.learnc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.net.URL;
import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ArrayList<Heading>  title=new ArrayList<>();
//        URL url=http://www.cppexampler.com/what-is-c-how-can-we-define-it/;
        title.add(new Heading("What is C++ ? How can we Start coding in it",101));
        title.add(new Heading("What is compiler and Interpreter ?",116));
        title.add(new Heading("What are Variables ?",102));
        title.add(new Heading("What are Identifiers ? ",103));
        title.add(new Heading("What are Literals ? ",115));
        title.add(new Heading("What are Keywords ?",107));
        title.add(new Heading("Data Type",104));
        title.add(new Heading("What is main part ? Why it is important to run the program",105));
        title.add(new Heading("What are Relational Operators ?",106));
        title.add(new Heading("Introduction to If-Else statement",108));
        title.add(new Heading("What is Loop ? ",109));
        title.add(new Heading("Types of Loops in C++ ?",110));
        title.add(new Heading("Do While Loop and its example ",111));
        title.add(new Heading("For Loop and its example ",112));
        title.add(new Heading("While Loop and its example ",113));
        title.add(new Heading("What are Nested loops ?",114));
        title.add(new Heading("What is Switch and why it is used ?",117));
        title.add(new Heading("What are Break and Continue Statements ?",118));
        title.add(new Heading("What is Procedural Programming and Modular Programming ?",119));
        title.add(new Heading("What is a Function ?",120));
        title.add(new Heading("What are Parameters in Function ?",121));
       // title.add(new Heading("Why '&' sign is used in Parameters of a function ?",122));






          RecyclerView list=(RecyclerView) findViewById(R.id.list);
            HeadingAdapter adapter=new HeadingAdapter(this,title);
            list.setAdapter(adapter);
            list.setLayoutManager(new LinearLayoutManager(this));




    }
}
