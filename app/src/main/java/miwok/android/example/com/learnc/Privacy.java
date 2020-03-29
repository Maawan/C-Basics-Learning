package miwok.android.example.com.learnc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

//import static miwok.android.example.com.learnc.R.id.myWebView;

public class Privacy extends AppCompatActivity {
    ProgressBar progressBar;
    CardView retry;
    WebView webView;
    RelativeLayout connection_success,no_connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);
        progressBar=(ProgressBar)findViewById(R.id.bar);
        webView=(WebView) findViewById(R.id.myWebView);
        webView.getSettings().setBuiltInZoomControls(true);
        connection_success=(RelativeLayout)findViewById(R.id.privacy_connection_success);
        retry=(CardView) findViewById(R.id.try_again_privacy);
        no_connection=(RelativeLayout)findViewById(R.id.privacy_no_connection_layout);
        setTitle("Loading Content");
        if(isNetworkAvailable())
        {
            connection_success.setVisibility(View.VISIBLE);
            webView.loadUrl("https://chayatsoftwares.000webhostapp.com/intro_program.html");
            progressBar.setVisibility(View.VISIBLE);
        }
        else
        {
            no_connection.setVisibility(View.VISIBLE);
        }
        webView.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
                setTitle("Introduction to C++");

            }
        });
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isNetworkAvailable())
                {
                  connection_success.setVisibility(View.VISIBLE);
                  no_connection.setVisibility(View.GONE);
                  webView.loadUrl("https://learn-c-4e4af.firebaseapp.com/privacy_python.html");
                  progressBar.setVisibility(View.VISIBLE);
                }
                else {
                    Toast.makeText(Privacy.this, "Your Internet Connection is still not Active", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
