package com.mshanak.adroidcourseexamples;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Random;

public class MyFirebaseService  extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        showNotification(remoteMessage.getNotification(),remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());

    }

    private void showNotification(RemoteMessage.Notification notification, String title, String body) {
        NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String notification_channel_id="com.mshanak.adroidcourseexamples";
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel notificationChannel=new NotificationChannel(notification_channel_id,"notification",NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("cdac noida");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{0,1000,500,1000});




            notificationManager.createNotificationChannel(notificationChannel);

        }

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,notification_channel_id);

        builder.setAutoCancel(true);
        builder.setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_msg)
                .setContentInfo("information");

        notificationManager.notify(new Random().nextInt(),builder.build());
    }

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.d("Token: ",s);
    }
}
