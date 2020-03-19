package com.reloader.classroomdeveloper.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.reloader.classroomdeveloper.Entidades.MCursos;
import com.reloader.classroomdeveloper.R;
import com.reloader.classroomdeveloper.interfaces.OnCursosListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapterCursos extends RecyclerView.Adapter<RecyclerAdapterCursos.MyViewHolder> {

    private Context context;
    private List<MCursos> mCursosList;

    private OnCursosListener onCursosListener;

    public void setOnCursosListener(OnCursosListener onCursosListener) {
        this.onCursosListener = onCursosListener;
    }

    public RecyclerAdapterCursos(Context context, List<MCursos> mCursosList) {
        this.context = context;
        this.mCursosList = mCursosList;
    }

    @NonNull
    @Override
    public RecyclerAdapterCursos.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(context);
        view = mInflater.inflate(R.layout.item_cursos, parent, false);
        return new MyViewHolder(view, onCursosListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterCursos.MyViewHolder holder, int position) {

        holder.txtTitulo.setText(mCursosList.get(position).getName());
        holder.txtDescripcion.setText(mCursosList.get(position).getSection());
    }

    @Override
    public int getItemCount() {
        return mCursosList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitulo;
        TextView txtDescripcion;
        TextView txtTema;
        LinearLayout lnhead;

        public MyViewHolder(@NonNull View itemView, final OnCursosListener onCursosListener) {
            super(itemView);

            txtTitulo = itemView.findViewById(R.id.txt_titulo);
            txtDescripcion = itemView.findViewById(R.id.txt_descripcion);
            txtTema = itemView.findViewById(R.id.txt_tema);
            lnhead = itemView.findViewById(R.id.ln_head);

            lnhead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int posicion = getAdapterPosition();
                    onCursosListener.onCursosTitleClicked(posicion);
                }
            });


//            txtTitulo.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//
//                }
//            });

        }
    }

}
