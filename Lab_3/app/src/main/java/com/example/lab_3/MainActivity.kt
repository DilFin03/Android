package com.example.lab_3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Встановлюємо макет для активності
        setContentView(R.layout.activity_main)

        // Знаходимо RecyclerView за ID
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        // Встановлюємо LayoutManager для відображення списку
        recyclerView.layoutManager = LinearLayoutManager(this)
       // val itemList = listOf(
        //    Item("Заголовок 1", "Опис 1"),
        //    Item("Заголовок 2", "Опис 2"),
        //    Item("Заголовок 3", "Опис 3"),
        //    Item("Заголовок 4", "Опис 4")
        //)
        //recyclerView.adapter = ItemAdapter(itemList)
        val mixedItemList = listOf(
            ListItem.Header("Розділ 1"),
            ListItem.Content("Елемент 1", "Опис 1"),
            ListItem.Content("Елемент 2", "Опис 2"),
            ListItem.Header("Розділ 2"),
            ListItem.Content("Елемент 3", "Опис 3")
        )
        recyclerView.adapter = ItemAdapter(mixedItemList)


    }
}
