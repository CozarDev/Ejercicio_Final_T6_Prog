package com.example.ejercicio_final_t6_prog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorLugares extends RecyclerView.Adapter<AdaptadorLugares.CeldaLugar> {


    private ArrayList<Lugar> listado;

    public AdaptadorLugares(ArrayList<Lugar> listado) {
        this.listado = listado;
    }

    @NonNull
    @Override
    public CeldaLugar onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View vista = inflater.inflate(R.layout.celda, parent, false);
        return new CeldaLugar(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull CeldaLugar holder, int position) {
        Lugar lugar = listado.get(position);
        holder.tvLugar.setText(lugar.getNombre());
        holder.tvDescripcion.setText(lugar.getDescripcion());
    }

    @Override
    public int getItemCount() {
        return listado.size();
    }

    static class CeldaLugar extends RecyclerView.ViewHolder {
        TextView tvLugar, tvDescripcion;

        public CeldaLugar (@NonNull View itemView) {
            super(itemView);
            tvLugar = itemView.findViewById(R.id.textViewLugar);
            tvDescripcion = itemView.findViewById(R.id.textViewDescripcion);
        }
    }

    public void aniadirLugar (Lugar lugar){
        listado.add(lugar);
        notifyDataSetChanged();
    }
}
