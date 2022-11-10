package ru.startandroid.develop.grib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
    EditText edText;
    EditText etText;
    Button btnSave, btnLoad;
    SharedPreferences sPref;
    SharedPreferences s1Pref;
    String SAVED1_TEXT = "saved1_text";
    final String SAVED_TEXT = "saved_text";


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etText = (EditText) findViewById(R.id.etText);
        edText = (EditText) findViewById(R.id.editTextTextPassword);

        btnLoad = (Button) findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);
        loadText();
        loadText1();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLoad:
                saveText();
                saveText1();
                break;
            default:
                break;
        }
    }

    void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, etText.getText().toString());
        ed.commit();


    }
    void saveText1() {
        s1Pref = getPreferences(MODE_PRIVATE);
        Editor ed = s1Pref.edit();
        ed.putString(SAVED1_TEXT, edText.getText().toString());
        ed.commit();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();

    }

    void loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT, "");
        etText.setText(savedText);

        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }
    void loadText1()
    {
        s1Pref = getPreferences(MODE_PRIVATE);
        String savedText1 = s1Pref.getString(SAVED1_TEXT, "");
        edText.setText(savedText1);
    }
}

