package raydingoz.cerrahpaadmin;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Kumanya extends AppCompatActivity {
    public  EditText etTarih,etKumanya;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kumanya);
        
        etTarih = (EditText)findViewById(R.id.etTarih);
        etKumanya = (EditText)findViewById(R.id.etKumanya);
    }

    private void Gonder() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference c1 = database.getReference("kumanya");

        DatabaseReference cp2 = c1.child(etTarih.getText().toString());
        DatabaseReference cpm = cp2.child("kumanya");
        cpm.setValue(etKumanya.getText().toString());
    }

}
