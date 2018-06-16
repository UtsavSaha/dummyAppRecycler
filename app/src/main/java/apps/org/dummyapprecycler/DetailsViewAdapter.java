package apps.org.dummyapprecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


class DetailsViewAdapter extends RecyclerView.Adapter {


    private  Group groupDetails;

    DetailsViewAdapter(Group group){
        this.groupDetails  = group;

    }



    private class DetailsViewHolder extends RecyclerView.ViewHolder{

        TextView mTextView;
        TextView mRankTextView;

        public DetailsViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.details_item_text);
           // mRankTextView = itemView.findViewById(R.id.details_item_rank);
        }
    }

    private Context mContext;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup viewGroup, int viewType) {
        mContext = viewGroup.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.details_item,viewGroup,false);
        return new DetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Team currentTeam = getTeamByGroupPosition(position);
        DetailsViewHolder detailsViewHolder = (DetailsViewHolder) holder;
        detailsViewHolder.mTextView.setText(currentTeam.getTeamName());
       // detailsViewHolder.mRankTextView.setText(Integer.toString(currentTeam.getTeamRank()));

    }



    private Team getTeamByGroupPosition(int position) {
        return groupDetails.getTeams().get(position);
    }

    @Override
    public int getItemCount() {
        return  this.groupDetails.getTeams().size();
    }



}
