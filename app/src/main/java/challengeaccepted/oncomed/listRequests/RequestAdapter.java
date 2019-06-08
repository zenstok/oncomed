package challengeaccepted.oncomed.listRequests;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import challengeaccepted.oncomed.R;
import challengeaccepted.oncomed.addRequest.Request;

public class RequestAdapter extends RecyclerView.Adapter<RequestViewHolder> {
    List<Request> requestList = new ArrayList<>();

    public RequestAdapter(List<Request> requestList) {
        this.requestList = requestList;
    }

    @NonNull
    @Override
    public RequestViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.request_layout, viewGroup, false);
        return new RequestViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RequestViewHolder requestViewHolder, int i) {
        Request currentRequest = requestList.get(i);
        if(currentRequest != null){
            requestViewHolder.getTextViewDate().setText(currentRequest.getDate());
            requestViewHolder.getTextViewStatus().setText(currentRequest.getStatus());
            requestViewHolder.getTextViewConcentration().setText(currentRequest.getDrug().getConcentration());
            requestViewHolder.getTextViewDrugName().setText(currentRequest.getDrug().getName());
            requestViewHolder.getTextViewDuration().setText(currentRequest.getDrug().getTreatmentPeriod());
            requestViewHolder.getTextViewNumber().setText(currentRequest.getQuantity());
            requestViewHolder.getTextViewPatient().setText(currentRequest.getPacient().getFirstName() + " " + currentRequest.getPacient().getLastName());
            requestViewHolder.getTextViewSubstance().setText(currentRequest.getDrug().getActiveSubstance());
        }
    }

    @Override
    public int getItemCount() {
        return requestList.size();
    }
}
