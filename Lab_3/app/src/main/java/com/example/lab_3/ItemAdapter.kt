package com.example.lab_3
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter(private val items: List<ListItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // ViewHolder для заголовків
    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.headerTitle)
    }

    // ViewHolder для контенту
    class ContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.itemTitle)
        val description: TextView = itemView.findViewById(R.id.itemDescription)
    }

    // Визначення типу елемента (заголовок або контент)
    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ListItem.Header -> 0
            is ListItem.Content -> 1
        }
    }

    // Створення ViewHolder для конкретного типу елемента
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.head_layout, parent, false)
            HeaderViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout, parent, false)
            ContentViewHolder(view)
        }
    }

    // Зв'язування даних з ViewHolder
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is ListItem.Header -> {
                val headerHolder = holder as HeaderViewHolder
                headerHolder.title.text = item.title
            }
            is ListItem.Content -> {
                val contentHolder = holder as ContentViewHolder
                contentHolder.title.text = item.title
                contentHolder.description.text = item.description
            }
        }
    }

    // Повернення кількості елементів у списку
    override fun getItemCount(): Int = items.size
}
