package com.gogit.gogit_app.ui;
import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import com.gogit.gogit_app.R;

public class CustomSpinner extends AppCompatSpinner {

        public CustomSpinner(Context context) {
                super(context);
                initialize(context);
        }

        public CustomSpinner(Context context, AttributeSet attrs) {
                super(context, attrs);
                initialize(context);
        }

        public CustomSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
                super(context, attrs, defStyleAttr);
                initialize(context);
        }

        private void initialize(Context context) {
                // Spinner에 표시될 아이템 설정 (이미지와 글자가 들어가야 함)
                String[] items = {"리포지토리 선택", "MIVEN", "APPandME", "javaproject"};

                // ArrayAdapter를 사용하여 Spinner에 아이템 설정
                ArrayAdapter<String> adapter = new ArrayAdapter<>(context, R.layout.spinner_item, items);
                adapter.setDropDownViewResource(R.layout.spinner_item_dropdown); // 선택된 아이템의 드롭다운 레이아웃

                // Spinner에 어댑터 설정
                setAdapter(adapter);
        }
}
