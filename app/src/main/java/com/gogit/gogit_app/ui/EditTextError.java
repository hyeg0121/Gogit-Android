package com.gogit.gogit_app.ui;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.gogit.gogit_app.R;


public class EditTextError extends AppCompatActivity {

    EditText name_editText;
    EditText token_editText;

    TextView repository_error;
    TextView token_not_found;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_repository);
        setContentView(R.layout.login_token);

        name_editText=findViewById(R.id.name_editText);
        repository_error=findViewById(R.id.repository_error);

        token_editText=findViewById(R.id.token_editText);
        token_not_found=findViewById(R.id.token_not_found);

        name_editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(s.toString()).matches()){
                    repository_error.setText("이미 존재하는 리포지토리입니다");
                    token_not_found.setText("유요하지 않는 토큰입니다");

                    name_editText.setBackgroundResource(R.drawable.exdittext_error);
                    token_editText.setBackgroundResource(R.drawable.exdittext_error);
                }
                else{
                    repository_error.setText("");
                    token_not_found.setText("");

                    name_editText.setBackgroundResource(R.drawable.border_line_radius);
                    token_editText.setBackgroundResource(R.drawable.border_line_radius);
                }
            }
        });

    }
}