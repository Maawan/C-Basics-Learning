package miwok.android.example.com.learnc;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class Firebase_Messaging extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Intent intent =new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder notification_builder=new NotificationCompat.Builder(this);
        notification_builder.setContentTitle("Notification");
        notification_builder.setContentText(remoteMessage.getNotification().getBody());
        notification_builder.setAutoCancel(true);
        notification_builder.setSmallIcon(R.drawable.noti_1);
        notification_builder.setContentIntent(pendingIntent);
        //notification_builder.setSound(sound);
        NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notification_builder.build());
    }
}
