package me.kevingleason.amessagetutorial;

import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    private ViewSwitcher mCipherSwitcher, mAuthSwitcher;
    private EditText mCipherET, mAuthET;
    private TextView mCipherTV, mAuthTV, mPhoneNumberTV;
    private LinearLayout mEnabledSwitch;
    private TextView mEnabledTV;
    private FloatingActionButton mFAB;

    private boolean editing;
    private boolean enabled;
    private String cipher;
    private String authkey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get all views to instance variables
        this.mPhoneNumberTV = (TextView) findViewById(R.id.phoneNumberTV);

        this.mCipherSwitcher = (ViewSwitcher) findViewById(R.id.cipher_switcher);
        this.mCipherTV = (TextView) findViewById(R.id.tv_cipher);
        this.mCipherET = (EditText) findViewById(R.id.edit_cipher);

        this.mAuthSwitcher = (ViewSwitcher) findViewById(R.id.authkey_switcher);
        this.mAuthTV = (TextView) findViewById(R.id.tv_authkey);
        this.mAuthET = (EditText) findViewById(R.id.edit_authkey);

        this.mEnabledSwitch = (LinearLayout) findViewById(R.id.enabled_switch);
        this.mEnabledTV = (TextView) findViewById(R.id.tv_enabled);
        this.mFAB = (FloatingActionButton) findViewById(R.id.fab);

        // 1. Set up SharedPreferences to hold values for cipher, authkey, and enabled

        // 2. Get telephone number from TelephonyManager, your number is your username

        // 3. Setup text views to display values for cipher and authkey

        // 4. Setup enabled switch with SharedPreferences
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

    @Override
    protected void onResume() {
        super.onResume();
        // Start PubNub Push service if enabled
    }

    public void fabClick(View view){
        editing = !editing;
        int fabColor = ContextCompat.getColor(MainActivity.this,
                editing ? R.color.green_enabled : R.color.red_disabled);
        Drawable fabIcon = ContextCompat.getDrawable(MainActivity.this,
                editing ? android.R.drawable.ic_menu_save : android.R.drawable.ic_menu_edit);
        mFAB.setBackgroundTintList(ColorStateList.valueOf(fabColor));
        mFAB.setImageDrawable(fabIcon);

        if (editing) { // Edit the cipher and authkey
            // Copy TextView values into EditText

            mCipherSwitcher.showNext();
            mAuthSwitcher.showNext();
            mCipherET.requestFocus();

        } else {
            // Kill push service

            // Save the new cipher and authkey values in SharedPreferences

            // Update the TextViews with the new values

            // Change the view switcher back

            mCipherSwitcher.showPrevious();
            mAuthSwitcher.showPrevious();

            // Recreate the Push Service (will use new cipher and authkey)
        }
    }

    public void toggleEnabled(View view){
        enabled = !enabled;

        // Store enabled value in Shared Preferences

        // If not enabled, kill service.

        // If enabled, start push service.
    }

    // Setup PubNub -- Function that will create PN with given auth and cipher

    // Censor Key -- Creates the censor string so the app is not displaying your credentials

    // Start Push Service -- Creates a Push Alarm which will continuously create a Push Service

    // Kill Service -- Kills the Push Service


}
