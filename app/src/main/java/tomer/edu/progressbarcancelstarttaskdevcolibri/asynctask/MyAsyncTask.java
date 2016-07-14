package tomer.edu.progressbarcancelstarttaskdevcolibri.asynctask;

/**
 * Created by azubakov on 7/14/16.
 */
import java.util.concurrent.TimeUnit;
import android.os.AsyncTask;
import android.util.Log;

public class MyAsyncTask extends AsyncTask<Void, Void, Void>
{

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
}

