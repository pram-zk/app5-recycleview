package com.example.app4recycle

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app4_recycle.R
import com.example.app4_recycle.detail

class BookAdapter(private val context: Context, private val bookList: ArrayList<Book>) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = bookList[position]
        holder.tvTitle.text = book.title
        holder.tvAuthor.text = book.author
        holder.tvYear.text = book.year.toString()

        holder.itemView.setOnClickListener {

            AlertDialog.Builder(context)
                .setTitle("Lihat Detail?")
                .setMessage("Ingin melihat detail dari ${book.title}?")
                .setPositiveButton("Lihat") { _, _ ->
                    val intent = Intent(context, detail::class.java)
                    intent.putExtra("judul", book.title)
                    intent.putExtra("author", book.author)
                    intent.putExtra("year", book.year)
                    context.startActivity(intent)
                }
                .setNegativeButton("Batal",null)
                .show()
        }
    }

    override fun getItemCount(): Int = bookList.size

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvAuthor: TextView = itemView.findViewById(R.id.tvAuthor)
        val tvYear: TextView = itemView.findViewById(R.id.tvYear)
    }
}
