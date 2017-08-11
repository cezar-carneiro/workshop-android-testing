package workshop.com.br.example;

import android.app.Activity;
import android.os.SystemClock;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
/**
 * Created by cezar.carneiro on 10/08/2017.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    Activity activity = null;

    @Before
    public void setup(){
        activity = rule.getActivity();
    }

    @Test
    public void garantirTituloDistanciaCorreto() {
        View distanciaTitle = activity.findViewById(R.id.distanciaTitleTextView);
        assertThat(distanciaTitle, instanceOf(TextView.class));
        assertThat(distanciaTitle, notNullValue());
        onView(withId(R.id.distanciaTitleTextView)).check(matches(withText("Distância")));
    }

    @Test
    public void garantirTituloMassaCorreto() {
        View massaTitle = activity.findViewById(R.id.massaTitleTextView);
        assertThat(massaTitle, instanceOf(TextView.class));
        assertThat(massaTitle, notNullValue());
        onView(withId(R.id.massaTitleTextView)).check(matches(withText("Massa")));
    }

    @Test
    public void garantirTituloMoedaCorreto() {
        View moedaTitleTextView = activity.findViewById(R.id.moedaTitleTextView);
        assertThat(moedaTitleTextView, instanceOf(TextView.class));
        assertThat(moedaTitleTextView, notNullValue());
        onView(withId(R.id.moedaTitleTextView)).check(matches(withText("Moeda")));
    }

    @Test
    public void garantirTituloTemperaturaCorreto() {
        View temperaturaTitleTextView = activity.findViewById(R.id.temperaturaTitleTextView);
        assertThat(temperaturaTitleTextView, instanceOf(TextView.class));
        assertThat(temperaturaTitleTextView, notNullValue());
        onView(withId(R.id.temperaturaTitleTextView)).check(matches(withText("Temperatura")));
    }

    @Test
    public void garantirDistanciaSoAceitaNumeroPositivo() {
        onView(withId(R.id.milhasEditText)).perform(clearText(), typeText("a"), closeSoftKeyboard()).check(matches(withText("")));
        onView(withId(R.id.milhasEditText)).perform(clearText(), typeText("-"), closeSoftKeyboard()).check(matches(withText("")));
        onView(withId(R.id.milhasEditText)).perform(clearText(), typeText("-1"), closeSoftKeyboard()).check(matches(withText("1")));
        onView(withId(R.id.milhasEditText)).perform(clearText(), typeText("2"), closeSoftKeyboard()).check(matches(withText("2")));
        onView(withId(R.id.milhasEditText)).perform(clearText(), typeText(".5"), closeSoftKeyboard()).check(matches(withText(".5")));
        onView(withId(R.id.milhasEditText)).perform(clearText(), typeText("0.5"), closeSoftKeyboard()).check(matches(withText("0.5")));
    }

    @Test
    public void garantirMassaSoAceitaNumeroPositivo() {
        onView(withId(R.id.librasEditText)).perform(clearText(), typeText("a"), closeSoftKeyboard()).check(matches(withText("")));
        onView(withId(R.id.librasEditText)).perform(clearText(), typeText("-"), closeSoftKeyboard()).check(matches(withText("")));
        onView(withId(R.id.librasEditText)).perform(clearText(), typeText("-1"), closeSoftKeyboard()).check(matches(withText("1")));
        onView(withId(R.id.librasEditText)).perform(clearText(), typeText("2"), closeSoftKeyboard()).check(matches(withText("2")));
        onView(withId(R.id.librasEditText)).perform(clearText(), typeText(".5"), closeSoftKeyboard()).check(matches(withText(".5")));
        onView(withId(R.id.librasEditText)).perform(clearText(), typeText("0.5"), closeSoftKeyboard()).check(matches(withText("0.5")));
    }

    @Test
    public void garantirMoedaSoAceitaNumeroPositivo() {
        onView(withId(R.id.dolarEditText)).perform(clearText(), typeText("a"), closeSoftKeyboard()).check(matches(withText("")));
        onView(withId(R.id.dolarEditText)).perform(clearText(), typeText("-"), closeSoftKeyboard()).check(matches(withText("")));
        onView(withId(R.id.dolarEditText)).perform(clearText(), typeText("-1"), closeSoftKeyboard()).check(matches(withText("1")));
        onView(withId(R.id.dolarEditText)).perform(clearText(), typeText("2"), closeSoftKeyboard()).check(matches(withText("2")));
        onView(withId(R.id.dolarEditText)).perform(clearText(), typeText(".5"), closeSoftKeyboard()).check(matches(withText(".5")));
        onView(withId(R.id.dolarEditText)).perform(clearText(), typeText("0.5"), closeSoftKeyboard()).check(matches(withText("0.5")));
    }

    @Test
    public void garantirTemperaturaSoAceitaNumeros() {
        onView(withId(R.id.celsiusEditText)).perform(clearText(), typeText("a"), closeSoftKeyboard()).check(matches(withText("")));
        onView(withId(R.id.celsiusEditText)).perform(clearText(), typeText("-1"), closeSoftKeyboard()).check(matches(withText("-1")));
        onView(withId(R.id.celsiusEditText)).perform(clearText(), typeText("2"), closeSoftKeyboard()).check(matches(withText("2")));
        onView(withId(R.id.celsiusEditText)).perform(clearText(), typeText(".5"), closeSoftKeyboard()).check(matches(withText(".5")));
        onView(withId(R.id.celsiusEditText)).perform(clearText(), typeText("0.5"), closeSoftKeyboard()).check(matches(withText("0.5")));
    }

    @Test
    public void verificarEntradaVaziaParaMilhas(){
        onView(withId(R.id.milhasEditText)).perform(clearText());
        onView(withId(R.id.milhasButton)).perform(click());
        onView(withText("Valor invalido")).check(matches(isDisplayed()));
    }

    @Test
    public void verificarEntradaVaziaParaLibras(){
        onView(withId(R.id.librasEditText)).perform(clearText());
        onView(withId(R.id.librasButton)).perform(click());
        onView(withText("Valor invalido")).check(matches(isDisplayed()));
    }

    @Test
    public void verificarEntradaVaziaParaDolares(){
        onView(withId(R.id.dolarEditText)).perform(clearText());
        onView(withId(R.id.dolarButton)).perform(click());
        onView(withText("Valor invalido")).check(matches(isDisplayed()));
    }

    @Test
    public void verificarEntradaVaziaParaCelsius(){
        onView(withId(R.id.celsiusEditText)).perform(clearText());
        onView(withId(R.id.celsiusButton)).perform(click());
        onView(withText("Valor invalido")).check(matches(isDisplayed()));
    }

    @Test
    public void verificarConversaoDeMilhas(){
        onView(withId(R.id.milhasEditText)).perform(clearText(), typeText("0"));
        onView(withId(R.id.milhasButton)).perform(click());
        onView(withId(R.id.quilometrosTextView)).check(matches(withText("0.00 Km")));

        onView(withId(R.id.milhasEditText)).perform(clearText(), typeText("1"));
        onView(withId(R.id.milhasButton)).perform(click());
        onView(withId(R.id.quilometrosTextView)).check(matches(withText("1.61 Km")));

        onView(withId(R.id.milhasEditText)).perform(clearText(), typeText("0.5"));
        onView(withId(R.id.milhasButton)).perform(click());
        onView(withId(R.id.quilometrosTextView)).check(matches(withText("0.80 Km")));

        onView(withId(R.id.milhasEditText)).perform(clearText(), typeText("10.0"));
        onView(withId(R.id.milhasButton)).perform(click());
        onView(withId(R.id.quilometrosTextView)).check(matches(withText("16.09 Km")));
    }

    @Test
    public void verificarConversaoDeLibras(){
        onView(withId(R.id.librasEditText)).perform(clearText(), typeText("0"));
        onView(withId(R.id.librasButton)).perform(click());
        onView(withId(R.id.quilosTextView)).check(matches(withText("0.00 Kg")));

        onView(withId(R.id.librasEditText)).perform(clearText(), typeText("1"));
        onView(withId(R.id.librasButton)).perform(click());
        onView(withId(R.id.quilosTextView)).check(matches(withText("0.45 Kg")));

        onView(withId(R.id.librasEditText)).perform(clearText(), typeText("0.5"));
        onView(withId(R.id.librasButton)).perform(click());
        onView(withId(R.id.quilosTextView)).check(matches(withText("0.23 Kg")));

        onView(withId(R.id.librasEditText)).perform(clearText(), typeText("10.0"));
        onView(withId(R.id.librasButton)).perform(click());
        onView(withId(R.id.quilosTextView)).check(matches(withText("4.54 Kg")));
    }

    @Test
    public void verificarConversaoDeCeusius(){
        onView(withId(R.id.celsiusEditText)).perform(clearText(), typeText("0"));
        onView(withId(R.id.celsiusButton)).perform(click());
        onView(withId(R.id.fahrenheitTextView)).check(matches(withText("32.00 ºF")));

        onView(withId(R.id.celsiusEditText)).perform(clearText(), typeText("1"));
        onView(withId(R.id.celsiusButton)).perform(click());
        onView(withId(R.id.fahrenheitTextView)).check(matches(withText("33.80 ºF")));

        onView(withId(R.id.celsiusEditText)).perform(clearText(), typeText(".5"));
        onView(withId(R.id.celsiusButton)).perform(click());
        onView(withId(R.id.fahrenheitTextView)).check(matches(withText("32.90 ºF")));

        onView(withId(R.id.celsiusEditText)).perform(clearText(), typeText("-2"));
        onView(withId(R.id.celsiusButton)).perform(click());
        onView(withId(R.id.fahrenheitTextView)).check(matches(withText("28.40 ºF")));

        onView(withId(R.id.celsiusEditText)).perform(clearText(), typeText("-2.6"));
        onView(withId(R.id.celsiusButton)).perform(click());
        onView(withId(R.id.fahrenheitTextView)).check(matches(withText("27.32 ºF")));

        onView(withId(R.id.celsiusEditText)).perform(clearText(), typeText("1.27"));
        onView(withId(R.id.celsiusButton)).perform(click());
        onView(withId(R.id.fahrenheitTextView)).check(matches(withText("34.29 ºF")));
    }

}