public class Main {
    public static void main(String[] args) {
        ParentFactory parentFactory = new ParentFactory();
        ParentFactoryInterface carFactory = parentFactory.produce("CarFactory");
        ParentFactoryInterface tankFactory = parentFactory.produce("TankFactory");
        carFactory.identifyFactoryType();
        tankFactory.identifyFactoryType();
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
