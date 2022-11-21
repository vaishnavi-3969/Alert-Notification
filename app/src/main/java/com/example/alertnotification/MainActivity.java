package com.example.alertnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//public class MainActivity extends AppCompatActivity {
//    Button notify;
//    EditText msg;
//    private NotificationManagerCompat notificationManager;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        msg = findViewById(R.id.message);
//        notify = findViewById(R.id.button_sample);
//        notify.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addNotification();
//            }
//        });
//    }
//    private void addNotification(){
//        msg = findViewById(R.id.message);
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
//                .setSmallIcon(R.drawable.messageicon)
//                .setContentTitle("New Message")
//                .setContentText(msg.toString())
//                .setAutoCancel(true)
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
//        Intent notificationIntent = new Intent(this, NotificationView.class);
//        //Notification message we'll get at Notification View
//        notificationIntent.putExtra("message", msg.toString());
//        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//        builder.setContentIntent(pendingIntent);
//
//        //Add as notification
//        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        nm.notify(0, builder.build());
//    }


//}


//===========================
public class MainActivity extends AppCompatActivity {
    Button notify;
    EditText message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notify = findViewById(R.id.button);
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNotification();
            }
        });
    }
    private void addNotification() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.messageicon) //set icon for notification
                        .setContentTitle("New Notification") //set title of notification
                        .setContentText("New Message")//this is notification message
                        .setAutoCancel(true) // makes auto cancel of notification
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT); //set priority of notification

        message = findViewById(R.id.message);
        String msg = message.getText().toString();
        Intent notificationIntent = new Intent(this, NotificationView.class);
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//notification message will get at NotificationView
        notificationIntent.putExtra("message", msg);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
// Add as notification
        NotificationManager manager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }
}