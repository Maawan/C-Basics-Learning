package miwok.android.example.com.learnc;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class ask_question extends AppCompatActivity implements RewardedVideoAdListener {
    Button btn;
    public RewardedVideoAd mad;
    CardView card;
    TextView ad_text;

    @Override
    protected void onStart() {

        loadAd();
        if (!isNetworkAvailable()) {
            ad_text.setText("Network Unavailable");
        } else {
            ad_text.setText("Ad is Loading");
        }
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_question);

        MobileAds.initialize(this, "ca-app-pub-5627293645158234~6664497734");

        // Use an activity context to get the rewarded video instance.
        mad= MobileAds.getRewardedVideoAdInstance(this);
        ad_text=(TextView)findViewById(R.id.ad_text);
        mad.setRewardedVideoAdListener(this);

        loadAd();
       card=(CardView)findViewById(R.id.card_question);

        if(!isNetworkAvailable())
        {ad_text.setText("Internet Connection Unavailable");}
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mad.isLoaded())
                {mad.show();}



            }
        });
    }
    private void loadAd(){
        mad.loadAd("ca-app-pub-5627293645158234/2113172349",new AdRequest.Builder().build());
    }

    @Override
    public void onRewardedVideoAdLoaded() {

        ad_text.setText("Ad is loaded. Go ahead and click the button");
    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {
        Toast.makeText(this, "Watch full Ad to Ask any Question :)", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onRewardedVideoAdClosed() {
        loadAd();
        if (!isNetworkAvailable()) {
            ad_text.setText("Network Unavailable");
        } else {
            ad_text.setText("Ad is Loading");
        }



    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        Toast.makeText(this, "Thanks for Watching the Ad", Toast.LENGTH_SHORT).show();
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","technobiztricks@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Asking a Question");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "");
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
        btn.setText("Ad is loading. Please Wait....:");
        loadAd();

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        Toast.makeText(this, "Due to some Error Ad is not loading", Toast.LENGTH_SHORT).show();

    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
