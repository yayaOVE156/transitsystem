package com.example.transit_system;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.sql.Timestamp;
import com.google.api.core.ApiFuture;
//import com.google.cloud.Timestamp;
import com.google.cloud.firestore.*;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;



import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.cloud.FirestoreClient;


public class DatabaseHandler {
    //public static Firestore db;
        ////public static void initialize() throws IOException, ExecutionException, InterruptedException {
           // FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");

          // FirestoreOptions options = FirestoreOptions.newBuilder()
            //        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            //        .build();

           // Firestore db = options.getService();

           // DocumentReference docRef = db.collection("test3").document("test2").collection("brother").document();

          //  Map<String, Number> data = new HashMap<>();
           // data.put("hello", 10);
           //data.put(6, "home");
            //data.put(10, "01003410931");
         //   WriteResult result = docRef.set(data).get();
         //   System.out.println("Update time: " + result.getUpdateTime());
      //  }

        //---------------------- Adding User-------------------------\\
    public static void addUser(User user) throws ExecutionException, InterruptedException, IOException {
        FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        Firestore db = options.getService();
        ApiFuture<WriteResult> docRef = db.collection("Accounts").document(user.getUserName()).set(user);
        System.out.println("Update time: " + docRef.get());
    }

    //-------------------------Getting info of user from username---------------------\\
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

    //--------------------Getting info of user from id-------------------\\
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

    //-----------------------------Checking if email is in use------------------------\\
    public static Boolean checkEmail(String email) throws IOException, ExecutionException, InterruptedException {
        FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        Firestore db = options.getService();
        Query query = db.collection("Accounts").whereEqualTo("email",email);
        ApiFuture<QuerySnapshot> future = query.get();
        QuerySnapshot querySnapShot = future.get();
        if(!querySnapShot.isEmpty()) {
            return true;
        }
        else
            return false;
    }
    //-----------------------------Adding administrator-----------------------\\
    public static void addAdmin(Adminstrator admin) throws ExecutionException, InterruptedException, IOException {
        FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        Firestore db = options.getService();
        ApiFuture<WriteResult> docRef = db.collection("Accounts").document(admin.getUserName()).set(admin);
        System.out.println("Update time: " + docRef.get());
    }
    //-------------------------------Getting info of admin from username----------------------\\
    public static Adminstrator getAdmin(String userName) throws IOException, ExecutionException, InterruptedException {
        FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        Firestore db = options.getService();
        Adminstrator admin = null;
        DocumentReference docRef = db.collection("Accounts").document(userName);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        if(document.exists()) {
            System.out.println("Document Data: " + document.getData());
            admin = document.toObject(Adminstrator.class);
        }
        else
            System.out.println("no such document!");
        return admin;
    }
    public static void addAdmin(User user) throws ExecutionException, InterruptedException, IOException {
        FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        Firestore db = options.getService();
        Adminstrator admin = new Adminstrator(user.getUserName(), user.getPassword(), user.getEmail(), user.getPhoneNumber(), user.getAddress(),user.getID());
        ApiFuture<WriteResult> docRef = db.collection("Accounts").document(admin.getUserName()).set(admin);
        System.out.println("Update time: " + docRef.get());
    }

    //--------------------------------Adding hotels-------------------------\\
    public static void addHotel(Hotel hotel) throws ExecutionException, InterruptedException, IOException {
        FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        Firestore db = options.getService();
        ApiFuture<WriteResult> docRef = db.collection("Item").document("Booking").collection("Hotel").document(hotel.getHotel_name()).set(hotel);
        System.out.println("Update time: " + docRef.get());
    }

    //---------------------------Getting info of hotels from name---------------------------------\\
   public static Hotel getHotel(String name) throws IOException, ExecutionException, InterruptedException{
       FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
       FirestoreOptions options = FirestoreOptions.newBuilder()
               .setCredentials(GoogleCredentials.fromStream(serviceAccount))
               .build();
       Firestore db = options.getService();
       Hotel hotel = null;
       DocumentReference docRef = db.collection("Item").document("Booking").collection("Hotel").document(name);
       ApiFuture<DocumentSnapshot> future = docRef.get();
       DocumentSnapshot document = future.get();
       if(document.exists()) {
           System.out.println("Document Data: " + document.getData());
           hotel= document.toObject(Hotel.class);
       }
       else
           System.out.println("no such document!");
       return hotel;
   }

