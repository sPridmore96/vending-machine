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
           this.userMoney = userMoney;
        }
    }

    public String toString() {
        return String.format("\nUsers Money : £%s", userMoney);
    }

}
