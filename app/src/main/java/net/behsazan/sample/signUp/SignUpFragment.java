package net.behsazan.sample.signUp;

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
import net.behsazan.sample.databinding.FragmentSignUpBinding;
import net.behsazan.sample.model.Account;

public class SignUpFragment extends Fragment {

AccountDBAdapter dbAdapter;
FragmentSignUpBinding binding;
    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= FragmentSignUpBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dbAdapter=new AccountDBAdapter(view.getContext());

        binding.btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user =binding.edtUserName.getText().toString();
                String pass=binding.edtPass.getText().toString();
                String passConfirm= binding.edtPassConfirm.getText().toString();
                Account account=new Account();
                account.setUsername(user);
                account.setPassword(pass);
//                Log.e("user",user);
//                Log.e("pass",pass);
                if(!checkExistence(user)){

                if(checkConfirm(pass,passConfirm)){

                    long result = dbAdapter.insert(account);
                    if(result>0) {
                        Toast.makeText(view.getContext(), "success", Toast.LENGTH_SHORT).show();

                        Navigation.findNavController(view).navigate(R.id.action_signUpFragment2_to_signInFragment);


                    }else {

                        Toast.makeText(view.getContext(), "fail", Toast.LENGTH_SHORT).show();
                     }

                }
                else{
                    Toast.makeText(view.getContext(), "password and confirm password must be equal!!!!!", Toast.LENGTH_SHORT).show();


                }
            }else{Toast.makeText(view.getContext(),"duplicate username",Toast.LENGTH_LONG).show();}
            }
        });




    }


    public boolean checkConfirm(String pass,String cpass){
        if (pass.trim().equals(cpass.trim())){ return  true;}
        else {return false;}
    }

    public boolean checkExistence(String user){
        if(dbAdapter.getPass(user) == null){return false;}
        else{return  true;}


    }


}