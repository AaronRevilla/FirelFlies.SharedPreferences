package com.example.aaron.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = ((EditText) findViewById(R.id.editText));
        txtView = ((TextView) findViewById(R.id.textView));
        txtView.setText(getPreference());
    }

    public void savePreferences(View view) {

        SharedPreferences preference = getSharedPreferences("File", MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        String tmp = editText.getText().toString();
        editor.putString("txtValue", tmp);
        editor.commit();
        txtView.setText(tmp);
    }

    private String getPreference(){
        SharedPreferences preference = getSharedPreferences("File", MODE_PRIVATE);
        String lanSettings = preference.getString("txtValue", "Nothing yet");
        return lanSettings;
    }
}
