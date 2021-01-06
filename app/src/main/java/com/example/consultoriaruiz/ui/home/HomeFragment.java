package com.example.consultoriaruiz.ui.home;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.consultoriaruiz.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        final Button botaoAdd = root.findViewById(R.id.botaoAdd);
        final Button botaoDetalhes = root.findViewById(R.id.botaoDetalhes);
        final EditText campoNome = root.findViewById(R.id.campoNome);
        final EditText campoValor = root.findViewById(R.id.campoValor);


        botaoAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( campoNome.getText().toString().trim().equalsIgnoreCase(""))
                    campoNome.setError("Informe a descrição.");

                if ( campoValor.getText().toString().trim().equalsIgnoreCase(""))
                    campoValor.setError("Informe o valor.");
                else
                Toast.makeText(getActivity(), "Armazenado com sucesso.", Toast.LENGTH_SHORT).show();
            }
        });


        botaoDetalhes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Inicia tela detalhes.", Toast.LENGTH_SHORT).show();
            }
        });

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return root;

    }
}