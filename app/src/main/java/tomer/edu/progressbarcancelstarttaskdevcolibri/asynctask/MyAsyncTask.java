package tomer.edu.progressbarcancelstarttaskdevcolibri.asynctask;

/**
 * Created by azubakov on 7/14/16.
 */
import java.util.concurrent.TimeUnit;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class MyAsyncTask extends AsyncTask<Void, Void, Void>
{

    private static MyAsyncTask instance;

    private static Context context;

    public static MyAsyncTask getInstance(Context context) {
        if (instance == null) {
            instance = new MyAsyncTask();
            instance.execute();
        }
        setContext(context);

        return instance;
    }



    @Override
    protected Void doInBackground(Void... voids)
    {
         try
         {
             for (int i = 0; i <= 10; i++)
             {
                Log.i("[MY_TASK]", "Task is working...");
                //Log.i("[MY_TASK]", "Task cancelled: " + isCancelled());
                TimeUnit.SECONDS.sleep(2);
                 printInfo();
                 if (isCancelled()) {
                     return null;
                 }
             }
         }
         catch (InterruptedException e)
         {
             e.printStackTrace();
         }

        return null;
    }

    private void printInfo() {
        Log.i("DEV_MODE", "CODE: " + this.hashCode() + " | " + context.hashCode());

    }

    public static void setContext(Context context) {
        MyAsyncTask.context = context;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        //super.onPostExecute(aVoid);
        instance = null;
    }
}

