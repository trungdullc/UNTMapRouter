package com.example.untmaprouter;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import com.google.android.material.button.MaterialButton;                   // DEBUG: Remove Later Du
import com.google.android.material.textfield.MaterialAutoCompleteTextView;  // DEBUG: Remove Later Du
import com.google.android.material.textfield.TextInputLayout;

public class Navigation extends AppCompatActivity {
    Button aboutButton;
    private Button calculateActivity1;                                      // Du was here
    private String srcInput;
    private String destInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_navigation);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        aboutButton = findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Navigation.this, AboutUs.class);
                startActivity(intent);
            }
        });

        TextInputLayout srcActivity1 = findViewById(R.id.inputLayout);
        TextInputLayout destActivity1 = findViewById(R.id.inputLayout2);                    // Get the second TextInputLayout
        MaterialAutoCompleteTextView autoCompleteTextView = findViewById(R.id.inputTV);
        MaterialAutoCompleteTextView autoCompleteTextView2 = findViewById(R.id.inputTV2);   // Get the second AutoCompleteTextView


        calculateActivity1 = findViewById(R.id.Calculate);

        calculateActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                srcInput = autoCompleteTextView.getText().toString();
                destInput = autoCompleteTextView2.getText().toString();

                // Pass one activity to another
                Intent intent = new Intent(Navigation.this, MapSolution.class);
                intent.putExtra("keysrc", srcInput);
                intent.putExtra("keydest", destInput);
                startActivity(intent);
            }
        });
    }
}