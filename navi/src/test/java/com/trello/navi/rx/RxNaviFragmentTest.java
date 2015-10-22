package com.trello.navi.rx;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import com.trello.navi.internal.BaseNaviFragment;
import org.junit.Test;
import rx.Subscription;
import rx.observers.TestSubscriber;

import static com.trello.navi.TestUtils.setSdkInt;
import static org.mockito.Mockito.mock;

public final class RxNaviFragmentTest {

  private final BaseNaviFragment naviFragment = new BaseNaviFragment();

  @Test public void attachingActivity() {
    setSdkInt(22);

    TestSubscriber<Context> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviFragment.attaching(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Activity activity = mock(Activity.class);
    naviFragment.onAttach(activity);
    subscription.unsubscribe();
    naviFragment.onAttach(activity);

    testSubscriber.assertValue(activity);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void attachingContext() {
    setSdkInt(23);

    TestSubscriber<Context> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviFragment.attaching(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Context context = mock(Context.class);
    naviFragment.onAttach(context);
    subscription.unsubscribe();
    naviFragment.onAttach(context);

    testSubscriber.assertValue(context);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void creating() {
    TestSubscriber<Bundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviFragment.creating(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    naviFragment.onCreate(bundle);
    subscription.unsubscribe();
    naviFragment.onCreate(bundle);

    testSubscriber.assertValue(bundle);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void creatingView() {
    TestSubscriber<Bundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviFragment.creatingView(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    naviFragment.onCreateView(bundle);
    subscription.unsubscribe();
    naviFragment.onCreateView(bundle);

    testSubscriber.assertValue(bundle);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void activityCreated() {
    TestSubscriber<Bundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNaviFragment.activityCreated(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    naviFragment.onActivityCreated(bundle);
    subscription.unsubscribe();
    naviFragment.onActivityCreated(bundle);

    testSubscriber.assertValue(bundle);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void viewStateRestored() {
    TestSubscriber<Bundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNaviFragment.viewStateRestored(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    naviFragment.onViewStateRestored(bundle);
    subscription.unsubscribe();
    naviFragment.onViewStateRestored(bundle);

    testSubscriber.assertValue(bundle);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void starting() {
    TestSubscriber<Object> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviFragment.starting(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    naviFragment.onStart();
    subscription.unsubscribe();
    naviFragment.onStart();

    testSubscriber.assertValueCount(1);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void resuming() {
    TestSubscriber<Object> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviFragment.resuming(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    naviFragment.onResume();
    subscription.unsubscribe();
    naviFragment.onResume();

    testSubscriber.assertValueCount(1);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void pausing() {
    TestSubscriber<Object> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviFragment.pausing(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    naviFragment.onPause();
    subscription.unsubscribe();
    naviFragment.onPause();

    testSubscriber.assertValueCount(1);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void stopping() {
    TestSubscriber<Object> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviFragment.stopping(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    naviFragment.onStop();
    subscription.unsubscribe();
    naviFragment.onStop();

    testSubscriber.assertValueCount(1);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void destroyingView() {
    TestSubscriber<Object> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNaviFragment.destroyingView(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    naviFragment.onDestroyView();
    subscription.unsubscribe();
    naviFragment.onDestroyView();

    testSubscriber.assertValueCount(1);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void destroying() {
    TestSubscriber<Object> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviFragment.destroying(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    naviFragment.onDestroy();
    subscription.unsubscribe();
    naviFragment.onDestroy();

    testSubscriber.assertValueCount(1);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void detaching() {
    TestSubscriber<Object> testSubscriber = new TestSubscriber<>();
    Subscription subscription = RxNaviFragment.detaching(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    naviFragment.onDetach();
    subscription.unsubscribe();
    naviFragment.onDetach();

    testSubscriber.assertValueCount(1);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void savingInstanceState() {
    TestSubscriber<Bundle> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNaviFragment.savingInstanceState(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Bundle bundle = new Bundle();
    naviFragment.onSaveInstanceState(bundle);
    subscription.unsubscribe();
    naviFragment.onSaveInstanceState(bundle);

    testSubscriber.assertValue(bundle);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }

  @Test public void configurationChanging() {
    TestSubscriber<Configuration> testSubscriber = new TestSubscriber<>();
    Subscription subscription =
        RxNaviFragment.configurationChanging(naviFragment).subscribe(testSubscriber);
    testSubscriber.assertNoValues();

    Configuration configuration = mock(Configuration.class);
    naviFragment.onConfigurationChanged(configuration);
    subscription.unsubscribe();
    naviFragment.onConfigurationChanged(configuration);

    testSubscriber.assertValue(configuration);
    testSubscriber.assertNoTerminalEvent();
    testSubscriber.assertUnsubscribed();
  }
}
