package com.example.threads;

import android.app.Activity;
import android.widget.Toast;

public class odds implements Runnable {
    private Activity activity;

    public odds(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            System.out.println(i);

            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    activity.runOnUiThread(new Runnable() {
        @Override
        public void run() {
            Toast toast = Toast.makeText(activity, "Finished counting odd numbers", Toast.LENGTH_SHORT);
            toast.show();
        }
    });
}
}