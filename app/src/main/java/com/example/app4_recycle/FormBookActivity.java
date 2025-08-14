package com.example.app4recycle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {
    EditText edtTitle, edtAuthor, edtYear;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        edtTitle = findViewById(R.id.edtTitle);
        edtAuthor = findViewById(R.id.edtAuthor);
        edtYear = findViewById(R.id.edtYear);
        btnSave = findViewById(R.id.btnSave);

        // Cek apakah ini update
        Intent intent = getIntent();
        boolean isUpdate = intent.hasExtra("title");

        if (isUpdate) {
            edtTitle.setText(intent.getStringExtra("title"));
            edtAuthor.setText(intent.getStringExtra("author"));
            edtYear.setText(String.valueOf(intent.getIntExtra("year", 0)));
        }

        btnSave.setOnClickListener(v -> {
            Intent data = new Intent();
            data.putExtra("title", edtTitle.getText().toString());
            data.putExtra("author", edtAuthor.getText().toString());
            data.putExtra("year", Integer.parseInt(edtYear.getText().toString()));

            setResult(RESULT_OK, data);
            finish();
        });
    }
}
