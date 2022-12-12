package com.fernandoherrera.recipedirectory.presentation.meal_search

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fernandoherrera.recipedirectory.databinding.ViewHolderSearchListBinding
import com.fernandoherrera.recipedirectory.domain.model.Meal
import java.util.stream.Collectors

class MealSearchAdapter : RecyclerView.Adapter<MealSearchAdapter.MyViewHolder>() {

    private var listener: ((Meal) -> Unit)? = null

    var list = mutableListOf<Meal>()
    var originalList = mutableListOf<Meal>()

    fun setContentList(list: MutableList<Meal>) {
        this.list = list
        originalList.addAll(list)
        notifyDataSetChanged()
    }

    class MyViewHolder(val viewHolder: ViewHolderSearchListBinding) :
        RecyclerView.ViewHolder(viewHolder.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MealSearchAdapter.MyViewHolder {
        val binding =
            ViewHolderSearchListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    fun itemClickListener(l: (Meal) -> Unit) {
        listener = l
    }

    override fun onBindViewHolder(holder: MealSearchAdapter.MyViewHolder, position: Int) {
        holder.viewHolder.meal = this.list[position]

        holder.viewHolder.root.setOnClickListener {
            listener?.let {
                it(this.list[position])
            }
        }

    }

    override fun getItemCount(): Int {
        return this.list.size
    }

    fun filter(strSearch: String){
        if (strSearch.isEmpty()){
            list.clear()
            list.addAll(originalList)
        }else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                list.clear()
                val collect :List<Meal> = originalList.stream().filter{
                    it.name.lowercase().contains(strSearch)
                            || it.ingredient1.lowercase().contains(strSearch)
                            || it.ingredient2.lowercase().contains(strSearch)
                            || it.ingredient3.lowercase().contains(strSearch)
                            || it.ingredient4.lowercase().contains(strSearch)
                            || it.ingredient5.lowercase().contains(strSearch) }
                    .collect(Collectors.toList())
                list.addAll(collect)
            } else{
                list.clear()
                for (i in originalList){
                   if (i.name.lowercase().contains(strSearch)){
                       list.add(i)
                   }
                }
            }
        }
        notifyDataSetChanged()
    }
}