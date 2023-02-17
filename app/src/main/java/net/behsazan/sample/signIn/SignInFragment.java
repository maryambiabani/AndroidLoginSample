package net.behsazan.sample.signIn;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import net.behsazan.sample.R;
import net.behsazan.sample.database.AccountDBAdapter;
import net.behsazan.sample.databinding.FragmentSignInBinding;


public class SignInFragment extends Fragment {
FragmentSignInBinding binding;

AccountDBAdapter accountDBAdapter;
    public SignInFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentSignInBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(checkAccount(view,binding.edtUserName.getText().toString(),binding.edtPass.getText().toString())){
                Navigation.findNavController(view).navigate(R.id.action_signInFragment_to_homeFragment);
            }
                else{
                    Toast.makeText(view.getContext(), "user name or pass is not correct", Toast.LENGTH_SHORT).show();
                }



            }

        });
        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_signInFragment_to_signUpFragment2);

            }
        });

    }

public boolean checkAccount(View view,String user, String pass) {
    accountDBAdapter = new AccountDBAdapter(view.getContext());
    String target = accountDBAdapter.getPass(user.trim());
    if (target != null) {
        if (target.equals(pass)) {
            return true;
        }

    }
        return false;

}}


