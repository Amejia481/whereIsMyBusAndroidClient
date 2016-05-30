package net.wearecode.whereismybus.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.media.RingtoneManager;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import net.wearecode.whereismybus.R;

public class CustomFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = CustomFirebaseMessagingService.class.getSimpleName() ;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // If the application is in the foreground handle both data and notification messages here.
        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());


        // In this sample, we'll use the same text for the ticker and the expanded notification
        CharSequence text = remoteMessage.getNotification().getTitle();

        // The PendingIntent to launch our activity if the user selects this notification


        // Set the info for the views that show in the notification panel.
        Notification notification = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)  // the status icon
                .setTicker(text)  // the status text
                .setWhen(System.currentTimeMillis())  // the time stamp
                .setContentTitle(getText(R.string.app_name))  // the label of the entry
                .setContentText(remoteMessage.getNotification().getBody())  // the contents of the entry
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .build();


        // Send the notification.
        ((NotificationManager)getSystemService(NOTIFICATION_SERVICE)).notify(366, notification);

        super.onMessageReceived(remoteMessage);

    }
}
