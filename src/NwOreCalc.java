import java.util.Scanner;

public class NwOreCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the price for obsidian flux: ");
        Double flux = scanner.nextDouble();

        System.out.print("Enter the price for charcoal: ");
        Double charcoal = scanner.nextDouble();

        System.out.print("Enter the price for iron ore: ");
        Double ironOre = scanner.nextDouble();

        System.out.print("Enter the price for starmetal ore: ");
        Double starOre = scanner.nextDouble();

        System.out.print("Enter the price for orichalcum ore: ");
        Double oriOre = scanner.nextDouble();

        System.out.print("Enter the price for mythril metal ore: ");
        Double mythOre = scanner.nextDouble();

        //1 iron ingot = 4 iron ore -- tax 0.01
        //1 steel ingot = 3 iron ingot / 1 flux / 2 charcoal -- tax 0.01
        //1 starmetal ingot = 6 star ore / 2 steel ingot/ 1 flux / 2 charcoal -- tax 0.02
        //1 ori ingot = 8 ori ore / 2 star ingot / 1 flux / 2 charcoal -- 0.04
        //1 mythril ingot = 12 myth ore / 2 ori ingot / 1 flux / 2 charcoal -- 0.07
        Double buyTax = 0.297;
        Double charFlux = flux + (charcoal * 2) + (buyTax * (flux + (charcoal * 2)));
        Double ironIngot = (ironOre * 4) + (buyTax * (ironOre * 4)) + 0.01;
        Double steelIngot = (ironIngot * 3) + charFlux + 0.01;
        Double starIngot = (starOre * 6) + (buyTax * (starOre * 6)) + (steelIngot * 2) + charFlux + 0.02;
        Double oriIngot = (oriOre * 8) + (buyTax * (oriOre * 8)) + (starIngot * 2) + charFlux + 0.04;
        Double mythIngot = (mythOre * 12) + (buyTax * (mythOre * 12)) + (oriIngot * 2) + charFlux + 0.07;

        System.out.println("Total cost for mythril ingot: " + mythIngot.toString());
    }
}
