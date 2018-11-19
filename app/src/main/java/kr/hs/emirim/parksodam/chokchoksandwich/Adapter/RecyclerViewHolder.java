package kr.hs.emirim.parksodam.chokchoksandwich.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import kr.hs.emirim.parksodam.chokchoksandwich.R;

/**
 * Created by Mirim on 2018-11-19.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    //public ImageView mBreadImage;
    public TextView mBreadName;
    public TextView mFirstPrice;
    public TextView mSecondPrice;
   // public ImageView mFavorite;
    public RecyclerViewHolder(View itemView) {
        super(itemView);
       // mBreadImage = (ImageView) itemView.findViewById(R.id.breadImage);
        mBreadName = (TextView) itemView.findViewById(R.id.breadName);
        mFirstPrice = (TextView) itemView.findViewById(R.id.firstPrice);
        mSecondPrice = (TextView) itemView.findViewById(R.id.secondPrice);
       // mFavorite = (ImageView) itemView.findViewById(R.id.favorite);
    }
}