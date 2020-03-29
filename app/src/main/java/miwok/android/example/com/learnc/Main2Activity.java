package miwok.android.example.com.learnc;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

public class Main2Activity extends AppCompatActivity implements RewardedVideoAdListener {
    int a=1;
    InterstitialAd mInterstitialAd;
    private RewardedVideoAd mAd;
    int b=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-5627293645158234/6640091784");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        CardView cardView2=(CardView)findViewById(R.id.card_view2);
        MobileAds.initialize(this, "ca-app-pub-5627293645158234~6664497734");

        // Use an activity context to get the rewarded video instance.
        mAd= MobileAds.getRewardedVideoAdInstance(this);
        mAd.setRewardedVideoAdListener(this);

        loadAd();

        CardView cardView=(CardView)findViewById(R.id.card_view);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,ask_question.class);
                startActivity(intent);

            }
        });
//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(mAd.isLoaded()){mAd.show();a=5;}
//                else{loadAd();
//                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
//                        "mailto","technobiztricks@gmail.com", null));
//                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Asking a Question");
//                emailIntent.putExtra(Intent.EXTRA_TEXT, "");
//                startActivity(Intent.createChooser(emailIntent, "Send email..."));}
//            }
//        });
        CardView cardView4=(CardView)findViewById(R.id.card_view4);
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAd.isLoaded()){
                    mAd.show();a=0;
                    }
                    else if(!mAd.isLoaded())
                    {
                        StyleableToast.makeText(Main2Activity.this,"Add is Loading",R.style.toast).show();
                        loadAd();}
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitialAd.isLoaded())
             {mInterstitialAd.show();}
               else{mInterstitialAd.loadAd(new AdRequest.Builder().build());
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","technobiztricks@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Helping us to Improve");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));

            }}
        });

        CardView cardView3=(CardView)findViewById(R.id.card_view3);
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               if (mInterstitialAd.isLoaded())
//               {mInterstitialAd.show();}
//               else{mInterstitialAd.loadAd(new AdRequest.Builder().build());}
                final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                }


            }
        });
        CardView cardView5=(CardView)findViewById(R.id.card_view5);
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(Main2Activity.this, "frjfr", Toast.LENGTH_SHORT).show();
                Uri uri = Uri.parse("https://www.instagram.com/hayatsoftwares/");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.instagram.com/hayatsoftwares/")));
                }
            }
        });


    }

    @Override
    public void onRewardedVideoAdLoaded() {
       // Toast.makeText(this, "Add is loaded ", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {
        if(a==0)
        {StyleableToast.makeText(this,"Thanks for Supporting us",R.style.toast).show();}

        loadAd();


    }

    @Override
    public void onRewarded(RewardItem rewardItem) {

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
        loadAd();

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        loadAd();

    }
    private void loadAd(){
        mAd.loadAd("ca-app-pub-5627293645158234/2113172349",new AdRequest.Builder().build());
    }


}
