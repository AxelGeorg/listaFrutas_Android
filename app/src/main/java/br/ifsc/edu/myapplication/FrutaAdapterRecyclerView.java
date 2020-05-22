package br.ifsc.edu.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

class FrutaAdapterRecyclerView extends RecyclerView.Adapter<FrutaAdapterRecyclerView.MyViewHolder> {


    Context mContext;
    int mResource;
    Fruta[] mDataSet;

    public FrutaAdapterRecyclerView(Context mContext, int mResource, Fruta[] mDataSet) {
        this.mContext = mContext;
        this.mResource = mResource;
        this.mDataSet = mDataSet;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



        //Criando  propriedade LayoutInflater
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View convertView = layoutInflater.inflate(mResource,parent,false);

        MyViewHolder myViewHolder = new MyViewHolder(convertView);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Fruta fruta = mDataSet[position];

        NumberFormat nf = new DecimalFormat("#,###.00");

        holder.tvCodigo.setText(Integer.toString(fruta.getCodigo()));
        holder.tvNome.setText(fruta.getNome());
        holder.tvPreco.setText(nf.format (fruta.getPreco()));
        holder.tvPrecoVenda.setText(nf.format (fruta.getPreco_venda()));
        holder.imgView.setImageResource(fruta.getImagem());
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvCodigo;
        TextView tvNome;
        TextView tvPreco;
        TextView tvPrecoVenda;
        ImageView imgView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            tvCodigo = (TextView) itemView.findViewById(R.id.tvCodigo);
            tvNome = (TextView) itemView.findViewById(R.id.tvNome);
            tvPreco =  (TextView) itemView.findViewById(R.id.tvPreco);
            tvPrecoVenda =(TextView) itemView.findViewById(R.id.tvPrecoVenda);
            imgView = (ImageView) itemView.findViewById(R.id.imageView);

        }
    }
}
