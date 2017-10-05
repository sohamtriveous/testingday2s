package cc.soham.news;

import android.support.test.espresso.IdlingResource;

/**
 * Created by sohammondal on 05/10/17.
 */

public class MyIdlingResource implements IdlingResource {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean isIdleNow() {
        return false;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {

    }
}
