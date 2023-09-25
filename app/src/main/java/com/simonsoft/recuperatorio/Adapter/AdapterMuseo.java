package com.simonsoft.recuperatorio.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.resources.TextAppearanceConfig;
import com.simonsoft.recuperatorio.Modelo.Museo;
import com.simonsoft.recuperatorio.R;

import java.util.List;

public class AdapterMuseo extends RecyclerView.Adapter<AdapterMuseo.ViewHolder> {
    private List<Museo> museos;
    private Context context;
    private LayoutInflater li;



    public AdapterMuseo(List<Museo> museos, Context context, LayoutInflater li) {
        this.museos = museos;
        this.context = context;
        this.li = li;
    }

    @NonNull
    @Override
    public AdapterMuseo.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.lista_de_museo,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull AdapterMuseo.ViewHolder holder, int position) {
        holder.nombre.setText(museos.get(position).getNombre());
        holder.direccion.setText(museos.get(position).getDireccion());


    }

    @Override
    public int getItemCount() {
        return museos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre;
        private TextView direccion;

        public ViewHolder(@NonNull View view) {
            super(view);
            nombre = itemView.findViewById(R.id.tvNombre);
            direccion = itemView.findViewById(R.id.tvDireccion);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("museo", museos.get(getAbsoluteAdapterPosition()));
                    Navigation.findNavController(view).navigate(R.id.detalleFragment,bundle);
                }
            });
        }
    }
}
