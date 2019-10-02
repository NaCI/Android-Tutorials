package com.example.naci.retrofitsample.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.naci.retrofitsample.R;
import com.example.naci.retrofitsample.network.model.NumberData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterNumberData extends RecyclerView.Adapter<AdapterNumberData.ViewHolder> {

    private List<NumberData> numberDataList;

    public AdapterNumberData(List<NumberData> numberDataList) {
        this.numberDataList = numberDataList;
    }

    public void addNewNumber(NumberData numberData) {
        if (numberDataList != null) {
            numberDataList.add(numberData);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_number_data, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        NumberData numberData = numberDataList.get(position);
        viewHolder.setData(numberData);
    }

    @Override
    public int getItemCount() {
        return numberDataList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.itemNumberData_tvNumber)
        TextView tvNumber;
        @BindView(R.id.itemNumberData_tvInfo)
        TextView tvInfo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setData(NumberData numberData) {
            tvNumber.setText(String.valueOf(numberData.getNumber()));
            tvInfo.setText(numberData.getText());
        }
    }
}
