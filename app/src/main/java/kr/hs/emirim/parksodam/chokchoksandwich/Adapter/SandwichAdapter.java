package kr.hs.emirim.parksodam.chokchoksandwich.Adapter;


import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import kr.hs.emirim.parksodam.chokchoksandwich.R;

/**
 * Created by Mirim on 2018-11-19.
 */

public class SandwichAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private ArrayList<SandwichItem> mItems;
    private Context mContext;

    public SandwichAdapter(ArrayList<SandwichItem> mItems) {
        this.mItems = mItems;
    }


    public SandwichAdapter(ArrayList<SandwichItem> mItems, Context mContext) {
        this.mItems = mItems;
        this.mContext = mContext;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row, parent, false);
        mContext = parent.getContext();
        RecyclerViewHolder holder = new RecyclerViewHolder(view);
        return holder;
    }
    // 필수 오버라이드 : 재활용되는 View 가 호출, Adapter 가 해당 position 에 해당하는 데이터를 결합
    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        // 해당 position 에 해당하는 데이터 결합
        holder.mBreadName.setText(mItems.get(position).getBreadName());
        holder.mFirstPrice.setText(mItems.get(position).getFirstPrice());
        holder.mSecondPrice.setText(mItems.get(position).getSecondPrice());

        // 이벤트처리 : 생성된 List 중 선택된 목록번호를 Toast로 출력
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, String.format("%d 선택", position + 1), Toast.LENGTH_SHORT).show();
            }
        });
    }
    // 필수 오버라이드 : 데이터 갯수 반환
    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
