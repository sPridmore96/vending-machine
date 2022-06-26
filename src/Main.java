public class Main {
    public static void main(String[] args) {

        Commands currentCommands = new Commands("Enter Money", new String[]{});
        double totalMoney = currentCommands.getUserMoney();
        User customer = new User(totalMoney);
        currentCommands.printMessage(customer.toString());

        String nextCommands = "allProducts";
        boolean isActive = true;
        while (isActive) {
            switch (nextCommands) {
                case "allProducts":
                    currentCommands = new Commands("allProducts", new String[]{"Drinks", "Crisps", "Sweets", "Enter more money!", "Exit"});
                    currentCommands.printCommands();
                    currentCommands.printMessage("Your total is £" + customer.getUserMoney());
                    int userInput = currentCommands.getUserChoice();
                    if (userInput == 1) {
                        nextCommands = "Drinks";
                    } else if (userInput == 2) {
                        nextCommands = "Crisps";
                    } else if (userInput == 3) {
                        nextCommands = "Sweets";
                    } else if (userInput == 4) {
                        currentCommands = new Commands("MoreMoney", new String[]{"Add more money..."});
                        currentCommands.printCommands();
                        double oldTotal = customer.getUserMoney();
                        double newMoneyEntered = currentCommands.getUserMoney();
                        double newTotal = oldTotal + newMoneyEntered;
                        customer.setUserMoney(newTotal);
                        currentCommands.printMessage("Your new total is £" + customer.getUserMoney());
                        nextCommands = "allProducts";
                    } else if (userInput == 5) {
                    nextCommands = "";
                    }
                    break;
                case "Drinks":
                    currentCommands.printMessage("Drinks");
                    currentCommands = new Commands("Pick A drink", new String[]{"coke", "sprite", "pepsi"});
                    currentCommands.printCommands();
                    int userBuys = currentCommands.getUserChoice();
                    if (userBuys == 1) {
                        Drinks coke = new Drinks("Cola", "Coke", 1.52);
                        currentCommands.printMessage(coke.getBrand());
                        currentCommands.printMessage("Price : £" + coke.getPrice());
                        currentCommands.printMessage("Stock : " + coke.getStockAmount());
                        currentCommands = new Commands("Buy?", new String[]{"yes!", "No?", "out of stock?"});
                        currentCommands.printCommands();
                        int purchase = currentCommands.getUserChoice();
                        if (purchase == 1) {
                            double newCustomerTotal = customer.getUserMoney() - coke.getPrice();
                            customer.setUserMoney(newCustomerTotal);
                            currentCommands.printMessage("You're New total is £" + customer.getUserMoney());
                        } else if (purchase == 2) {
                            currentCommands.printMessage("Purchase Cancelled");
                        } else if (purchase == 3) {
                            currentCommands.printMessage("This items out of Stock \nshall we re-stock it? ");
                            currentCommands = new Commands("reStock", new String[]{"Restock by X amount", "Don't bother"});
                            currentCommands.printCommands();
                            int choice = currentCommands.getUserChoice();
                            if (choice == 1){
                                currentCommands = new Commands("StockAmount", new String[]{"5", "10"});
                                currentCommands.printCommands();
                                int stockAmount = currentCommands.getUserChoice();
                                    int currentStock = coke.getStockAmount();
                                if (stockAmount == 1) {
                                    int newTotalStock = currentStock + 5;
                                    coke.setStockAmount(newTotalStock);
                                } else if (stockAmount == 2) {
                                    int newTotalStock = currentStock + 5;
                                    coke.setStockAmount(newTotalStock);
                                }
                                currentCommands.printMessage("The new stock of this item is " + coke.getStockAmount());

                            }
                        }
                        nextCommands = "allProducts";
                    } else if (userBuys == 2) {
                        Drinks sprite = new Drinks("sprite", "sprite", 1.72);
                        currentCommands.printMessage(sprite.getBrand());
                        currentCommands.printMessage("Price : £" + sprite.getPrice());
                        currentCommands.printMessage("Stock : " + sprite.getStockAmount());
                        currentCommands = new Commands("Buy?", new String[]{"yes!", "No?"});
                        currentCommands.printCommands();
                        int purchase = currentCommands.getUserChoice();
                        if (purchase == 1) {
                            double newCustomerTotal = customer.getUserMoney() - sprite.getPrice();
                            customer.setUserMoney(newCustomerTotal);
                            currentCommands.printMessage("You're New total is £" + customer.getUserMoney());
                        } else {
                            currentCommands.printMessage("Purchase Cancelled");
                        }
                        nextCommands = "allProducts";
                    }
                    break;
                case "Crisps":
                    currentCommands.printMessage("Crisps");
                    nextCommands = "products";
                    break;
                case "Sweets" :
                    currentCommands.printMessage("Sweets");
                    nextCommands = "products";
                default:
                    isActive = false;
            }
        }
    }
}