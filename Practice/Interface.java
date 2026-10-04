interface Payment{
    void makePayment(double amount);

}

class UPIPayment implements Payment{
    public void makePayment(double amount){
        System.out.println("paid ="+amount);
    }
}

class CardPayment implements Payment{
    public void makePayment(double amount){
        System.out.println("paid ="+amount);
    }
}

class Interface{
    public static void main(String[] args) {
        Payment UPI = new UPIPayment();
        Payment Card = new CardPayment();

        UPI.makePayment(289.9088);
        Card.makePayment(4567.89);
    }
}


