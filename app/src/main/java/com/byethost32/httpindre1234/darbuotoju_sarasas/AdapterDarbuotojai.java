package com.byethost32.httpindre1234.darbuotoju_sarasas;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Collections;
import java.util.List;

public class AdapterDarbuotojai extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<Darbuotojai> data= Collections.emptyList();
    Darbuotojai current;
    int currentPos=0;

    // create constructor to initialize context and data sent from MainActivity
    public AdapterDarbuotojai(Context context, List<Darbuotojai> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when ViewHolder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.container_darbuotojai, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //public Darbuotojai(String id, String vartotojas, String iraso_sukurimo_data, String vardas,
        // String pavarde, String asmens_kodas, String pareigos, String atlyginimas, String v_data, String lytis)
        // Get current position of item in RecyclerView to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        Darbuotojai current=data.get(position);
        myHolder.textVardas.setText(current.getVardas());
        myHolder.textPavarde.setText("Pavardė: " + current.getPavarde());
        myHolder.textAtlyginimas.setText("Atlyginimas: " + current.getAtlyginimas());
        myHolder.textV_data.setText("Vertinimo data: " + current.getV_data());
        myHolder.textID.setText("ID: " + current.getId());
    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textVardas;
        TextView textPavarde;
        TextView textAtlyginimas;
        TextView textV_data;
        TextView textID;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            textVardas = (TextView) itemView.findViewById(R.id.textVardas);
            textPavarde = (TextView) itemView.findViewById(R.id.textPavarde);
            textAtlyginimas = (TextView) itemView.findViewById(R.id.textAtlyginimas);
            textV_data = (TextView) itemView.findViewById(R.id.textV_data);
            textID = (TextView) itemView.findViewById(R.id.textID);
            itemView.setOnClickListener(this);
        }

        // Click event for all items
        @Override
        public void onClick(View v) {

            Toast.makeText(context, "Jūs pažymėjote darbuotoja", Toast.LENGTH_SHORT).show();

        }

    }

}
