package raydingoz.cerrahpaadmin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    public EditText  etPazT, etPazM ,etSalM, etSalT, etCarT,etCarM,etPerM,etPerT, etCumT, etCumM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etPazT = (EditText)findViewById(R.id.etPazartesiT);
        etPazM = (EditText)findViewById(R.id.etPazartesiM);
        etSalM = (EditText)findViewById(R.id.etSaliM);
        etSalT = (EditText)findViewById(R.id.etSaliT);
        etCarM = (EditText)findViewById(R.id.etCarsambaM);
        etCarT = (EditText)findViewById(R.id.etCArsambaT);
        etPerM = (EditText)findViewById(R.id.etPersembeM);
        etPerT = (EditText)findViewById(R.id.etPersembeT);
        etCumM = (EditText)findViewById(R.id.etCumaM);
        etCumT = (EditText)findViewById(R.id.etCumaT);

        veriAl();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Menu Güncellendi", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Gonder();
            }
        });
    }

    private void veriAl() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference c1 = database.getReference("kumanya");

        DatabaseReference cp2 = c1.child("pazartesi");
        cp2.child("tarih").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                etPazT.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        cp2.child("menu").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                etPazM.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        DatabaseReference cs2 = c1.child("sali");
        cs2.child("tarih").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                etSalT.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        cs2.child("menu").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                etSalM.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        DatabaseReference cc2 = c1.child("carsamba");
        cc2.child("tarih").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                etCarT.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        cc2.child("menu").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                etCarM.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        DatabaseReference cpe2 = c1.child("persembe");
        cpe2.child("tarih").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                etPerT.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        cpe2.child("menu").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                etPerM.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        DatabaseReference cu2 = c1.child("cuma");
        cu2.child("tarih").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                etCumT.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        cu2.child("menu").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                etCumM.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }

    private void Gonder() {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference c1 = database.getReference("kumanya");

        DatabaseReference cp2 = c1.child("pazartesi");
        DatabaseReference cpt = cp2.child("tarih");
        DatabaseReference cpm = cp2.child("menu");
        cpt.setValue(etPazT.getText().toString());
        cpm.setValue(etPazM.getText().toString());
        DatabaseReference cp2X = c1.child(etPazT.getText().toString());
        DatabaseReference cpmX = cp2X.child("kumanya");
        cpmX.setValue(etPazM.getText().toString());


        DatabaseReference cs2 = c1.child("sali");
        DatabaseReference cst = cs2.child("tarih");
        DatabaseReference csm = cs2.child("menu");
        cst.setValue(etSalT.getText().toString());
        csm.setValue(etSalM.getText().toString());
        DatabaseReference cs2X = c1.child(etSalT.getText().toString());
        DatabaseReference csmX = cs2X.child("kumanya");
        csmX.setValue(etSalM.getText().toString());

        DatabaseReference cc2 = c1.child("carsamba");
        DatabaseReference cct = cc2.child("tarih");
        DatabaseReference ccm = cc2.child("menu");
        cct.setValue(etCarT.getText().toString());
        ccm.setValue(etCarM.getText().toString());
        DatabaseReference cc2X = c1.child(etCarT.getText().toString());
        DatabaseReference ccmX = cc2X.child("kumanya");
        ccmX.setValue(etCarM.getText().toString());

        DatabaseReference cpe2 = c1.child("persembe");
        DatabaseReference cpet = cpe2.child("tarih");
        DatabaseReference cpem = cpe2.child("menu");
        cpet.setValue(etPerT.getText().toString());
        cpem.setValue(etPerM.getText().toString());
        DatabaseReference cpe2X = c1.child(etPerT.getText().toString());
        DatabaseReference cpemX = cpe2X.child("kumanya");
        cpemX.setValue(etPerM.getText().toString());

        DatabaseReference cu2 = c1.child("cuma");
        DatabaseReference cut = cu2.child("tarih");
        DatabaseReference cum = cu2.child("menu");
        cut.setValue(etCumT.getText().toString());
        cum.setValue(etCumM.getText().toString());
        DatabaseReference cu2X = c1.child(etCumT.getText().toString());
        DatabaseReference cumX = cu2X.child("kumanya");
        cumX.setValue(etCumM.getText().toString());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.tarihayar){
            Intent i=new Intent();i.setClass(getApplicationContext(),Kumanya.class);startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
