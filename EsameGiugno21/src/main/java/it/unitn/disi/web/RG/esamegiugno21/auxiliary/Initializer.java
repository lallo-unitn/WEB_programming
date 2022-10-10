package it.unitn.disi.web.RG.esamegiugno21.auxiliary;

import it.unitn.disi.web.RG.esamegiugno21.beans.ItemBean;
import it.unitn.disi.web.RG.esamegiugno21.beans.ItemList;
import it.unitn.disi.web.RG.esamegiugno21.beans.UserBean;

import javax.servlet.ServletContext;
import java.util.*;

public class Initializer {
    public Initializer(ServletContext ctx) {
        List<UserBean> userList = new LinkedList<>();
        String userdata1[] = {
                "user1",
                "psw1"
        };
        String userdata2[] = {
                "user2",
                "psw2"
        };
        String userdata3[] = {
                "user3",
                "psw3"
        };
        userList.add(new UserBean(userdata1[0], userdata1[1]));
        userList.add(new UserBean(userdata2[0], userdata2[1]));
        userList.add(new UserBean(userdata3[0], userdata3[1]));
        ctx.setAttribute("users", userList);

        ItemList itemList = new ItemList();
        Map<Integer, ItemBean> itemMap = new HashMap<>();
        ctx.setAttribute("itemList", itemList);
        ctx.setAttribute("itemMap", itemMap);
        String item1[] = {
                "DVD bello",
                "Descrizione lunga ed esaustiva",
                "100",
                "user1",
                "600"
        };
        String item2[] = {
                "DVD non molto bello",
                "Descrizione corta e in cinese",
                "20",
                "user2",
                "100"
        };
        String item3[] = {
                "Non un virus",
                "01001010011010100101001011001011110010100111",
                "1000",
                "user1",
                "10"
        };
        addItem(ctx, item1);
        addItem(ctx, item2);
        addItem(ctx, item3);
    }
    private void addItem(ServletContext ctx, String attributes[]){
        ItemList itemList = (ItemList) ctx.getAttribute("itemList");
        Map<Integer, ItemBean> itemMap = (Map<Integer, ItemBean>) ctx.getAttribute("itemMap");
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
        itemList.add(item);
        itemMap.put(item.getId(), item);
    }
}
