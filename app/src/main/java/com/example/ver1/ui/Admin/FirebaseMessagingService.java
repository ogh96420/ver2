package com.example.ver1.ui.Admin;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.example.ver1.R;
import com.google.firebase.messaging.RemoteMessage;

/*스위치 클릭시 작동안하게 하는거랑 푸쉬알림이 뜨고 그 것을 클릭하면 그곳으로 이동할수있게 작동시켜야함*/
public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {

    @Override
    public void onNewToken(String token) {
        Log.d("FCM Log", "Refreshed token:" + token);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        if (remoteMessage.getNotification() != null){
            Log.d("FMC Log","알림 메시지:" + remoteMessage.getNotification().getBody());
            String messageBody = remoteMessage.getNotification().getBody();
            String messageTitle = remoteMessage.getNotification().getTitle();
            Intent intent = new Intent(this, MessageMainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
            String channelId = "Channel Id";
            Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this,channelId)
                    .setSmallIcon(R.drawable.logo)
                    .setContentTitle(messageTitle)
                    .setContentText(messageBody)
                    .setAutoCancel(true)
                    .setSound(defaultSoundUri)
                    .setContentIntent(pendingIntent);

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                String channelName = "Channel Name";
                NotificationChannel channel = null;
                    channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH);
                    notificationManager.createNotificationChannel(channel);
            }
            notificationManager.notify(0,notificationBuilder.build());

        }
    }
}
