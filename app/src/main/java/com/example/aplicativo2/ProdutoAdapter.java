package com.example.aplicativo2;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class ProdutoAdapter extends ArrayAdapter<Produto> {
    private int rId;

    public ProdutoAdapter(Context context, int resource, List<Produto> objects){
        super(context,resource,objects);
        rId = resource;
}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View mView = convertView;

        if(mView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(rId,null);
        }

        Produto produto = getItem(position);

        TextView nome = mView.findViewById(R.id.nome);
        TextView quantidade = mView.findViewById(R.id.quantidade);

        nome.setText(produto.getNome());
        quantidade.setText(String.valueOf(produto.getQuantidade()));


        if (produto.isPrioridade()){
            nome.setTextColor(Color.RED);
            quantidade.setTextColor(Color.RED);
        }

        return mView;
    }
}
