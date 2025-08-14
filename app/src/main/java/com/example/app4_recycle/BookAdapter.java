package com.example.app4_recycle;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Book> books;

    public BookAdapter(Context context, ArrayList<Book> books) {
        this.context = context;
        this.books = books;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Book book = books.get(position);
        holder.tvTitle.setText(book.getTitle());
        holder.tvAuthor.setText(book.getAuthor());
        holder.tvYear.setText(book.getYear());
        holder.imgBook.setImageResource(R.drawable.ic_book);

        holder.cardView.setOnClickListener(v -> {
            Toast.makeText(context, "Membuka: " + book.getTitle(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("title", book.getTitle());
            intent.putExtra("author", book.getAuthor());
            intent.putExtra("year", book.getYear());
            context.startActivity(intent);
        });

        holder.btnDelete.setOnClickListener(v -> {
            new AlertDialog.Builder(context)
                    .setTitle("Hapus Buku")
                    .setMessage("Yakin ingin menghapus \"" + book.getTitle() + "\"?")
                    .setPositiveButton("Ya", (dialog, which) -> {
                        books.remove(position);
                        notifyItemRemoved(position);
                        Toast.makeText(context, "Buku dihapus", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Batal", null)
                    .show();
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvAuthor, tvYear;
        ImageView imgBook;
        ImageButton btnDelete;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvYear = itemView.findViewById(R.id.tvYear);
            imgBook = itemView.findViewById(R.id.imgBook);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
