package Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.navigationcomponen.R;
import com.example.navigationcomponen.databinding.FragmentSeconedBinding;

public class SeconedFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "name";
    private static final String ARG_PARAM2 = "password";
    private static final String ARG_PARAM3 = "newPass";

    private String mParam1;
    private String mParam2;
    private String mParam3;
    private FragmentSeconedBinding binding;

    public SeconedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SeconedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SeconedFragment newInstance(String param1, String param2) {
        SeconedFragment fragment = new SeconedFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Toast.makeText(getContext(), "OnCreateView", Toast.LENGTH_SHORT).show();
        this.binding=FragmentSeconedBinding.inflate(inflater);
        if(mParam3==null) {
            this.binding.information.setText(new StringBuilder("Name: " + mParam1).append("\n\n ").append("Password: ").append(mParam2));
        }
        else {
            this.binding.information.setText(new StringBuilder("Name: " + mParam1).append("\n\n ").append("Password: ").append(mParam3));
        }
        this.binding.back.setOnClickListener(view -> Navigation.findNavController(this.binding.getRoot()).navigate(R.id.action_seconedFragment_to_firstFragment2));

        return this.binding.getRoot();
    }
}