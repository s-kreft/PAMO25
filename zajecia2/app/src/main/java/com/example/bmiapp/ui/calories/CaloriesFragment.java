package com.example.bmiapp.ui.calories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bmiapp.R;
import com.example.bmiapp.databinding.FragmentCaloriesBinding;
import com.example.bmiapp.ui.benedict.BenedictFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CaloriesFragment extends Fragment {

    private FragmentCaloriesBinding binding;
    private View root;

    private TextView recipeTextView;
    private TextView bmiTextView;

    private RecyclerView recyclerView;
    private ShoppingAdapter adapter;
    private List<ShoppingItem> shoppingList;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CaloriesViewModel notificationsViewModel =
                new ViewModelProvider(this).get(CaloriesViewModel.class);

        binding = FragmentCaloriesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        double kcalValue;
        int recipeNumber = 0;

        String recipe1 = "ŁOSOŚ PIECZONY Z BATATAMI\n" + "SKŁADNIKI\n" +
                " 4 PORCJE\n" +
                "700 g batatów\n" +
                "0,5 łyżeczki papryki\n" +
                "700 g filetu z łososia\n" +
                "2 ząbki czosnku\n" +
                "szczypiorek\n" +
                "1 ogórek szklarniowy\n" +
                "2 łyżki śmietany\n" +
                "sól, pieprz, oliwa extra\n" +
                "PRZYGOTOWANIE\n" +
                "Piekarnik nagrzać do 220 stopni C. Bataty obrać, pokroić na podłużne kawałki, włożyć do naczynia żaroodpornego lub blaszki do pieczenia, doprawić solą, pieprzem, papryką.\n" +
                "Skropić 2 łyżkami oliwy i wymieszać, następnie rozłożyć równomiernie na blaszce.\n" +
                "Wstawić do nagrzanego piekarnika i piec przez 15 minut. W trakcie pieczenia batatów przygotować łososia.\n" +
                "Łososia pokroić na porcje, odciąć skórkę, opłukać i osuszyć. Doprawić solą, pieprzem, wysmarować przeciśniętym przez praskę czosnkiem oraz 2 łyżkami oliwy.\n" +
                "Położyć na podpieczonych batatach i piec dalej, przez kolejne 10 minut. Wyjąć naczynie z piekarnika, posypać posiekanym szczypiorkiem i podawać z sałatką z ogórka.\n" +
                "Ogórka umyć, obrać, przekroić wzdłuż na pół, następnie na cienkie plasterki. Doprawić solą, pieprzem, śmietaną i szczypiorkiem.";

        String recipe2 = "RISOTTO Z KURCZAKIEM PO TOSKAŃSKU\n" + "SKŁADNIKI\n" +
                " 2 - 3 PORCJE\n" +
                "1 mniejsza cebula\n" +
                "1 łyżka oliwy\n" +
                "2 ząbki czosnku\n" +
                "1 łyżka masła\n" +
                "1 pojedyncza pierś kurczaka\n" +
                "1 łyżeczka suszonego oregano\n" +
                "szczypta płatków chili\n" +
                "1/3 szklanki ryżu do risotto (arborio)\n" +
                "1/4 szklanki białego wina\n" +
                "ok. 200 g cukinii\n" +
                "6 kawałków suszonych pomidorów z zalewy\n" +
                "ok. 500 ml bulionu\n" +
                "60 ml (1/4 szklanki) śmietanki 30%\n" +
                "garść szpinaku\n" +
                "1/3 szklanki tartego parmezanu\n" +
                "bazylia\n" +
                "PRZYGOTOWANIE\n" +
                "W szerokim garnku na 1 łyżce oliwy zeszklić pokrojoną w kosteczkę cebulę (ok. 4 minuty, co chwilę mieszając), pod koniec dodać przeciśnięty przez praskę czosnek.\n" +
                "Dodać 1 łyżkę masła oraz pokrojoną na małe kawałki pierś kurczaka. Obsmażać przez około 3 minuty co chwilę mieszając, następnie dodać sól, pieprz, suszone oregano i płatki chili.\n" +
                "Dodać ryż i dokładnie go obsmażyć. Wlać wino i gotować przez kilkanaście sekund aż odparuje.\n" +
                "Wlewać po około pół szklanki gorącego bulionu i gotować bez przykrycia od czasu do czasu mieszając, w sumie przez około 13 - 15 minut. Dodać kolejną porcję bulionu gdy poprzednia będzie wchłonięta przez ryż. Na koniec ryż ma być ugotowany al dente.\n" +
                "W połowie gotowania ryżu dodać pokrojoną w małą kosteczkę cukinię oraz posiekane suszone pomidory wyjęte z zalewy.\n" +
                "Dodać śmietankę, wymieszać i zagotować.\n" +
                "Odstawić z ognia, dodać szpinak, kilkanaście liści bazylii, a także 2/3 ilości tartego parmezanu. Wymieszać, przykryć i odstawić na około 1 - 2 minuty.\n" +
                "Wyłożyć do głębokich talerzy i posypać resztą parmezanu."
                ;

        String recipe3 = "FILETY DROBIOWE PO GRECKU\n" + "SKŁADNIKI\n" +
                " 4 PORCJE\n" +
                "600 g filetu kurczaka\n" +
                "1 łyżeczka oregano\n" +
                "1 łyżeczka wędzonej papryki (lub słodkiej)\n" +
                "1 łyżeczka czosnku granulowanego\n" +
                "2 łyżki zwykłej oliwy\n" +
                "150 g sera feta\n" +
                "1 cytryna\n" +
                "2 łyżki oliwy extra\n" +
                "pęczek natki pietruszki\n" +
                "PRZYGOTOWANIE\n" +
                "Piekarnik nagrzać do 190 stopni C. Filety kurczaka przekroić na mniejsze części: z każdego filetu odciąć polędwiczkę (mniejsza część z boku), następnie pozostały filet przekroić wzdłuż na 2 cieńsze plastry.\n" +
                "Filety rozbić w najgrubszej części aby uzyskać mięso o tej samej grubości. Doprawić solą, pieprzem, oregano, papryką i czosnkiem. Wysmarować 1 łyżką oliwy.\n" +
                "Kawałki kurczaka włożyć na rozgrzaną patelnię z 1 łyżką oliwy i obsmażyć z dwóch stron. Przełożyć do naczynia żaroodpornego.\n" +
                "Posypać pokruszoną fetą, skropić całość 1/4 cytryny, obłożyć resztą cytryny pokrojoną na kawałki i polać 2 łyżkami oliwy extra.\n" +
                "Wstawić do nagrzanego piekarnika i piec przez 15 minut. Posypać posiekaną natką pietruszki.";

        String recipe4 = "MAKARON ZE SZPARAGAMI\n" + "SKŁADNIKI\n" +
                " 2 PORCJE\n" +
                "1 pęczek szparagów (500 g)\n" +
                "160 g makaronu spaghetti\n" +
                "4 ząbki czosnku\n" +
                "4 łyżki oliwy extra + do podania\n" +
                "1 łyżka soku z cytryny + szczypta startej skórki\n" +
                "pęczek natki pietruszki\n" +
                "4 łyżki tartego parmezanu lub grana padano + do podania\n" +
                "PRZYGOTOWANIE\n" +
                "Szparagi umyć, odłamać twarde końce (same złamią się we właściwym miejscu). Odłamanych końców nie należy używać, bo są bardzo włókniste i niesmaczne.\n" +
                "Zielone części szparagów pokroić w poprzek na kawałeczki zachowując zielone główki w całości.\n" +
                "Nastawić duży garnek z wodą na makaron, osolić. Makaron wrzucić na wrzątek i gotować al dente zgodnie z instrukcją na opakowaniu, zazwyczaj ok. 9 minut (zależy od grubości makaronu).\n" +
                "Na 3 minuty przed końcem gotowania wrzucić do garnka szparagi i gotować do końca.\n" +
                "W międzyczasie na dużej patelni na 2 łyżkach oliwy delitanie podsmażyć drobno starty lub przeciśnięty przez praskę czosnek.\n" +
                "Wlać sok z cytryny i pogotować przez minutę.\n" +
                "Dodać pozostałe 2 łyżki oliwy, skórkę z cytryny oraz gotowy, odcedzony makaron ze szparagami.\n" +
                "Wymieszać, następnie doprawić solą, pieprzem i dodać posiekaną natkę pietruszki. Ponownie wymieszać w międzyczasie dodając starty ser.\n" +
                "Wyłożyć do talerzy, doprawić solą z młynka w razie potrzeby, skropić dodatkową oliwą oraz posypać dodatkowym parmezanem.";

        String recipe5 = "ZUPA KALAFIOROWA Z ZIEMNIAKAMI I MARCHEWKĄ\n" + "SKŁADNIKI\n" +
                " 4 PORCJE\n" +
                "2 łyżki oliwy\n" +
                "1 łyżka masła\n" +
                "1 cebula\n" +
                "2 marchewki\n" +
                "5 ziemniaków\n" +
                "500 g kalafiora (świeżego lub mrożonego)\n" +
                "1,5 litra bulionu drobiowego lub rosołu\n" +
                "2 łyżki posiekanego koperku\n" +
                "2 łyżki posiekanego szczypiorku\n" +
                "200 g gęstej śmietany z kubka 18%\n" +
                "PRZYGOTOWANIE\n" +
                "Na oliwie i maśle zeszklić pokrojoną w kosteczkę cebulę, dodać obraną i pokrojoną na cienkie plasterki marchewkę i smażyć co chwilę mieszając przez 2 minuty.\n" +
                "Dodać obrane i pokrojone w kosteczkę ziemniaki i znów podsmażać je przez ok. 5 - 7 minut, od czasu do czasu mieszając. Doprawić solą oraz pieprzem.\n" +
                "Dodać świeżego kalafiora pokrojonego na małe różyczki i jeszcze przez chwilę razem podsmażać (kalafiora mrożonego dodajemy później). Wlać gorący bulion i zagotować. Przykryć i gotować przez ok. 20 minut do miękkości warzyw. W połowie tego czasu dodać mrożone różyczki kalafiora, wcześniej opłukane na sitku pod gorącą wodą.\n" +
                "Zupę odstawić z ognia, dodać posiekany koperek i szczypiorek. Śmietanę wymieszać z kilkoma łyżkami zimnej wody, później z kilkoma łyżkami wywaru. Po zahartowaniu śmietany dodawać ją stopniowo do zupy cały czas mieszając. Podawać z pieczywem.";

        String[] recipes = {recipe1, recipe2, recipe3, recipe4, recipe5};

        kcalValue = BenedictFragment.bmi;

        if(kcalValue < 1500) {
            recipeNumber = 0;
        } else if (kcalValue >= 1500 & kcalValue < 1700) {
            recipeNumber = 1;
        } else if (kcalValue >= 1700 & kcalValue < 1800) {
            recipeNumber = 2;
        } else if (kcalValue >= 1800 & kcalValue < 2000) {
            recipeNumber = 3;
        } else if (kcalValue >= 2000) {
            recipeNumber = 4;
        }

        recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        shoppingList = new ArrayList<>();
        shoppingList.add(new ShoppingItem("Milk"));
        shoppingList.add(new ShoppingItem("Bread"));
        shoppingList.add(new ShoppingItem("Eggs"));
        shoppingList.add(new ShoppingItem("Butter"));

        adapter = new ShoppingAdapter(shoppingList);
        recyclerView.setAdapter(adapter);
//        int randomRecipe = ThreadLocalRandom.current().nextInt(recipes.length);
        var textView = (TextView) getView().findViewById(R.id.text_recipe);
        textView.setText(recipes[recipeNumber]);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}