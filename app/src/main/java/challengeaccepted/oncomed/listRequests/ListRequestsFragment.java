package challengeaccepted.oncomed.listRequests;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import challengeaccepted.oncomed.R;
import challengeaccepted.oncomed.addRequest.Drug;
import challengeaccepted.oncomed.addRequest.Pacient;
import challengeaccepted.oncomed.addRequest.Request;
import challengeaccepted.oncomed.main.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListRequestsFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Request> dataSource;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public ListRequestsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_requests, container, false);

        initView(view);
        getDataSource();
        return view;
    }

    private void getDataSource() {
        CollectionReference requestsRef = db.collection("request");
        Query queryRequest = requestsRef.whereEqualTo("volunteer_id","GezsaNXugngBJKlL1klI");
        queryRequest.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    final Request request = new Request();
                    String date = document.get("start_date").toString();
                    request.setDate(date);
                    String status = document.get("status").toString();
                    request.setStatus(status);
                    String drugId = document.get("drug_id").toString();
                    CollectionReference drugRef = db.collection("drug");
                    DocumentReference drugReff = drugRef.document("/drug/" + drugId);
                    drugReff.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                            Drug drug = new Drug(documentSnapshot.get("active_substance").toString(),
                                    documentSnapshot.get("name").toString(),
                                    (int)documentSnapshot.get("concentration"),
                                    (int)documentSnapshot.get("treatment_period"));
                            request.setDrug(drug);
                        }
                    });
                    String patientId = document.get("patient_id").toString();
                    CollectionReference patientRef = db.collection("patient");
                    DocumentReference patientReff = patientRef.document("/patient/" + patientId);
                    patientReff.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                            Pacient pacient = new Pacient();
                            pacient.setName(documentSnapshot.get("name").toString());
                            request.setPacient(pacient);
                        }
                    });
                    dataSource.add(request);
                }

            }
        });
    }

    private void initView(View view) {
        dataSource = new ArrayList<>();
        mRecyclerView = view.findViewById(R.id.recycler_view_requests);
        mLayoutManager = new LinearLayoutManager(this.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RequestAdapter(dataSource);
        mRecyclerView.setAdapter(mAdapter);
    }

}
