package com.example.challange.ui.main.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.challange.R;
import com.example.challange.model.Digits;

import java.util.Collections;
import java.util.List;

public class EditTextAdapter extends RecyclerView.Adapter<EditTextViewHolder>{

    List<Digits> list = Collections.emptyList();
    Context context;
    ClickListiner listiner;

    public EditTextAdapter(Context context,List<Digits> list,ClickListiner listiner)
    {
        this.list = list;
        this.context = context;
        this.listiner = listiner;
    }

    @NonNull
    @Override
    public EditTextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View editTextView = inflater.inflate(R.layout.layout_item_edit_text, parent, false);

        EditTextViewHolder viewHolder = new EditTextViewHolder(editTextView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EditTextViewHolder holder, int position) {
        final int index = holder.getAdapterPosition();
        holder.nameTextView.setText(list.get(index).getNumber());
        holder.nameTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String digit = holder.nameTextView.getText().toString();
                if (!digit.equals("")) {
                    list.get(index).setNumber(digit);
                    listiner.click(list.get(index).getNumber());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}