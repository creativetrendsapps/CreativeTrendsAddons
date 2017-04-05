package com.creativetrends.addons.activities;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.creativetrends.addons.R;

/**Created by Creative Trends Apps on 3/24/2017.*/

public class MainActivity extends AppCompatActivity{

    Toolbar toolbar;
    Button remove;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);
            remove = (Button) findViewById(R.id.hide_button);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            getSupportActionBar().setTitle(null);
        }




        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PackageManager p = getPackageManager();
                ComponentName componentName = new ComponentName(MainActivity.this, MainActivity.class);
                p.setComponentEnabledSetting(componentName,PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
                finish();
                Toast.makeText(getBaseContext(), "Hiding app", Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.about:
                aboutDialog();
                return false;

            case R.id.simple:
                String simple_app = getResources().getString(R.string.simple_package);
                intent = getPackageManager().getLaunchIntentForPackage(simple_app);
                if(intent == null) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.market)+simple_app));
                    Toast.makeText(getBaseContext(), R.string.not_available, Toast.LENGTH_SHORT).show();
                }
                startActivity(intent);
                return false;

            case R.id.simple_pro:
                String simple_pro = getResources().getString(R.string.simple_pro_package);
                intent = getPackageManager().getLaunchIntentForPackage(simple_pro);
                if(intent == null) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.market)+simple_pro));
                    Toast.makeText(getBaseContext(), R.string.not_available, Toast.LENGTH_SHORT).show();
                }
                startActivity(intent);
                return false;

            case R.id.simplicity:
                String simplicity = getResources().getString(R.string.simplicity_package);
                intent = getPackageManager().getLaunchIntentForPackage(simplicity);
                if(intent == null) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.market)+simplicity));
                    Toast.makeText(getBaseContext(), R.string.not_available, Toast.LENGTH_SHORT).show();
                }
                startActivity(intent);
                return false;

            default:
                return super.onOptionsItemSelected(item);


        }
    }

    @Override
    protected void onStart(){
        super.onStart();


    }

    @SuppressWarnings("deprecation")
    private void aboutDialog() {
        AlertDialog.Builder close = new AlertDialog.Builder(MainActivity.this);
        close.setTitle(getResources().getString(R.string.about_app));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            close.setMessage(Html.fromHtml(getResources().getString(R.string.about_new), Html.FROM_HTML_MODE_LEGACY));
        } else {
            close.setMessage(Html.fromHtml(getResources().getString(R.string.about_new)));
        }
        close.setPositiveButton(R.string.ok, null);
        close.show();
    }


    @TargetApi(19)
    protected void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
}
