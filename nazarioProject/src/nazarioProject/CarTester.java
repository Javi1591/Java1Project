package nazarioProject;

public class CarTester {
	public static void main(String[] args) {
		try {
			Car test = new Car();
			System.out.println("Testing default Constructor:");
			System.out.println(test.toString());

			Car test1 = new Car("2010 Kia Soul", 12005, 12, 12000.00, 13000.00);
			Car test2 = new Car("2012 Ford Focus", 25032, 28, 12500.00, 13000.00);
			System.out.println("Testing parameterized Constructor:");
			System.out.println(test1.toString());
			System.out.println(test2.toString());

			System.out.println("Testing sellCar method:");
			test1.sellCar(185000);
			test2.sellCar(135000);
			System.out.println(test1.toString());
			System.out.println(test2.toString());

			System.out.println("Testing comparision methods:");
			System.out.println("Mileage:");
			System.out.println("Negative: " + test1.compareMiles(test2));
			test1.setMileage(12005);
			System.out.println("Equal: " + test1.compareMiles(test2));
			test1.setMileage(25032);
			System.out.println("Positive: " + test1.compareMiles(test2));

			System.out.println("MPG:");
			System.out.println("Negative: " + test1.compareMPG(test2));
			test1.setMPG(12);
			System.out.println("Equal: " + test1.compareMPG(test2));
			test1.setMPG(28);
			System.out.println("Positive: " + test1.compareMPG(test2));

			System.out.println("Price:");
			System.out.println("Negative: " + test2.comparePrice(test1));
			test1.setSalesPrice(125000);
			System.out.println("Equal: " + test1.comparePrice(test2));
			test1.setSalesPrice(130000);
			System.out.println("Positive: " + test1.comparePrice(test2));
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}