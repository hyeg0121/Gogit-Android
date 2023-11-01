package com.gogit.gogit_app.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.gogit.gogit_app.R;

public class BtnActivation extends AppCompatActivity {
private EditText editText;
private Button button;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.create_repository);

    editText = findViewById(R.id.name_editText);
    button =  findViewById(R.id.upload_button);

    editText.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                button.setClickable(true);
                button.setBackgroundColor(Color.BLUE);
            } else {
                button.setClickable(false);
                button.setBackgroundColor(Color.GRAY);
            }
        }
    });
}
}