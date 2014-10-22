package com.example.cwl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends ActionBarActivity {

	// UI components
	private Button login = null;
	private Button signUp = null;
	private EditText usrText = null;
	private EditText pwdText = null;
	private CheckBox pwdRem = null;

	// Preference
	public static final String PREF = "Login_PREF";
	public static final String PREF_usrText = "Login_UID";

	// OptionDialog button
	protected static final int MENU_ABOUT = Menu.FIRST;
	protected static final int MENU_QUIT = Menu.FIRST + 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// New API enforcement
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectDiskReads().detectDiskWrites().detectNetwork()
				.penaltyLog().build());

		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
				.detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath()
				.build());

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);

		login = (Button) findViewById(R.id.login_button);
		signUp = (Button) findViewById(R.id.sign_up);
		usrText = (EditText) findViewById(R.id.username_input);
		pwdText = (EditText) findViewById(R.id.password_input);
		pwdRem = (CheckBox) findViewById(R.id.remember_me);

		usrText.setLongClickable(false);
		pwdText.setLongClickable(false);

		resotrePrefs();
		checkIfRemember();

		// Login button
		login.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				/*new Thread() {
					public void run() {*/
						String usrName = usrText.getText().toString();
						if (usrName.trim().equals(""))
							Toast.makeText(Login.this, R.string.usrEmpty, Toast.LENGTH_SHORT).show();

						String pass = pwdText.getText().toString();
						if (pass.trim().equals(""))
							Toast.makeText(Login.this, R.string.pwdEmpty, Toast.LENGTH_SHORT).show();

						if (!usrName.equals("") && !pass.equals("")) {
							Toast.makeText(Login.this, R.string.loginSucess, Toast.LENGTH_LONG).show();
							/*Intent intent = new Intent();
							intent.setClass(Login.this, MainPage.class);

							Bundle bundle = new Bundle();
							bundle.putString("usr", usrName);
							bundle.putString("pass", pass);

							intent.putExtras(bundle);
							startActivity(intent);
							Login.this.finish();*/
						}

						if (pwdRem.isChecked())
							rememberMe(usrText.getText().toString().trim(),
									pwdText.getText().toString().trim());
					/*}
				}.start();*/
			}
		});
		
		signUp.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(Login.this, SignUp.class);
				startActivity(intent);
			}
		});

	}
	
	// Restore preference
		private void resotrePrefs() {
			SharedPreferences settings = getSharedPreferences(PREF, 0);
			String prefUsrText = settings.getString(PREF_usrText, "");
			if (prefUsrText.equals("")) {
				usrText.setText(prefUsrText);
				pwdText.requestFocus();
			}
		}

		// Remember user name and password
		public void checkIfRemember() {
			SharedPreferences sp = getPreferences(MODE_PRIVATE);

			String usrTxt = sp.getString("Username", null);
			String pwdTxt = sp.getString("UserPwd", null);

			if (usrTxt != null && pwdTxt != null) {
				EditText etUsr = (EditText) findViewById(R.id.username_input);
				EditText etPwd = (EditText) findViewById(R.id.password_input);
				CheckBox ckPwd = (CheckBox) findViewById(R.id.remember_me);

				etUsr.setText(usrTxt);
				etPwd.setText(pwdTxt);
				ckPwd.setChecked(true);
			}
		}

		public void rememberMe(String usrText, String pwdText) {
			SharedPreferences sp = getPreferences(MODE_PRIVATE); // Get Preferences
			SharedPreferences.Editor editor = sp.edit(); // Get Editor
			editor.putString("usrName", usrText);
			editor.putString("usrPwd", pwdText);
			editor.commit();
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
