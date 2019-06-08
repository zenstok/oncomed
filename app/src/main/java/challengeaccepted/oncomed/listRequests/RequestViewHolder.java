package challengeaccepted.oncomed.listRequests;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import challengeaccepted.oncomed.R;

public class RequestViewHolder extends RecyclerView.ViewHolder{
    private TextView textViewDate;
    private TextView textViewPatient;
    private TextView textViewSubstance;
    private TextView textViewDrugName;
    private TextView textViewConcentration;
    private TextView textViewDuration;
    private TextView textViewNumber;
    private TextView textViewStatus;

    public TextView getTextViewNumber() {
        return textViewNumber;
    }

    public TextView getTextViewStatus() {
        return textViewStatus;
    }

    public RequestViewHolder(@NonNull View itemView) {
        super(itemView);

        textViewDate = itemView.findViewById(R.id.text_view_date);
        textViewPatient = itemView.findViewById(R.id.text_view_pacient);
        textViewSubstance = itemView.findViewById(R.id.text_view_drug_substance);
        textViewDrugName = itemView.findViewById(R.id.text_view_drug_name);
        textViewConcentration = itemView.findViewById(R.id.text_view_drug_concentration);
        textViewDuration = itemView.findViewById(R.id.text_view_drug_duration);
        textViewNumber = itemView.findViewById(R.id.text_view_number);
        textViewStatus = itemView.findViewById(R.id.text_view_status);
    }

    public TextView getTextViewDate() {
        return textViewDate;
    }

    public TextView getTextViewPatient() {
        return textViewPatient;
    }

    public TextView getTextViewSubstance() {
        return textViewSubstance;
    }

    public TextView getTextViewDrugName() {
        return textViewDrugName;
    }

    public TextView getTextViewConcentration() {
        return textViewConcentration;
    }

    public TextView getTextViewDuration() {
        return textViewDuration;
    }
}
