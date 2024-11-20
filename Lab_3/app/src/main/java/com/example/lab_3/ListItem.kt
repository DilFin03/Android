package com.example.lab_3

sealed class ListItem {
    data class Header(val title: String) : ListItem()
    data class Content(val title: String, val description: String) : ListItem()
}
