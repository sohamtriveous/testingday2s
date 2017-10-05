package cc.soham.uiautomator;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiCollection;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void tryStuff() throws Exception {
        UiDevice uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        uiDevice.pressHome();
        UiObject uiObject = uiDevice.findObject(new UiSelector().descriptionContains("Apps"));
        uiObject.clickAndWaitForNewWindow();
        UiScrollable appsScrollable = new UiScrollable(new UiSelector().resourceId("com.google.android.apps.nexuslauncher:id/apps_list_view"));

        appsScrollable.scrollToEnd(10);
        appsScrollable.getChildByText(new UiSelector().resourceId("com.google.android.apps.nexuslauncher:id/icon"), "Play Store", true).click();
        uiDevice.findObject(new UiSelector().description("Search")).click();
        uiDevice.findObject(new UiSelector().resourceId("com.android.vending:id/search_box_text_input")).setText("Voice Recorder");
        uiDevice.pressEnter();

        UiScrollable appsResultList = new UiScrollable(new UiSelector().resourceId("com.android.vending:id/search_results_list"));
        appsResultList.getChildByText(new UiSelector().resourceId("com.android.vending:id/li_subtitle"), "Triveous", true).click();

        UiObject appName = uiDevice.findObject(new UiSelector().textContains("Voice Recorder"));
        String voiceRecorder = appName.getText();
        assertEquals(voiceRecorder.contains("Voice Recorder"), true);
    }
}
