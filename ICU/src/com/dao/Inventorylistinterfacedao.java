package com.dao;
import java.util.ArrayList;

import com.bean.inventoryitem;

public interface Inventorylistinterfacedao {
	
	public void addItem(inventoryitem inventoryitem) throws ClassNotFoundException;

	public inventoryitem getinventoryitemID(String itemid);
	
	public ArrayList<inventoryitem> getinventoryitem();

}
