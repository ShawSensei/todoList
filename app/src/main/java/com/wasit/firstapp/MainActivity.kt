package com.wasit.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter:TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoAdapter = TodoAdapter(mutableListOf())

        val rvTodoItems: RecyclerView = findViewById(R.id.rvTodoItems)
        // Now you can use rvTodoItems as you need, such as setting up an adapter or handling click events.
        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        val btnAddTodo: Button = findViewById(R.id.btnAddTodo)
        btnAddTodo.setOnClickListener {
            val etTodoTitle = findViewById<TextView>(R.id.etTodoTitle)
            val todoTitle = etTodoTitle.text.toString()
            if(todoTitle.isNotEmpty()){
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                etTodoTitle.text = null // Clear the text in the EditText
            }
        }


        val btnDeleteTodo: Button = findViewById(R.id.btnDeleteTodo)
        btnDeleteTodo.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }



    }
}

