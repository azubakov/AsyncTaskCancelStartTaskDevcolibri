package tomer.edu.progressbarcancelstarttaskdevcolibri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import tomer.edu.progressbarcancelstarttaskdevcolibri.asynctask.MyAsyncTask;

public class MainActivity extends AppCompatActivity {

    private MyAsyncTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        task = new MyAsyncTask();

    }

    public void onStartTask(View view) {
        task.execute();
    }

    public void onCancelTask(View view) {
        task.cancel(false);
    }

    public void onStatusTask(View view) {
        Toast.makeText(MainActivity.this, task.getStatus().toString(), Toast.LENGTH_SHORT).show();
    }
}
