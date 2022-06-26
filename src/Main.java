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
                    currentCommands = new Commands("allProducts", new String[]{"Drinks", "Crisps", "Sweets"});
                    currentCommands.printCommands();
                    int userInput = currentCommands.getUserChoice();
                    if (userInput == 1) {
                        nextCommands = "Drinks";
                    } else if (userInput == 2) {
                        nextCommands = "Crisps";
                    } else if (userInput == 3) {
                        nextCommands = "Sweets";
                    }
                    break;
                case "Drinks":
                    currentCommands.printMessage("Drinks");
//                    Commands chooseDrink = new Commands("Pick A drink", new String[]{"coke", "sprite", "pepsi"});
                    Drinks coke = new Drinks("Cola", "Coke", 1.52);
                    currentCommands.printMessage(coke.getBrand());
                    currentCommands.printMessage("Price : £" + coke.getPrice());
                    currentCommands.printMessage("Stock : " + coke.getStockAmount());
                    Commands buyOrNot = new Commands("Buy?", new String[]{"yes!", "No?"});
                    currentCommands.printCommands();
                    int userBuys = currentCommands.getUserChoice();
                    if (userBuys == 1){
                        nextCommands = "yes!";
                        break;
                    } else if (userBuys == 2) {
                        nextCommands = "Drinks";
                        break;
                    }
                    nextCommands = "products";
                    break;
                case "Crisps":
                    currentCommands.printMessage("Crisps");
                    nextCommands = "products";
                    break;
                case "sweets" :
                    currentCommands.printMessage("Sweets");
                    nextCommands = "products";
                default:
                    isActive = false;
            }
        }
    }
}