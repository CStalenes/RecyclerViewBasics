package com.example.recyclerviewbasics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


//on fait ca pour cree un adapter personnaliser cad que pour un model (image+titre+description) adapté a notre RecycleView on pourra cree avec MyVHolder
//un scroll avec le meme modèle afin d'avoir plus de facilité dans la structure de class et comprehension

//MyReVA est le chemin
public class MyRecyclerVerticalAdapter extends RecyclerView.Adapter<MyRecyclerVerticalAdapter.MyViewHolder> {
    //si on met pas MyReVertAda... on cree la class MyViewHol au meme niv que fic MyReVeAd

    //Tjrs mettre context en 1er param du constructor
    private Context context;
    private String[] interns, descriptions;
    private int[] avatars;


    //deplacement crl+maj(shift)+fleche

    //Tjrs cree

    public MyRecyclerVerticalAdapter() {
    }

    public MyRecyclerVerticalAdapter(Context context, String[] interns, String[] descriptions, int[] avatars) {
        this.context = context;
        this.interns = interns;
        this.descriptions = descriptions;
        this.avatars = avatars;
    }

    //coup de contexte pour lui dire où se placer dans l Activité


    @NonNull
    @Override
    public MyRecyclerVerticalAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //ctx = recyV dans activity
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_recycler_vertical, parent, false);
        //le viewGroup = RecyclerView car ca regroupe l ensemble des item d'ou le parent dans param ligne 49
        return new MyViewHolder(view);
        //que vas tu reinjecter a chaque ViewHolder eh ben la vue
    }
    //associe le layout au viewholder

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerVerticalAdapter.MyViewHolder holder, int position) {
        //holder = elem de la vue
        //a chaque scroll il faut qu on sache a quelle position on est passé cad tab pour tiltle, tab pour desc, tab pour avatar
        //car entre interface homme machine il y a des int d'ou les tab

        /**
         * On use obj holder qui herite de MyRVH pour peupler nos item
         * Ajout du txt
         */
        holder.tvTitle.setText(interns[position]);
        holder.tvDescription.setText(descriptions[position]);
        /** Ajout img setR**/
        holder.ivAvatar.setImageResource(avatars[position]);

    }
    //lie une data de chaque case correspondante a chacune des lignes

    //recycle nbre item visible fini
    @Override
    public int getItemCount() {
        /** Nbr item de la lst **/
        return avatars.length;
    }



    //ViewHolder permet de lié le design au code Java
    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivAvatar;
        TextView tvTitle, tvDescription;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //comme vue holder lie design java pour un item alors on tape
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
            tvTitle = itemView.findViewById(R.id.tv_title);
            //on met juste D avant T de tvTitle ligne 48 copier et on TAb pour avoir Description ss perdre de temps a réecrire
            tvDescription = itemView.findViewById(R.id.tv_description);
        }
    }
}
