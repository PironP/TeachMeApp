package com.pierrepiron.teachme.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.pierrepiron.teachme.R;
import com.pierrepiron.teachme.dto.mainApi.ApiListener;
import com.pierrepiron.teachme.dto.mainApi.ApiProvider;
import com.pierrepiron.teachme.dto.model.CurrentUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.login_email)
    EditText loginEmail;

    @BindView(R.id.login_password)
    EditText loginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.login_button)
    public void loginButtonClicked() {
        if (loginEmail.getText().toString().length() < 6 || loginPassword.getText().toString().length() < 3) {
            return;
        }
        ApiProvider apiProvider = new ApiProvider();
        apiProvider.login(loginEmail.getText().toString(), loginPassword.getText().toString(), new ApiListener<CurrentUser>() {
            @Override
            public void onSuccess(CurrentUser response) {
                Toast.makeText(getApplicationContext(), "Connecté", Toast.LENGTH_LONG).show();
                finish();
            }

            @Override
            public void onError(Throwable throwable) {
                Toast.makeText(getApplicationContext(), "Identifiants incorrects", Toast.LENGTH_LONG).show();
            }
        });
    }
}
