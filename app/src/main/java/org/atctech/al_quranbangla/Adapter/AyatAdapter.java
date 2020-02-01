package org.atctech.al_quranbangla.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.atctech.al_quranbangla.Interface.OnItemClickListener;
import org.atctech.al_quranbangla.Model.Ayat;
import org.atctech.al_quranbangla.R;
import org.atctech.al_quranbangla.Utilities.Utils;

import java.util.ArrayList;
import java.util.List;

public class AyatAdapter extends RecyclerView.Adapter<AyatAdapter.AyatViewHolder> {

    private Context context;
    private ArrayList<Ayat> ayatList;


    public AyatAdapter(Context context, ArrayList<Ayat> ayatList) {
        this.context = context;
        this.ayatList = ayatList;
    }


    @NonNull
    @Override
    public AyatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_for_ayat, parent, false);
        return new AyatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AyatViewHolder holder, final int position) {

        holder.ayatArabic.setText(ayatList.get(position).getArabic_indopak());
        holder.ayatBanglaSpelling.setText(ayatList.get(position).getTrans());
        holder.ayatBanglaTranslation.setText(ayatList.get(position).getBn_muhi());
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "Siyamrupali.ttf");
        holder.ayatBanglaTranslation.setTypeface(typeface);
        holder.bnSuraSerial.setText(Utils.getBnNumber(ayatList.get(position).getVerse_id()));
        holder.bnSuraTranslateSerial.setText(Utils.getBnNumber(ayatList.get(position).getVerse_id()));
        holder.paraAndPageNo.setText(Utils.getBnNumber(ayatList.get(position).getPara() + "/" + ayatList.get(position).getPages()));

        SharedPreferences sharedPreferences = context.getSharedPreferences("LASTREADAYAT",Context.MODE_PRIVATE);

//        if (sharedPreferences.contains("AYAT_ID"))
//        {
//            int pos = Integer.parseInt(sharedPreferences.getString("AYAT_ID",null));
//
//            if (position == pos)
//            {
//                holder.row_ayat.setBackgroundColor(context.getResources().getColor(R.color.red));
//
//            }else
//            {
//                holder.row_ayat.setBackgroundColor(context.getResources().getColor(R.color.bookPageColor));
//            }
//        }

//
        if (position % 2 == 0) {
            holder.row_ayat.setBackgroundColor(context.getResources().getColor(R.color.offWhitePageColor));

        }else {
            holder.row_ayat.setBackgroundColor(context.getResources().getColor(R.color.bookPageColor));
        }


        holder.setItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v) {

                new AlertDialog.Builder(context)
                        .setTitle("Save")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences sharedPreferences = context.getSharedPreferences("LASTREADAYAT",Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("SURA_ID",ayatList.get(position).getSura_id());
                                editor.putString("AYAT_ID", String.valueOf(position));
                                editor.apply();
                            }
                        })
                        .setNegativeButton("no", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return ayatList != null ? ayatList.size() : 0;
    }

    public void setFilter(List<Ayat> teacherModel) {
        ayatList = new ArrayList<>();
        ayatList.addAll(teacherModel);
        notifyDataSetChanged();

    }

    public class AyatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView ayatArabic;
        public TextView ayatBanglaSpelling;
        public TextView ayatBanglaTranslation;
        public TextView bnSuraSerial;
        public TextView bnSuraTranslateSerial;
        public LinearLayout row_ayat;
        public TextView paraAndPageNo;
        public TextView bookmark;
        OnItemClickListener itemClickListener;

        public AyatViewHolder(View itemView) {
            super(itemView);

            ayatArabic = itemView.findViewById(R.id.arabicView);
            ayatBanglaSpelling = itemView.findViewById(R.id.spellingViewBangla);
            ayatBanglaTranslation = itemView.findViewById(R.id.banglaTranslated);
            bnSuraSerial = itemView.findViewById(R.id.surah_id);
            bnSuraTranslateSerial = itemView.findViewById(R.id.suraBnTranslateid);
            paraAndPageNo = itemView.findViewById(R.id.paraAndPageNo);
            row_ayat = itemView.findViewById(R.id.row_ayat);
            bookmark = itemView.findViewById(R.id.bookmark);

            itemView.setOnClickListener(this);

        }

        public void setItemClickListener(OnItemClickListener onItemClickListener)
        {
            this.itemClickListener = onItemClickListener;
        }


        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(v);

        }
    }
}
