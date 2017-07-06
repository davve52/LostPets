package david.anders.com.petfinder;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private Button btnLost;
    private Button btnFound;
    private Controller controller;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initComponents(view);
        registerListener();
        return view;
    }

    private void initComponents(View view) {
        btnLost = (Button)view.findViewById(R.id.btnLost);
        btnFound = (Button)view.findViewById(R.id.btnFind);
        LinearLayout layout =(LinearLayout)view.findViewById(R.id.bgFrame);
        layout.setBackgroundResource(R.drawable.homebackground);
    }

    private void registerListener() {
        btnFound.setOnClickListener(new ButtonListener());
        btnLost.setOnClickListener(new ButtonListener());
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    private class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnLost :
                    System.out.println("BTN LOSt");
                    break;
                case R.id.btnFind :
                    System.out.println("BTN FOUND");
                    break;
            }
        }
    }
}
