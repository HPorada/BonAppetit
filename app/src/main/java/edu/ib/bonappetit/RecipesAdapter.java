package edu.ib.bonappetit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * RecipeAdapter class defintion
 */

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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

            text = (TextView) itemView.findViewById(R.id.txtListRecipe);

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

    private final List<Recipe> mRecipe;
    private final OnItemClickListener mOnClickListener;

    /**
     * RecipesAdapter constructor with parameters
     *
     * @param mRecipe          complete list of recipes
     * @param mOnClickListener
     */
    public RecipesAdapter(List<Recipe> mRecipe, OnItemClickListener mOnClickListener) {
        this.mRecipe = mRecipe;
        this.mOnClickListener = mOnClickListener;
    }

    /**
     * Overriden method onCreateViewHolder
     *
     * @param parent
     * @param viewType
     * @return RecipeAdapter.ViewHolder
     */
    @Override
    public RecipesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View recipeView = inflater.inflate(R.layout.item_recipe, parent, false);

        return new ViewHolder(recipeView, mOnClickListener);
    }

    /**
     * Overriden method onBindViewHolder
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecipesAdapter.ViewHolder holder, int position) {
        Recipe recipe = mRecipe.get(position);

        TextView textView = holder.text;
        textView.setText(recipe.getName());
    }

    /**
     * Overriden method getItemCount
     *
     * @return size of recipes list as int
     */
    @Override
    public int getItemCount() {
        return mRecipe.size();
    }
}