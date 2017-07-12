package david.anders.com.petfinder;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends Fragment {
    private Controller controller;
    private Button btnImage;
    private Button btnPost;
    private EditText edName;
    private EditText edDesc;
    private EditText edPhone;

    public FindFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        initComponents(view);
        return view;
    }
    private void initComponents(View view) {
        btnImage = (Button)view.findViewById(R.id.btnImage);
        btnPost = (Button)view.findViewById(R.id.btnPost);
        edName = (EditText)view.findViewById(R.id.edName);
        edDesc = (EditText)view.findViewById(R.id.edDesc);
        edPhone = (EditText)view.findViewById(R.id.edPhone);

    }
    public void setController(Controller controller){
        this.controller = controller;
    }
}
