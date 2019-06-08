package challengeaccepted.oncomed.listRequests;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    private RequestAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Request> dataSource = new ArrayList<>();
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public ListRequestsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_requests, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        putElementsInRecyclerView(view);
    }

    private void putElementsInRecyclerView(View v) {
        final View view = v;
        final Activity activity = getActivity();

        db.collection("request").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Request request = new Request();
                        request.setDate(document.getData().get("date").toString());
                        request.setStatus(document.getData().get("status").toString());
                        request.setQuantity(Integer.parseInt(document.getData().get("drug_quantity").toString()));
                        request.setPacientFirstName(document.getData().get("patient_first_name").toString());
                        request.setPacientLastName(document.getData().get("patient_last_name").toString());
                        request.setDrugName(document.getData().get("drug_name").toString());
                        request.setDrugActiveSubstance(document.getData().get("drug_active_substance").toString());
                        request.setDrugConcentration(document.getData().get("drug_concentration").toString());
                        dataSource.add(request);
                    }
                    mRecyclerView = view.findViewById(R.id.recycler_view_requests);
                    mLayoutManager = new LinearLayoutManager(activity);
                    mRecyclerView.setLayoutManager(mLayoutManager);
                    mAdapter = new RequestAdapter(dataSource);
                    mRecyclerView.setAdapter(mAdapter);

                } else {
                    Log.d("FIREBASE APP", "Error getting documents: ", task.getException());
                }
            }
        });
    }

}
