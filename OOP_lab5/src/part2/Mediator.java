package part2;

import java.util.ArrayList;
import java.util.List;

//mediator
interface Mediator{
    public abstract void send(String message, Colleague colleague);
}
//colleague interface
abstract class Colleague {
    private Mediator _mediator;
    public Colleague(Mediator med){
        this._mediator  = med;
    }
    //send a message via the mediator
    public void send(String message){
        _mediator.send(message,this);
    }
    public abstract void Notify(String message);
}
//concrete colleagues
class Storage extends  Colleague {

    public Storage(Mediator med) {
        super(med);
    }
    @Override
    public void Notify(String message) {
            System.out.println("Message to store: " + message);
    }
}
class Customer extends  Colleague {

    public Customer(Mediator med) {
        super(med);
    }

    @Override
    public void Notify(String message) {
        System.out.println("Message to customer: " + message);
    }
}

//concrete mediator
class InternetShop implements Mediator {
    int amountOfMobilePhones = 56;
    public Colleague Customer;
    public Colleague Storage;

    @Override
    public void send(String message, Colleague colleague) {
            int amount = Character.getNumericValue(message.charAt(0)) ;
            amountOfMobilePhones -= amount;
            if(amountOfMobilePhones > 0) {
                System.out.println("your item is delivered");
            } else {
                Storage.Notify(message);
                amountOfMobilePhones += amount;
                Customer.Notify("Your item has been delivered to the store");
            }


    }
}