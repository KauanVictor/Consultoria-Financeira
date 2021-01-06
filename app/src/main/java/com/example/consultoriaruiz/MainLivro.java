package com.example.consultoriaruiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.consultoriaruiz.ui.main.MainLivroFragment;

public class MainLivro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_livro_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainLivroFragment.newInstance())
                    .commitNow();
        }
    }
}