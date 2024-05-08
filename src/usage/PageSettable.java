package usage;

import base.StoreItem;

public interface PageSettable {
    void setPage();
    void setPage(StoreItem storeItem);
    void setPage(String input);
}
