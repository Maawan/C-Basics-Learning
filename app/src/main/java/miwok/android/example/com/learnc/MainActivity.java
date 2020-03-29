package miwok.android.example.com.learnc;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
//import android.support.design.widget.Snackbar;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import hotchemi.android.rate.AppRate;

//import com.nispok.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Boolean firstTime=null;
    Dialog exit,rate;
    ImageView close,vector,close1,vector1;
    TextView title,title1;
    Button yes,no,yes1,no1,ask1;
    GoogleSignInClient mGoogleSignInClient;

    @Override
    public void onBackPressed() {

        exit.show();

        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("C++ Basics Learning");
        AppRate.with(this).setInstallDays(1).setLaunchTimes(3).setRemindInterval(2).monitor();
        AppRate.showRateDialogIfMeetsConditions(this);
        CardView card=(CardView)findViewById(R.id.card_view);
        exit=new Dialog(this);
        rate=new Dialog(this);
        loadrate();
        loadpopup();
//        rate.show();
//
//        SharedPreferences sharedPreferences= getSharedPrefere
        //RelativeLayout relativeLayout=(RelativeLayout)findViewById(R.id.rlayout);

//        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
//        boolean abc=isFirstTime();
//        if(abc){
//             Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
////            Snackbar snackbar = Snackbar.make(relativeLayout, "Welcome to AndroidHive", Snackbar.LENGTH_LONG);
////
//    //         snackbar.show();
//
//        }else{
//            Toast.makeText(this, "Welcome back Again...", Toast.LENGTH_SHORT).show();
//        }
        showWelcomeToast();
        CardView cardView=(CardView)findViewById(R.id.card_view3);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent);
            }
        });
        CardView card3=(CardView)findViewById(R.id.card_view2);
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,program.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.policy)
        {    Intent intent=new Intent(this,Privacy.class);
             startActivity(intent);
            //StyleableToast.makeText(this,"Hello World",R.style.toast).show();

        }
       if(item.getItemId()==R.id.add){
           Intent intent =new Intent(MainActivity.this,add.class);
           startActivity(intent);
           }
        if(item.getItemId()==R.id.app_info){
            Intent intent =new Intent(MainActivity.this,app_ver.class);
            startActivity(intent);
        }
//        if(item.getItemId()==R.id.website)
//        { String url="https://www.cppexampler.com/";
//            Intent intent=new Intent(Intent.ACTION_VIEW);
//           intent.setData(Uri.parse(url));
//           startActivity(intent);
//           StyleableToast.makeText(this,"Thanks for Vising Us",R.style.toast).show();
//           }
        if(item.getItemId()==R.id.share){
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Want to begin with Programming then learn C++ Basics from here. It is quite easy, I am learning to..." +
                    "\nhttps://play.google.com/store/apps/details?id=miwok.android.example.com.learnc");
            startActivity(shareIntent);
        }
           if(item.getItemId()==R.id.about)
           {Intent intent=new Intent(MainActivity.this,about.class);
           startActivity(intent);}
           if(item.getItemId()==R.id.Ref)
           {Intent intent=new Intent(MainActivity.this,refrences.class);
           startActivity(intent);}
        return super.onOptionsItemSelected(item);
    }

    private boolean isFirstTime() {
        if (firstTime == null) {
            SharedPreferences mPreferences = this.getSharedPreferences("first_time", Context.MODE_PRIVATE);
            firstTime = mPreferences.getBoolean("firstTime", true);
            if (firstTime) {
                SharedPreferences.Editor editor = mPreferences.edit();
                editor.putBoolean("firstTime", false);
                editor.commit();
            }
        }
        return firstTime;
    }
    public void loadpopup(){
        exit.setContentView(R.layout.exit);
        close=(ImageView)exit.findViewById(R.id.close);
        yes=(Button)exit.findViewById(R.id.yes);
        no=(Button)exit.findViewById(R.id.no);
        title=(TextView)exit.findViewById(R.id.title);
        vector=(ImageView)exit.findViewById(R.id.vector);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(startMain);
                exit.dismiss();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exit.dismiss();
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exit.dismiss();
            }
        });

        exit.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }
    public void showWelcomeToast()
    {
        StyleableToast.makeText(this,"Welcome",R.style.toast).show();
    }
    public void loadrate(){
        rate.setContentView(R.layout.rate);
        close1=(ImageView)rate.findViewById(R.id.close);
        yes1=(Button)rate.findViewById(R.id.yes);
        no1=(Button)rate.findViewById(R.id.no);
        title1=(TextView)rate.findViewById(R.id.title);
        vector1=(ImageView)rate.findViewById(R.id.vector);
        ask1=(Button)rate.findViewById(R.id.ask_later);
        yes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/yyxEqy")));
                }
            }
        });
        no1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rate.dismiss();
            }
        });
        ask1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rate.dismiss();
            }
        });
        close1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rate.dismiss();
            }
        });


        rate.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }
}
