/**
 *
 *  @author Adamczyk Maciej S15170
 *
 */

package zad2;

import java.util.Map;

public class FloristsTest {
  // definition of the method that sums the value of the flowers with given color 
  static int valueOf(Box box, String color) {
	  int cost=0;
	  for (Map.Entry<Flower, Integer> entry : box.map.entrySet()){
		  if(entry.getKey().getColor().equals(color)){
			  for (Map.Entry<String, Double> entryPriceList : PriceList.getInstance().getPriceListMap().entrySet()) {
				  if(entryPriceList.getKey().equals(entry.getKey().getName())){
					  cost+=entry.getValue()*entryPriceList.getValue();
				  }
			  }
		  } 
	  }
       return cost;
  }

  public static void main(String[] args) {
    // Self-service florist shop
    // determination of the price list
    PriceList pl = PriceList.getInstance();
    pl.put("rose", 10.0);
    pl.put("lilac", 12.0);
    pl.put("peony", 8.0);

    // Client John comes. He has 200 PLN.
    Customer john = new Customer("John", 200);

    // He takes different flowers: 5 roses, 5 peony, 3 freesia, 3 lilacs
    john.get(new Rose(5));
    john.get(new Peony(5));
    john.get(new Freesia(3));
    john.get(new Lilac(3));

    // He put it in the trolley
    // Let's see what he got there
    ShoppingCart johnCart = john.getShoppingCart();
    System.out.println("Before checkout " + johnCart);

    // Now he pays...
    john.pay();

    // Is it possible that when paying there are some flowers for which te price hasn't ben set ?
    // They should be removed from the cart and John should not be charged.
    // John could run out of money so the flowers are also returned.

    System.out.println("After payment " + john.getShoppingCart());

    // How much money has John left ? 
    System.out.println("John has got: " + john.getCash() + " PLN left.");

    // Now he somehow packages the flowers (maybe to a box)
    Box johnBox = new Box(john);
    john.pack(johnBox);

    // What is now the content of a John's box...
    // (it shouldn't contain anything)
    System.out.println("After packaging to a box " + john.getShoppingCart());

    // and what is inside a box
    System.out.println(johnBox);

    // Now we will check the amount of red flowers in John's box
    System.out.println("Cost of red flowers in the John's box: "
        + valueOf(johnBox, "red"));

    // Now the Steven comes
    // he has got only 60 PLN
    Customer steven = new Customer("Steven", 60);

    // But he took a little to much flowers
    steven.get(new Lilac(3));
    steven.get(new Rose(5));

    // what is the content of his cart
    System.out.println(steven.getShoppingCart());

    // he pays and packages to a box
    steven.pay();
    Box stevenBox = new Box(steven);
    steven.pack(stevenBox);

    // this is his final purchase
    System.out.println(stevenBox);
    // ... and the money left
    System.out.println("Steven has got : " + steven.getCash() + " PLN left.");
  }
}