   //-------------------------Adding trains---------------------------\\
    public static void addTrain(Train train) throws ExecutionException, InterruptedException, IOException {
        FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        Firestore db = options.getService();
        ApiFuture<WriteResult> docRef = db.collection("Item").document("Booking").collection("Train").document(String.valueOf(train.getId())).set(train);
        System.out.println("Update time: " + docRef.get());
    }

    //-------------------------- getting info of train using id--------------------\\
    public static Train getTrain(int id) throws IOException, ExecutionException, InterruptedException{
        FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        Firestore db = options.getService();
        Train train = null;
        DocumentReference docRef = db.collection("Item").document("Booking").collection("Train").document(String.valueOf(id));
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        if(document.exists()) {
            System.out.println("Document Data: " + document.getData());
            train= document.toObject(Train.class);
        }
        else
            System.out.println("no such document!");
        return train;
    }

    //-----------------------------------Adding international train----------------------------------------\\
    public static void addInternationalTrain(InternationalTrain train) throws ExecutionException, InterruptedException, IOException {
        FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        Firestore db = options.getService();
        ApiFuture<WriteResult> docRef = db.collection("Item").document("Booking").collection("International Train").document(String.valueOf(train.getId())).set(train);
        System.out.println("Update time: " + docRef.get());
    }

    //---------------------- getting info on international train from id-------------------------------\\
    public static InternationalTrain getInternationalTrain(int id) throws IOException, ExecutionException, InterruptedException{
        FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        Firestore db = options.getService();
        InternationalTrain train = null;
        DocumentReference docRef = db.collection("Item").document("Booking").collection("International Train").document(String.valueOf(id));
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        if(document.exists()) {
            System.out.println("Document Data: " + document.getData());
            train= document.toObject(InternationalTrain.class);
        }
        else
            System.out.println("no such document!");
        return train;
    }

    //------------------------------------- Adding plane---------------------------------\\
    public static void addPlane(Plane plane) throws ExecutionException, InterruptedException, IOException {
        FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        Firestore db = options.getService();
        ApiFuture<WriteResult> docRef = db.collection("Item").document("Booking").collection("Plane").document(String.valueOf(plane.getId())).set(plane);
        System.out.println("Update time: " + docRef.get());
    }

    //-------------------------- getting info of plane using id-------------------------\\
    public static Plane getPlane(int id) throws IOException, ExecutionException, InterruptedException{
        FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        Firestore db = options.getService();
        Plane plane = null;
        DocumentReference docRef = db.collection("Item").document("Booking").collection("Plane").document(String.valueOf(id));
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        if(document.exists()) {
            System.out.println("Document Data: " + document.getData());
            plane = document.toObject(Plane.class);
        }
        else
            System.out.println("no such document!");
        return plane;
    }

    //------------------------------- adding bus----------------------------------\\
    public static void addBus(Bus bus) throws ExecutionException, InterruptedException, IOException {
        FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        Firestore db = options.getService();
        ApiFuture<WriteResult> docRef = db.collection("Item").document("Booking").collection("Plane").document(String.valueOf(bus.getId())).set(bus);
        System.out.println("Update time: " + docRef.get());
    }

    //---------------------- getting info of bus--------------------------\\
    public static Bus getBus(int id) throws IOException, ExecutionException, InterruptedException{
        FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        Firestore db = options.getService();
        Bus bus = null;
        DocumentReference docRef = db.collection("Item").document("Booking").collection("Bus").document(String.valueOf(id));
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        if(document.exists()) {
            System.out.println("Document Data: " + document.getData());
            bus = document.toObject(Bus.class);
        }
        else
            System.out.println("no such document!");
        return bus;
    }

    //--------------------------- adding taxi-------------------------------------\\
    public static void addTaxi(Taxi taxi) throws ExecutionException, InterruptedException, IOException {
        FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        Firestore db = options.getService();
        ApiFuture<WriteResult> docRef = db.collection("Item").document("Booking").collection("Taxi").document(taxi.getLicensePlate()).set(taxi);
        System.out.println("Update time: " + docRef.get());
    }

