package edu.ib.bonappetit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * MealsAdapter class definiton
 */

public class MealsAdapter extends RecyclerView.Adapter<MealsAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView image;
        public TextView text;
        OnItemClickListener listener;

        /**
         * ViewHolder constructor
         *
         * @param itemView
         * @param onItemClickListener
         */
        public ViewHolder(View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.imgListMeal);
            text = (TextView) itemView.findViewById(R.id.txtListMeal);

            this.listener = onItemClickListener;
            itemView.setOnClickListener(this);
        }

        /**
         * Overriden method onClick
         *
         * @param v
         */
        @Override
        public void onClick(View v) {
            listener.onItemClick(v, getLayoutPosition());
        }
    }

    private final List<Meal> mMeal;
    private final OnItemClickListener mOnClickListener;

    /**
     * MealsAdapter constructorv with parameters
     *
     * @param mMeal complete list of meals
     * @param mOnClickListener
     */
    public MealsAdapter(List<Meal> mMeal, OnItemClickListener mOnClickListener) {
        this.mMeal = mMeal;
        this.mOnClickListener = mOnClickListener;
    }

    /**
     * Overriden method onCreateCiewHolder
     *
     * @param parent
     * @param viewType
     * @return MealsAdapter.ViewHolder
     */
    @Override
    public MealsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View mealView = inflater.inflate(R.layout.item_meal, parent, false);

        return new ViewHolder(mealView, mOnClickListener);
    }

    /**
     * Overriden method onBindViewHolder
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MealsAdapter.ViewHolder holder, int position) {
        Meal meal = mMeal.get(position);

        ImageView imageView = holder.image;
        Picasso.get()
                .load(meal.getStrMealThumb())
                .resize(100, 100)
                .into(imageView);

        TextView textView = holder.text;
        textView.setText("\t" + meal.getStrMeal());
    }

    /**
     * Overriden method getItemCount
     *
     * @return size of meals list as int
     */
    @Override
    public int getItemCount() {
        return mMeal.size();
    }
}
