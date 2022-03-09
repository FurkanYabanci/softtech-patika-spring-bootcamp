import service.HousingService;

public class Main {

    public static void main(String[] args) {

        HousingService housingService = new HousingService();
        HousingObject housingObject = new HousingObject();

        System.out.println("Total Price of Houses = " + housingService.totalPriceHouse(housingObject.getHouseList()));
        System.out.println("Total Price of Villas = " + housingService.totalPriceVilla(housingObject.getVillaList()));
        System.out.println("Total Price of Summerhouses = " + housingService.totalPriceSummerhouse(housingObject.getSummerhouseList()));
        System.out.println("Total Price of Housings = " + housingService.totalPriceHousing(housingObject.getHousingList()));
        System.out.println("Average Square Meter of Houses = " + housingService.averageSquareMeterHouse(housingObject.getHouseList()));
        System.out.println("Average Square Meter of Villas = " + housingService.averageSquareMeterVilla(housingObject.getVillaList()));
        System.out.println("Average Square Meter of Summerhouses = " + housingService.averageSquareMeterSummerhouse(housingObject.getSummerhouseList()));
        System.out.println("Average Square Meter of Housings = " + housingService.averageSquareMeterHousing(housingObject.getHousingList()));
        System.out.println("Filtered Housing = " + housingService.filterHousing(housingObject.getHousingList(),"4+1"));

    }

}
