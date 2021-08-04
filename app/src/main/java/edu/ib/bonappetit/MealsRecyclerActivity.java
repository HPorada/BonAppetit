package edu.ib.bonappetit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * MealsRecyclerActivity class definition
 */

public class MealsRecyclerActivity extends AppCompatActivity implements OnItemClickListener {

    ArrayList<Meal> mealList;

    /**
     * Overriden method onCreate
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_meals);

        mealList = MainActivity.meals;
        Collections.sort(mealList);

        RecyclerView rvMeals = findViewById(R.id.rvAreasList);
        rvMeals.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.Adapter adapter = new MealsAdapter(mealList, this);

        rvMeals.setLayoutManager(layoutManager);
        rvMeals.setAdapter(adapter);
    }

    /**
     * Overriden method onItemClick
     *
     * @param view
     * @param position position of the clicked item
     */
    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this, MealActivity.class);
        intent.putExtra("MealExtra", mealList.get(position));
        startActivity(intent);
    }

    /**
     * Method onSearchClick - allows searching a Meal by name
     *
     * @param view
     */
    public void onSearchClick(View view) {
        EditText edt = (EditText) findViewById(R.id.edtSearch);

        String search = edt.getText().toString();

        Meal meal = new Meal();

        for (int i = 0; i < mealList.size(); i++) {
            if (search.equals(mealList.get(i).getStrMeal())) {
                meal = mealList.get(i);
                Intent intent = new Intent(this, MealActivity.class);
                intent.putExtra("MealExtra", meal);
                startActivity(intent);
            }
        }
    }
}
