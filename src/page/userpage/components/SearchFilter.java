package page.userpage.components;

import base.StoreItem;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import page.userpage.SearchPageController;
import page.userpage.UserMainPageController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class SearchFilter {
    @FXML
    private ChoiceBox<String> filterChoiceBox;
    @FXML
    private Label searchLabel;
    private static SearchFilter instance;

    public SearchFilter() {
        SearchFilter.instance = this;
    }

    public static SearchFilter getInstance() {
        if (instance == null) {
            SearchFilter.instance = new SearchFilter();
        }
        return instance;
    }

    public void setFilterChoiceBox(){
        String[] filterChoices = {"Default", "Price: Low to High", "Price: High to Low", "Rating"};
        filterChoiceBox.getItems().addAll(filterChoices);
    }


    public void onSearchFilterClicked() {
        SearchPageController.getInstance().setSearchBoxByArrayList(getFilteredListOfStoreItems());
    }

    public ArrayList<StoreItem> getFilteredListOfStoreItems() {
        ArrayList<StoreItem> storeItems = new ArrayList<>(SearchPageController.getInstance().getSearchedStoreItems());
        if (Objects.equals(filterChoiceBox.getValue(), "Price: Low to High")) {
            storeItems.sort(new Comparator<StoreItem>() {
                @Override
                public int compare(StoreItem o1, StoreItem o2) {
                    return Double.compare(o1.getPrice(), o2.getPrice());
                }
            });


        } else if (Objects.equals(filterChoiceBox.getValue(), "Price: High to Low")) {
            storeItems.sort(new Comparator<StoreItem>() {
                @Override
                public int compare(StoreItem o1, StoreItem o2) {
                    return Double.compare(o2.getPrice(), o1.getPrice());
                }
            });

        } else if (Objects.equals(filterChoiceBox.getValue(), "Rating")) {
            storeItems.sort(new Comparator<StoreItem>() {
                @Override
                public int compare(StoreItem o1, StoreItem o2) {
                    return Integer.compare(o2.getRating(), o1.getRating());
                }
            });
        } else if (Objects.equals(filterChoiceBox.getValue(), "Default")){

        }
        return storeItems;
    }

    public void onEnterSearchLabel(){
        this.searchLabel.setBackground(Background.fill(Color.web( "606060")));
    }

    public void onExitSearchLabel(){
        this.searchLabel.setBackground(Background.fill(Color.web( "E0E0E0")));
    }

}

