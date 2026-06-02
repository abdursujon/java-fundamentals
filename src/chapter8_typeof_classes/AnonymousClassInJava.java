interface Message{
    void showMessage();
}

class Test implements Message{

    // Anonymous class start from new
    Message msg = new Message(){
        @Override
        public void showMessage(){
            System.out.println("I am first message.");
        }
    };

    @Override
    public void showMessage() {
        System.out.println("I am second message");
    }

    public static void main(String[] args){
        Test t = new Test();

        // Test through anonymous class
        t.msg.showMessage();

        // Normal way of testing show message
        t.showMessage();
    }
}