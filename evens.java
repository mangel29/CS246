package com.example.threads;

import android.app.Activity;
import android.widget.Toast;
import java.lang.ref.WeakReference;

    public class evens implements Runnable {
        private WeakReference<Activity> activityRef;

        public evens(Activity activity) {
            this.activityRef = new WeakReference<Activity>(activity);
        }

    public void run() {
        int number = 1;

        while( number <= 100 )
        {
            if( (number % 2) == 0 )
            {
                System.out.println(number);
            }
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            number++;
        }

        final Activity activity = activityRef.get();

        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast toast = Toast.makeText(activity, "Finished counting even numbers", Toast.LENGTH_SHORT);
                    toast.show();
                }
            });
        }
    }


}
