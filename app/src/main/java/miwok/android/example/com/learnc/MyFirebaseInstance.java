package miwok.android.example.com.learnc;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstance extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        String recent_toxen= FirebaseInstanceId.getInstance().getToken();
        Log.d("AbC",recent_toxen);
    }
}
