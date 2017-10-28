package com.rhesoft.blog.backgroundservice;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

public class TutorialIntentService extends IntentService {

    public TutorialIntentService() {
        this(TutorialIntentService.class.getName());
    }

    public TutorialIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(3000);
                showToast("Msg : " + i);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    protected void showToast(final String msg) {


        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Notification notification = new Notification.Builder(TutorialIntentService.this)
                        .setContentTitle(msg)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .build();
                ((NotificationManager) getSystemService(NOTIFICATION_SERVICE)).notify(0, notification);
            }
        });
    }
}
