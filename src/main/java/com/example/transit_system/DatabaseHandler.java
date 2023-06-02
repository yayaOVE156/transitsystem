package com.example.transit_system;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;



import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.cloud.FirestoreClient;


public class DatabaseHandler {
    public static Firestore db;
        public static void initialize() throws IOException, ExecutionException, InterruptedException {
            FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");

            FirestoreOptions options = FirestoreOptions.newBuilder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            Firestore db = options.getService();

            DocumentReference docRef = db.collection("test3").document("");

            Map<String, Number> data = new HashMap<>();
            data.put("hello", 10);
            //data.put(6, "home");
            //data.put(10, "01003410931");
            WriteResult result = docRef.set(data).get();
            System.out.println("Update time: " + result.getUpdateTime());
        }

    public static void addUser(User user) throws ExecutionException, InterruptedException, IOException {
        FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        Firestore db = options.getService();
        ApiFuture<WriteResult> docRef = db.collection("Accounts").document(user.getUserName()).set(user);
        System.out.println("Update time: " + docRef.get());
    }
    public static void addUser()
    {

    }

    public static User getUser(String userName) throws IOException, ExecutionException, InterruptedException {
        FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        Firestore db = options.getService();
        User user = null;
        DocumentReference docRef = db.collection("Accounts").document(userName);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        if(document.exists()) {
            System.out.println("Document Data: " + document.getData());
            user = document.toObject(User.class);
        }
        else
            System.out.println("no such document!");
        return user;
    }
    public static User getUser(int id) throws IOException, ExecutionException, InterruptedException {
        FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        Firestore db = options.getService();
        User user = null;
        Query query = db.collection("Accounts").whereEqualTo("id",20);
        ApiFuture<QuerySnapshot> future = query.get();
        QuerySnapshot querySnapShot = future.get();
        if(!querySnapShot.isEmpty()) {
            DocumentSnapshot docSnapshot = querySnapShot.getDocuments().get(0);
            System.out.println("Document Data: " + docSnapshot.getData());
            user = docSnapshot.toObject(User.class);

        }
        else
            System.out.println("no such document!");
        return user;

    }
    public static void main(String[] args) throws Exception {
        addUser(new User("Yahya", "itsMe", "vipyahya50@gmail.com", "01003333455", "march", 50));
    }

}
