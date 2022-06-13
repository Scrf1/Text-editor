package com.example.texteditor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView bold;
    TextView italic;
    TextView underline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        bold = (TextView) findViewById(R.id.bold);
        italic = (TextView) findViewById(R.id.italics);
        underline = (TextView) findViewById(R.id.underline);

        bold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedTextStart = editText.getSelectionStart();
                int selectedTextEnd = editText.getSelectionEnd();

                if(selectedTextStart != -1 && selectedTextEnd != -1) {
                    StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
                    editText.getText().setSpan(boldSpan, selectedTextStart, selectedTextEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        View view = getCurrentFocus();

        if(view != null && view.getId() == editText.getId()) {
            int selectedTextStart = editText.getSelectionStart();
            int selectedTextEnd = editText.getSelectionEnd();

            editText.setSelection(selectedTextStart, selectedTextEnd);
            /*editText.setRawInputType(InputType.TYPE_NULL);
            editText.setFocusable(true);*/
        }
    }
}