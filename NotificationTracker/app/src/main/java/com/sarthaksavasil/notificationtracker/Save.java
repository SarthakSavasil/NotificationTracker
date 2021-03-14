//package com.sarthaksavasil.notificationtracker;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.Spinner;
//import android.widget.Toast;
//
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Save extends AppCompatActivity {
//
//    //we will use these constants later to pass the artist name and id to another activity
//    public static final String ARTIST_NAME = "net.simplifiedcoding.firebasedatabaseexample.artistname";
//    public static final String ARTIST_ID = "net.simplifiedcoding.firebasedatabaseexample.artistid";
//
//    //view objects
//    EditText editTextName;
//    Spinner spinnerGenre;
//    Button buttonAddArtist;
//    ListView listViewArtists;
//
//    //a list to store all the artist from firebase database
//    List<Artist> artists;
//
//    //our database reference object
//    DatabaseReference databaseArtists;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        //getting the reference of artists node
//        databaseArtists = FirebaseDatabase.getInstance().getReference("artists");
//
//        //getting views
////        editTextName = (EditText) findViewById(R.id.editTextName);
////        spinnerGenre = (Spinner) findViewById(R.id.spinnerGenres);
////        listViewArtists = (ListView) findViewById(R.id.listViewArtists);
//
////        buttonAddArtist = (Button) findViewById(R.id.buttonAddArtist);
//
//        //list to store artists
//        artists = new ArrayList<>();
//
//
//        //adding an onclicklistener to button
//        buttonAddArtist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //calling the method addArtist()
//                //the method is defined below
//                //this method is actually performing the write operation
//                addArtist();
//            }
//        });
//    }
//
//    /*
//     * This method is saving a new artist to the
//     * Firebase Realtime Database
//     * */
//    private void addArtist() {
//        //getting the values to save
//        String name = editTextName.getText().toString().trim();
//        String genre = spinnerGenre.getSelectedItem().toString();
//
//        //checking if the value is provided
//        if (!TextUtils.isEmpty(name)) {
//
//            //getting a unique id using push().getKey() method
//            //it will create a unique id and we will use it as the Primary Key for our Artist
//            String id = databaseArtists.push().getKey();
//
//            //creating an Artist Object
//            Artist artist = new Artist(id, name, genre);
//
//            //Saving the Artist
//            databaseArtists.child(id).setValue(artist);
//            //setting edittext to blank again
//            editTextName.setText("");
//
//            //displaying a success toast
//            Toast.makeText(this, "Artist added", Toast.LENGTH_LONG).show();
//        } else {
//            //if the value is not given displaying a toast
//            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
//        }
//    }
//}