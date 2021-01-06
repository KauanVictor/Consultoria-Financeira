package com.example.consultoriaruiz.ui.gallery;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.consultoriaruiz.R;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private EditText ValorInicial, ValorMensal, PeriodoemMeses, JurosAnual;
    private Button Calcular, Limpar;
    int ValorInvestido, TotalAcumulado, GanhoemJuros;
   // private TextView TValorInvestido, TTotalGanho, tValorAcumulado, tResultado;
    TextInputLayout VI, DM, PM, JA;
    AwesomeValidation awesomeValidation;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
       final EditText Inicial = root.findViewById(R.id.ValorInicial);
        final EditText Mensal = root.findViewById(R.id.ValorMensal);
        final EditText Juros = root.findViewById(R.id.JurosAnual);
        final EditText Meses = root.findViewById(R.id.PeriodoemMeses);
        final TextView TValorInvestido = root.findViewById(R.id.TValorInvestido);
        final TextView TTotalGanho = root.findViewById(R.id.TTotalGanho);
        final TextView tValorAcumulado = root.findViewById(R.id.tValorAcumulado);
        final TextView tResultado = root.findViewById(R.id.tResultado);
        final Button Calcular = root.findViewById(R.id.Calcular);
        final Button Limpar = root.findViewById(R.id.Limpar);
        final TextInputLayout VI = root.findViewById(R.id.VI);
        final TextInputLayout DM = root.findViewById(R.id.DM);
        final TextInputLayout PM = root.findViewById(R.id.PM);
        final TextInputLayout JA = root.findViewById(R.id.JA);
        AwesomeValidation mAwesomeValidation = new AwesomeValidation(ValidationStyle.TEXT_INPUT_LAYOUT);
        mAwesomeValidation.addValidation(getActivity(), R.id.VI, Patterns.EMAIL_ADDRESS, R.string.Inicial);
        mAwesomeValidation.addValidation(getActivity(), R.id.DM, Patterns.EMAIL_ADDRESS, R.string.Mensal);
        mAwesomeValidation.addValidation(getActivity(), R.id.PM, Patterns.EMAIL_ADDRESS, R.string.Meses);
        mAwesomeValidation.addValidation(getActivity(), R.id.JA, Patterns.EMAIL_ADDRESS, R.string.Juros);


        Limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Inicial.setText("");
                Mensal.setText("");
                Meses.setText("");
                Juros.setText("");
            }

        });




        Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( Inicial.getText().toString().trim().equalsIgnoreCase(""))
                    Inicial.setError("Informe o valor inicial.");

                if ( Mensal.getText().toString().trim().equalsIgnoreCase(""))
                    Mensal.setError("Informe o valor mensal.");

                if ( Meses.getText().toString().trim().equalsIgnoreCase(""))
                    Meses.setError("Informe o período em meses.");

                if ( Juros.getText().toString().trim().equalsIgnoreCase(""))
                    Juros.setError("Informe a taxa de juros anual.");

                else
                   {
                        double in = Integer.valueOf(Inicial.getText().toString());
                        double men = Integer.valueOf(Mensal.getText().toString());
                        double me = Integer.valueOf(Meses.getText().toString());
                        int ju = Integer.valueOf(Juros.getText().toString());

                        double inves = in + men * me;
                        double totalJurosCompostos = in * Math.pow((1 + ju/100), me);
                        double r = totalJurosCompostos - inves;
                        double total = inves + totalJurosCompostos;

                        DecimalFormat s = new DecimalFormat("R$,##0.00;");

                        tResultado.setText("Resultado");
                        TValorInvestido.setText("Valor investido: " + s.format(inves));
                        TTotalGanho.setText("Total ganho em juros: " + s.format(totalJurosCompostos));
                        tValorAcumulado.setText("Total acumulado: " + s.format(total));
                    }
            }
        });



        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return root;
    }
}