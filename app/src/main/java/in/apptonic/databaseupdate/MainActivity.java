package in.apptonic.databaseupdate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText surname;
    Button submit;
    TextView nameDisplay;
    TextView surnameDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.upper);
        surname = (EditText) findViewById(R.id.lower);
        submit = (Button) findViewById(R.id.Update);
        nameDisplay = (TextView) findViewById(R.id.displayName);
        surnameDisplay = (TextView) findViewById(R.id.displaySurname);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("user");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User data = dataSnapshot.getValue(User.class);
                    nameDisplay.setText(data.name);
                    surnameDisplay.setText(data.surname);

                Toast.makeText(getApplicationContext(), "database updated", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tempName = name.getText().toString();
                String tempSurname = surname.getText().toString();

                User user = new User(tempName, tempSurname);

             //   myRef.setValue(user);
                myRef.push().setValue(user);



            }
        });
    }
}
