package com.simonsoft.recuperatorio.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.simonsoft.recuperatorio.Adapter.AdapterMuseo;
import com.simonsoft.recuperatorio.Modelo.Museo;
import com.simonsoft.recuperatorio.R;
import com.simonsoft.recuperatorio.databinding.FragmentHomeBinding;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);

        View root = binding.getRoot();

       homeViewModel.getlistaMutable().observe(getViewLifecycleOwner(), new Observer<List<Museo>>() {
           @Override
           public void onChanged(List<Museo> museos) {
               RecyclerView rv = binding.recyclerViewMuseo;
               GridLayoutManager glm = new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false);
               rv.setLayoutManager(glm);

               AdapterMuseo iad = new AdapterMuseo(museos,getContext(),getLayoutInflater());
               rv.setAdapter(iad);
           }
       });
       homeViewModel.armarLista();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}