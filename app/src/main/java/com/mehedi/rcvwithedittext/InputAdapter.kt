package com.mehedi.rcvwithedittext

import android.annotation.SuppressLint
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mehedi.rcvwithedittext.databinding.ItemEditBinding

class InputAdapter(
    private val list: List<String>,
    private val listener: OnTextChangeWithPosition
) :
    RecyclerView.Adapter<InputAdapter.VH>() {
    private lateinit var context: Context

    interface OnTextChangeWithPosition {

        fun inputText(title: String, inputText: String, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        context = parent.context
        return VH(ItemEditBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VH, @SuppressLint("RecyclerView") position: Int) {

        list[position].let {
            holder.binding.apply {
                txtTitle.text = it
                etInput.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(
                        s: CharSequence?,
                        start: Int,
                        count: Int,
                        after: Int
                    ) {

                    }

                    override fun onTextChanged(
                        s: CharSequence?,
                        start: Int,
                        before: Int,
                        count: Int
                    ) {

                        listener.inputText(it, s.toString(), position)

                    }

                    override fun afterTextChanged(s: Editable?) {

                    }

                })


            }


        }


    }

    class VH(val binding: ItemEditBinding) : RecyclerView.ViewHolder(binding.root)
}