    // ------------------------ getting info of taxi----------------------\\
    public static Taxi getTaxi(String Lp) throws IOException, ExecutionException, InterruptedException{
        FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        Firestore db = options.getService();
        Taxi taxi = null;
        DocumentReference docRef = db.collection("Item").document("Booking").collection("Taxi").document(Lp);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        if(document.exists()) {
            System.out.println("Document Data: " + document.getData());
            taxi = document.toObject(Taxi.class);
        }
        else
            System.out.println("no such document!");
        return taxi;
    }

    public static void addTicket(Ticket ticket, String userName) throws ExecutionException, InterruptedException, IOException {
        FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        Firestore db = options.getService();
        ApiFuture<WriteResult> docRef = db.collection("Accounts").document(userName).collection("Tickets").document(String.valueOf(ticket.getTransportationID())).set(ticket);
        System.out.println("Update time: " + docRef.get());
    }

    public static Ticket getTicket(int id, String userName) throws IOException, ExecutionException, InterruptedException{
        FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        Firestore db = options.getService();
        Ticket ticket = null;
        DocumentReference docRef = db.collection("Accounts").document(userName).collection("Tickets").document(String.valueOf(id));
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        if(document.exists()) {
            System.out.println("Document Data: " + document.getData());
            ticket = document.toObject(Ticket.class);
        }
        else
            System.out.println("no such document!");
        return ticket;
    }

    public static List<Ticket> getTickets(String userName) throws IOException, ExecutionException, InterruptedException{
        FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        Firestore db = options.getService();
        Ticket ticket = null;
        DocumentReference docRef = db.collection("Accounts").document(userName);
        CollectionReference ticketsRef = docRef.collection("Tickets");
        ApiFuture<QuerySnapshot> future = ticketsRef.get();
        QuerySnapshot snapshots = future.get();

        List<Ticket> userTickets = new ArrayList<>();
        for(QueryDocumentSnapshot document : snapshots.getDocuments()) {
            ticket = document.toObject(Ticket.class);
            userTickets.add(ticket);
            System.out.println(document.getData());

        }
        if(snapshots.isEmpty())
            System.out.println("no such document!");
        return userTickets;
    }

    public static void main(String[] args) throws Exception {
      //  addUser(new User("Yahya", "itsMe", "vipyahya50@gmail.com", "01003333455", "march", 50));
      // getUser("Acey");
      //  addHotel(new Hotel("Fawzy Resort", 4.5F, 500));
      //  getHotel("Fawzy Resort");
      //  DatabaseHandler.initialize();

        addTrain(new Train((new Random().nextInt(300 - 100) + 100), new Date(123, 2, 1, 10, 10, 10),
                new Date(123, 2, 1, 20, 20, 10), "Cairo", "Alex", 30, "atr 6 ela telt", 69));

       // addInternationalTrain(new InternationalTrain((new Random().nextInt(300 - 100) + 100), new Date(123, 2, 1, 10, 10, 10),
                // new Date(123, 2, 1, 20, 20, 10),
              //  "Cairo", "Alexandria", 50));
        //getInternationalTrain(176);

       // addPlane(new Plane(new Random().nextInt(300 - 100) + 100, new Date(124, 0, 1, 5, 10, 5),
               //  new Date(124, 0, 1, 5, 20, 10),
               // "Cairo", "Alex", 10));
      //  getTransportsSameTime("Plane",new Date(123, 2, 1, 10, 10, 10), new Date(123, 2, 1, 20, 20, 10));
      // addTicket( new Ticket(1000,new Random().nextInt(1000-100)+100, new Train((new Random().nextInt(300 - 100) + 100), new Date(123, 2, 1, 10, 10, 10),
          //     new Date(123, 2, 1, 20, 20, 10), "Cairo", "Alex", 30, "atr 6 ela telt", 69)),"Acey");
       // getTickets("Acey");
        addAdmin(new User("Yahya", "itsMe", "vipyahya50@gmail.com", "01003333455", "march", 50));

    }




}
