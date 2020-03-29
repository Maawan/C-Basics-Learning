package miwok.android.example.com.learnc;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import org.w3c.dom.Text;

public class login extends AppCompatActivity {
    private Boolean firstTime=null;
    Dialog no;
    int a=1,skip=1;
    public TextView basic_id;
    int basic=0;
    private static final int RC_SIGN_IN =34567 ;
    private FirebaseAuth mAuth;
    Button btn;
    TextView title,title_2;
    ImageView close,network,image;
    GoogleSignInClient mGoogleSignInClient;
   ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);
        basic_id=(TextView)findViewById(R.id.basic_id);

        image=(ImageView)findViewById(R.id.imge);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skip++;

            }
        });
        basic_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basic++;
                if (basic==2 && skip==3)
                {
                    Toast.makeText(login.this, "Welcome ! into the Developer Mode", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(login.this,MainActivity.class);
                    startActivity(intent);

                }


            }
        });


        no=new Dialog(this);
        initialise_Dialog();
        Boolean FirstTime=isFirstTime();
        if(FirstTime){
            Intent intent=new Intent(this,WelcomeActivity.class);
            startActivity(intent);
        }
        getSupportActionBar().hide();
        if (FirebaseAuth.getInstance().getCurrentUser()!=null){

            Intent intent = new Intent(login.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        mAuth = FirebaseAuth.getInstance();

        mAuth = FirebaseAuth.getInstance();

        //Then we need a GoogleSignInOptions object
        //And we need to build it as below
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        //Then we will get the GoogleSignInClient object from GoogleSignIn class
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        //Now we will attach a click listener to the sign_in_button
        //and inside onClick() method we are calling the signIn() method that will open
        //google sign in intent

        findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isNetworkAvailable())
                {
                signIn();}
                else{
                    no.show();}

            }
        });

    }

    @Override
    public void onBackPressed() {
        if(a==0)
        {
            Toast.makeText(this, "Press Back One More time to exit", Toast.LENGTH_SHORT).show();
            a++;
        }
        if(a==1)
        {finish();}

    }

    @Override
    protected void onStart() {
        super.onStart();

        //if the user is already signed in
        //we will close this activity
        //and take the user to profile activity
        if (mAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //if the requestCode is the Google Sign In code that we defined at starting
        if (requestCode == RC_SIGN_IN) {

            //Getting the GoogleSignIn Task
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                //Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);

                //authenticating with firebase
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                progressBar.setVisibility(View.GONE);
                Log.e("Error","Error in Login");
            }
        }
    }
    private void firebaseAuthWithGoogle(final GoogleSignInAccount acct) {
        Log.d("rjkndv", "firebaseAuthWithGoogle:" + acct.getId());

        //getting the auth credential
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);

        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d("rndk", "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                       progressBar.setVisibility(View.GONE);

                            showToast();

                            Intent intent =new Intent(login.this,MainActivity.class);
                            startActivity(intent);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("jhfvdjk", "signInWithCredential:failure", task.getException());
                            Toast.makeText(login.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);

                        }
                    }
                });
    }

    private void signIn() {
        //getting the google signin intent
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        progressBar.setVisibility(View.VISIBLE);


        //starting the activity for result
        startActivityForResult(signInIntent, RC_SIGN_IN);
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
    public void initialise_Dialog(){
        no.setContentView(R.layout.no_network);
        close=(ImageView)no.findViewById(R.id.close);
        btn=(Button)no.findViewById(R.id.retry_btn);
        title=(TextView)no.findViewById(R.id.title);
        title_2=(TextView)no.findViewById(R.id.title_2);
        network=(ImageView)no.findViewById(R.id.vector);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                no.dismiss();
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                no.dismiss();
                }
        });

        no.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    public void showToast(){
        StyleableToast.makeText(this,"You have Successfully logged in",R.style.toast).show();
    }
}