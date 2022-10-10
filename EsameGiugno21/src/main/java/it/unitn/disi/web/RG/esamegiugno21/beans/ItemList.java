package it.unitn.disi.web.RG.esamegiugno21.beans;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ItemList extends LinkedList<ItemBean> {
    public ItemList(){}
    public void addItem(List<ItemBean> itemList, String attributes []){
        int delta = Integer.parseInt(attributes[4]);
        Date scadenza = new Date();
        scadenza.setTime(scadenza.getTime() + delta * 1000);
        ItemBean item = new ItemBean(
                attributes[0],
                attributes[1],
                Integer.parseInt(attributes[2]),
                attributes[3],
                scadenza
        );
        this.add(item);
    }
    public ItemList getExpiredItems(){
        ItemList expiredList = new ItemList();
        long currentTime = new Date().getTime();
        for (ItemBean item :
                this) {
            if(currentTime > item.getTimestamp().getTime())
                expiredList.add(item);
        }
        return expiredList;
    }
    public ItemList getActiveItems(){
        ItemList activeList = new ItemList();
        long currentTime = new Date().getTime();
        for (ItemBean item :
                this) {
            if(currentTime < item.getTimestamp().getTime())
                activeList.add(item);
        }
        return activeList;
    }
}
