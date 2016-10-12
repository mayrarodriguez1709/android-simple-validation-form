package me.mayrarodriguez.validationform;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mName;
    private EditText mEmail;
    private EditText mPassword;
    private EditText mPasswordConfirm;
    private Button mValidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = (EditText) findViewById(R.id.et_name);
        mEmail = (EditText) findViewById(R.id.et_email);
        mPassword = (EditText) findViewById(R.id.et_password);
        mPasswordConfirm = (EditText) findViewById(R.id.et_password_confirm);
        mValidate = (Button) findViewById(R.id.bt_validate);

        setListeners();

    }

    private void setListeners() {
        mValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    Toast.makeText(getApplicationContext(), "Bienvenido",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validate() {
        boolean valid = true;

        String name = mName.getText().toString();
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();
        String passwordConfirm = mPasswordConfirm.getText().toString();

        if(name.isEmpty()){
            mName.setError("Debe completar este campo");
            valid = false;
        }

        if(email.isEmpty()){
            mEmail.setError("Debe completar este campo");
            valid = false;
        }

        if(password.isEmpty()){
            mPassword.setError("Debe completar este campo");
            valid = false;
        }

        if(passwordConfirm.isEmpty()){
            mPasswordConfirm.setError("Debe completar este campo");
            valid = false;
        }

        if(!email.isEmpty() && !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mEmail.setError("Ingrese un email válido");
            valid = false;
        }

        if(!password.isEmpty() && (password.length()< 8 || password.length() > 16)){
            mPassword.setError("La Contraseña debe contener entre 8 y 16 caracteres");
            valid = false;
        }


        if(!password.equals(passwordConfirm)){
            mPasswordConfirm.setError("Las Contraseñas no coinciden");
            valid = false;
        }



        return valid;
    }
}
