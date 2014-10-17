package com.example.cwl;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends ActionBarActivity {
	private EditText usr, email, phone, pwd, conPwd, bd, addr;
	private Button submit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);
		
		usr = (EditText) findViewById(R.id.name_input);
		email = (EditText) findViewById(R.id.email_input);
		phone  = (EditText) findViewById(R.id.phone_input);
		pwd = (EditText) findViewById(R.id.password_input);
		conPwd = (EditText) findViewById(R.id.confirm_password_input);
		bd = (EditText) findViewById(R.id.birthdate_input);
		addr = (EditText) findViewById(R.id.address_input);
		
		submit = (Button) findViewById(R.id.signin_button);
		
		submit.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				/*new Thread() {
					public void run() {*/
						String user = usr.getText().toString().trim();
						if (user.equals("")) 
							Toast.makeText(SignUp.this, R.string.uNameEmpty, Toast.LENGTH_SHORT).show();
						else if (user.length() < 2)
							Toast.makeText(SignUp.this, R.string.nameLenErr, Toast.LENGTH_SHORT).show();
						
						String mail = email.getText().toString().trim();
						if (mail.equals(""))
							Toast.makeText(SignUp.this, R.string.emailEmpty, Toast.LENGTH_SHORT).show();
						
						String phoneNum = phone.getText().toString().trim();
						if (phoneNum.equals(""))
							Toast.makeText(SignUp.this, R.string.phoneEmpty, Toast.LENGTH_SHORT).show();
						else if (phoneNum.length() < 11)
							Toast.makeText(SignUp.this, R.string.phoneLenErr, Toast.LENGTH_SHORT).show();
						
						String password = pwd.getText().toString().trim();
						if (password.equals(""))
							Toast.makeText(SignUp.this, R.string.pwdEmpty, Toast.LENGTH_SHORT).show();
						else if (password.length() < 6)
							Toast.makeText(SignUp.this, R.string.pwdLenErr, Toast.LENGTH_SHORT).show();
						
						String conPassword = conPwd.getText().toString().trim();
						if (conPassword.equals(""))
							Toast.makeText(SignUp.this, R.string.conPwdEmpty, Toast.LENGTH_SHORT).show();
						else if (conPassword.length() < 6)
							Toast.makeText(SignUp.this, R.string.pwdLenErr, Toast.LENGTH_SHORT).show();
						
						if (!password.equals(conPassword))
							Toast.makeText(SignUp.this, R.string.conPwdErr, Toast.LENGTH_SHORT).show();
						
						String bir = bd.getText().toString().trim();
						if (bir.equals(""))
							Toast.makeText(SignUp.this, R.string.birEmpty, Toast.LENGTH_SHORT).show();
						
						String address = addr.getText().toString().trim();
						if (address.equals(""))
							Toast.makeText(SignUp.this, R.string.addrEmpty, Toast.LENGTH_SHORT).show();
						
						if (!user.equals("") && !mail.equals("") && !phoneNum.equals("") && 
								!password.equals("") && !conPassword.equals("") 
								&& password.equals(conPassword) && !bir.equals("") && !address.equals("")) {
							Toast.makeText(SignUp.this, R.string.signupSucess, Toast.LENGTH_LONG).show();
						}
					}
				/*}.start();
			}*/
		});
	}
}
