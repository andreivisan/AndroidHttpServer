package server.http.android.androidhttpserver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;

import server.http.android.androidhttpserver.server.MyServer;


public class MainActivity extends AppCompatActivity {

    private MyServer server;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            server = new MyServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(server != null) {
            server.stop();
        }
    }

}
