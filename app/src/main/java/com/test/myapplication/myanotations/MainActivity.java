package com.test.myapplication.myanotations;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.test.myapplication.myanotations.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AnotationPreferences preferences;
    private EditText editAnotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferences = new AnotationPreferences(getApplicationContext());
        editAnotation = findViewById(R.id.editAnotation);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //validate if the user type something
                String text = editAnotation.getText().toString();
                if(text.equals("")){
                    Snackbar.make(view, "Preencha a anotação.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    preferences.saveAnotation(text);
                    Snackbar.make(view, "Anotação salva com sucesso!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        //recover the anotation
        String anotation = preferences.getAnotation();
        if(!anotation.equals("")){
            editAnotation.setText(anotation);
        }
    }


}