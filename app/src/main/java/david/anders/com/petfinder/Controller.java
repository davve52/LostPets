package david.anders.com.petfinder;

import android.app.Fragment;

/**
 * Created by davve on 2017-07-05.
 */

public class Controller {
    private MainActivity mainActivity;
    private HomeFragment homeFragment;

    public Controller(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        homeFragment = new HomeFragment();
        homeFragment.setController(this);
        mainActivity.setFragment(homeFragment);

    }
    public void switchFragment(Fragment fragment){
        mainActivity.setFragment(fragment);
    }
}
