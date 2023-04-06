package ro.pub.cs.systems.eim.practicaltest01var08;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class PracticalTest01Var08Service extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String answer = intent.getStringExtra("answer");
        ProcessingThread processingThread = new ProcessingThread(getApplicationContext(), answer);
        processingThread.start();

        return Service.START_REDELIVER_INTENT;
    }
}