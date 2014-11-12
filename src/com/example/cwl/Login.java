package com.example.cwl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class Login extends ActionBarActivity {

	// UI components
	private Button login = null;
	private Button signUp = null;
	private EditText usrText = null;
	private EditText pwdText = null;
	private CheckBox pwdRem = null;
	
	private SharedPreferences sp;

	// Activity's Preference
	public static final String PREF = "Login_PREF";
	public static final String PREF_usrText = "Login_UID";

	// OptionDialog button
	protected static final int MENU_ABOUT = Menu.FIRST;
	protected static final int MENU_QUIT = Menu.FIRST + 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);

//		login = (Button) findViewById(R.id.login_button);
		signUp = (Button) findViewById(R.id.sign_up);
		usrText = (EditText) findViewById(R.id.username_input);
		pwdText = (EditText) findViewById(R.id.password_input);
		pwdRem = (CheckBox) findViewById(R.id.remember_me);
		
		sp = this.getSharedPreferences("userInfo", Context.MODE_WORLD_READABLE);

		usrText.setLongClickable(false);
		pwdText.setLongClickable(false);
		
		if (sp.getBoolean("ISCHECK", false)) {
			pwdRem.setChecked(true);
			usrText.setText(sp.getString("uName", ""));
			pwdText.setText(sp.getString("pwd", ""));
		}

		// Login button
		login.setOnClickListener(new Button.OnClickListener() {
			@Override
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
							//Toast.makeText(Login.this, R.string.loginSucess, Toast.LENGTH_LONG).show();
							if (pwdRem.isChecked()) {
								Editor editor = sp.edit();
								editor.putString("uName", usrName);
								editor.putString("pwd", pass);
								editor.commit();
							}
							Intent intent = new Intent();
							intent.setClass(Login.this, MainActivity.class);

							Bundle bundle = new Bundle();
							bundle.putString("usr", usrName);
							bundle.putString("pass", pass);

							intent.putExtras(bundle);
							startActivity(intent);
							Login.this.finish();
						}
					/*}
				}.start();*/
			}
		});
		
		signUp.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(Login.this, SignUp.class);
				startActivity(intent);
			}
		});
		
		pwdRem.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (pwdRem.isChecked())
					sp.edit().putBoolean("ISCHECK", true).commit();
				else
					sp.edit().putBoolean("ISCHECK", false).commit();
			}
		});
	}
	
	/*@Override
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
	}*/
}
