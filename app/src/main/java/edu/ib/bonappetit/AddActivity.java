package edu.ib.bonappetit;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * AddActivity class definition
 */

public class AddActivity extends AppCompatActivity {

    public static final String FOLDERNAME = "SavedRecipes";

    /**
     * Overriden method onCreate
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    /**
     * Method onSaveClick - handles user's activity of clicking the Save the Recipe button
     *
     * @param view
     */
    public void onSaveClick(View view) {
        EditText edt1 = (EditText) findViewById(R.id.edtName);
        String name = edt1.getText().toString();

        EditText edt2 = (EditText) findViewById(R.id.edtInstructions);
        String body = edt2.getText().toString();

        if (name != null && !name.isEmpty() && body != null && !body.isEmpty()) {
            File myExternalFile = new File(getExternalFilesDir(FOLDERNAME), name);

            try (FileOutputStream os = new FileOutputStream(myExternalFile)) {
                os.write(body.getBytes());
                os.close();
                Toast.makeText(this, "Recipe saved.", Toast.LENGTH_LONG).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Something went wrong. Try again.", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Meal Name and/or Instructions can't be empty.", Toast.LENGTH_LONG).show();

        }
    }
}
