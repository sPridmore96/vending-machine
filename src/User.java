public class User {
    private double userMoney;

    public User(double userMoney) {
        this.userMoney = userMoney;
    }

    public double getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(double userMoney) {
        if (userMoney > 0.50) {
            double roundedMoney = Math.round(userMoney * 100.0) / 100.0;
           this.userMoney = roundedMoney;
        }
    }

    public String toString() {
        return String.format("\nCustomers Money : £%s", userMoney);
    }

}
