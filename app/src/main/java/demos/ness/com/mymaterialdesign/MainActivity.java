package demos.ness.com.mymaterialdesign;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    //Layout of SnackView in activity_main
    @InjectView(R.id.mLayout)
    View parentLayout;
    @InjectView(R.id.btnSubmitSnack)
    Button btnSubmitSnack;
    @InjectView(R.id.view)
    FloatingActionButton view;
    @InjectView(R.id.coordinateLayout)
    CoordinatorLayout coordinateLayout;
    @InjectView(R.id.appBar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        setSupportActionBar(toolbar);
    }

    @OnClick(R.id.btnSubmitSnack)
    public void snackClicked(View v) {
        Snackbar
                .make(coordinateLayout, R.string.snackbar_text, Snackbar.LENGTH_LONG)
                .setAction(R.string.snackbar_action, MainActivity.this)
                .show(); // Don’t forget to show!
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "Yes You Are :)", Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
