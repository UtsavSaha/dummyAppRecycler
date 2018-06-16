package apps.org.dummyapprecycler;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by UtsavSaha on 11/06/18.
 */

public class MasterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    List<Group> groups;

    MasterAdapter(List<Group> groups){
        this.groups = groups;
    }

    private class DetailsViewHolder extends RecyclerView.ViewHolder {

        RecyclerView detailsViewRecyclerItem;
        TextView groupNameView;

        public DetailsViewHolder(View itemView) {
            super(itemView);

            detailsViewRecyclerItem = (RecyclerView) itemView.findViewById(R.id.group_recycler_view);
            groupNameView  = itemView.findViewById(R.id.group_title);

            ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT){
                @Override
                public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                    int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
                    return makeMovementFlags(dragFlags,0);
                }

                @Override
                public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                    Log.i("Details Tag", "swipe gesture is disabled "+ direction);
                }

                @Override
                public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                    //Data to be moved
                    recyclerView.getAdapter().notifyItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
                    return true;
                }
            };

            ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
            itemTouchHelper.attachToRecyclerView(detailsViewRecyclerItem);

        }
    }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.group_view, parent , false);
        return new DetailsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DetailsViewHolder detailsViewHolder = (DetailsViewHolder) holder;

        Group currentGroup = groups.get(position);
        Collections.sort(currentGroup.getTeams());

        detailsViewHolder.groupNameView.setText(currentGroup.getGroupName());
        detailsViewHolder.detailsViewRecyclerItem.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        detailsViewHolder.detailsViewRecyclerItem.setLayoutManager(layoutManager);
        DetailsViewAdapter detailsViewAdapterAdapter = new DetailsViewAdapter(currentGroup);
        detailsViewHolder.detailsViewRecyclerItem.setAdapter(detailsViewAdapterAdapter);
        //detailsViewHolder.detailsViewRecyclerItem.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL));

    }

    @Override
    public int getItemCount() {
        return this.groups.size();
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mContext = recyclerView.getContext();
    }
}
