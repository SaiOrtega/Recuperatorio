package com.simonsoft.recuperatorio.ui.home;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.simonsoft.recuperatorio.Modelo.Museo;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    private Context context;
    private MutableLiveData<List<Museo>> listaMutable;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
    }
    public LiveData<List<Museo>> getlistaMutable(){
        if(listaMutable == null){
            listaMutable = new MutableLiveData<>();
        }
        return listaMutable;
    }
    public void armarLista(){
        List<Museo> listaMuseos = new ArrayList<>();
        listaMuseos.add(new Museo("Muhsal San luis","San Martin 611","02664452000","08:00 - 20:00"));
        listaMuseos.add(new Museo("Museo Dora Ochoa de Masramón","Colón 508","0266555454","08:00 -20:00"));
        listaMuseos.add(new Museo("Museo Puente Blanco","Av.vial","02666545445","08:00 - 200:00"));
        listaMuseos.add(new Museo("Museo Catedral","San Martin 123","26665445","08:00 -20:00"));

        listaMutable.setValue(listaMuseos);

    }
}
