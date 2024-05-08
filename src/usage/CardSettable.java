package usage;

import base.StoreItem;

public interface CardSettable {
    void setCard(StoreItem storeItem);
    void setCard(StoreItem storeItem, int quantity);
    void setCard(String genreIconPath, String genreLabel);
}
