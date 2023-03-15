public class Main {
    public static void main(String[] args) {
        ParentFactory parentFactory = new ParentFactory();
        ParentFactoryInterface carFactory = parentFactory.produce("CarFactory");
        ParentFactoryInterface tankFactory = parentFactory.produce("TankFactory");
        CarFactory carFactory2 = new CarFactory();
        if (carFactory2.getClass().equals(carFactory.getClass())){
            System.out.println(true);
            CarFactoryInterface audi = carFactory2.produce("Audi");
            CarFactoryInterface bmw = carFactory2.produce("BMW");
            audi.identifyCarMake();
            bmw.identifyCarMake();

            CarFactoryInterface audi2 = ((CarFactory) carFactory).produce("Audi");
            CarFactoryInterface bmw2 = ((CarFactory) carFactory).produce("BMW");
            audi2.identifyCarMake();
            bmw2.identifyCarMake();
        }
        else {
            System.out.println(false);
        }
    }
}

// 1. GoF: Factory
interface CarFactoryInterface {
    public void identifyCarMake();
}

class Audi implements CarFactoryInterface {
    @Override
    public void identifyCarMake(){
        System.out.println(this.getClass());
    }
}

class BMW implements CarFactoryInterface {
    @Override
    public void identifyCarMake(){
        System.out.println(this.getClass());
    }
}

class CarFactory implements ParentFactoryInterface {
    // ParentFactoryInterface for Abstract Factory implementation
    @Override
    public void identifyFactoryType(){
        System.out.println(this.getClass());
    }

    public CarFactoryInterface produce(String typeOfCar){
        switch (typeOfCar){
            case "Audi": return new Audi();
            case "BMW": return new BMW();
            default: return null;
        }
    }
}

// 2. GoF: Abstract Factory
interface TankFactoryInterface {
    public void identifyTankMake();
}

class Challenger implements TankFactoryInterface {
    @Override
    public void identifyTankMake(){
        System.out.println(this.getClass());
    }
}

class Abrams implements TankFactoryInterface {
    @Override
    public void identifyTankMake(){
        System.out.println(this.getClass());
    }
}

class TankFactory implements ParentFactoryInterface {
    // ParentFactoryInterface for Abstract Factory implementation
    @Override
    public void identifyFactoryType(){
        System.out.println(this.getClass());
    }

    public TankFactoryInterface produce(String typeOfCar){
        switch (typeOfCar){
            case "Challenger": return new Challenger();
            case "Abrams": return new Abrams();
            default: return null;
        }
    }
}

interface ParentFactoryInterface {
    public void identifyFactoryType();
}

class ParentFactory {
    public ParentFactoryInterface produce(String typeOfFactory){
        switch (typeOfFactory){
            case "CarFactory": return new CarFactory();
            case "TankFactory": return new TankFactory();
            default: return null;
        }
    }
}
