package com.schibsted.spain.barista;

import android.support.annotation.IdRes;
import android.support.test.espresso.PerformException;
import android.util.Log;

import static android.support.test.espresso.Espresso.onView;
import static com.schibsted.spain.barista.BaristaScrollActions.scrollTo;
import static com.schibsted.spain.barista.custom.AutocompleteViewActions.replaceAutocomplete;
import static com.schibsted.spain.barista.custom.DisplayedMatchers.displayedWithId;

public class BaristaAutoCompleteTextViewActions {

  public static void writeToAutoCompleteTextView(@IdRes int id, String text) {
    try {
      scrollTo(id);
    } catch (PerformException exception) {
      Log.d("Barista",
          "The View's parent is not a ScrollView. Due to the power of Barista, you can ignore this error message");
    } finally {
      onView(displayedWithId(id)).perform(replaceAutocomplete(text));
    }
  }
}
