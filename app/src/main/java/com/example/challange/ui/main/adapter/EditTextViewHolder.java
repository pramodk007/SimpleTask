package com.example.challange.ui.main.adapter;

import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.challange.R;

public class EditTextViewHolder extends RecyclerView.ViewHolder {

    public EditText nameTextView;

    public EditTextViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.edit_text_input_digit);
    }
}
