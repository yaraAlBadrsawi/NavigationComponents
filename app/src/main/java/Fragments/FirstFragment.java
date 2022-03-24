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
import com.example.navigationcomponen.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    FragmentFirstBinding binding;
    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.binding=FragmentFirstBinding.inflate(inflater);
        Bundle bundle=new Bundle();
        this.binding.login.setOnClickListener(view -> {
            bundle.putString("name",binding.name.getText().toString());
            bundle.putString("password",binding.pass.getText().toString());
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_firstFragment_to_seconedFragment,
            bundle);
//                ConfirmationAction action =
//                        SpecifyAmountFragmentDirections.confirmationAction();
//                action.setAmount(amount);
//

        });
        this.binding.forget.setOnClickListener(view -> {
//            Toast.makeText(getContext(), "name is : "+binding.name.getText(), Toast.LENGTH_SHORT).show();
            bundle.putString("name",binding.name.getText().toString());

            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_firstFragment_to_thirdFragment2, bundle);
            });
//        this.binding.showF2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//               // Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_seconedFragment);
//            }
//        });
        return this.binding.getRoot();
               }
}