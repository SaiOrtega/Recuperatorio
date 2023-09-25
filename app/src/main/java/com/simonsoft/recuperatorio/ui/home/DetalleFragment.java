package com.simonsoft.recuperatorio.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simonsoft.recuperatorio.Modelo.Museo;
import com.simonsoft.recuperatorio.R;
import com.simonsoft.recuperatorio.databinding.FragmentDetalleBinding;


public class DetalleFragment extends Fragment {

     private FragmentDetalleBinding binding;



    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,
                              Bundle savedInstanceState) {
        binding = FragmentDetalleBinding.inflate(inflater, container,false);
        View root = binding.getRoot();

        Bundle bundle = getArguments();
        Museo museo = (Museo) bundle.getSerializable("museo");
        binding.tvHorario.setText("El horario de apertura es : "+museo.getHorario());
        binding.tvTelefono.setText("Puede llamarnos al: "+museo.getTelefono());
        return root;

    }



}