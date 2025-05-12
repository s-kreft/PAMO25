package com.example.bmiapp.ui.calories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.example.bmiapp.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ViewHolder> {
    private List<ShoppingItem> itemList;

    public ShoppingAdapter(List<ShoppingItem> itemList) {
        this.itemList = itemList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox itemCheckbox;
        TextView itemName;

        public ViewHolder(View itemView) {
            super(itemView);
            itemCheckbox = itemView.findViewById(R.id.item_checkbox);
            itemName = itemView.findViewById(R.id.item_name);
        }
    }

    @NonNull
    @Override
    public ShoppingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shopping, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingAdapter.ViewHolder holder, int position) {
        ShoppingItem item = itemList.get(position);
        holder.itemName.setText(item.getName());
        holder.itemCheckbox.setChecked(item.isChecked());

        holder.itemCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            item.setChecked(isChecked);
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
