package service;


import model.Housing;

import java.util.ArrayList;
import java.util.List;

public class HousingService {

    public long totalPriceHouse(List<Housing> houseList){
        long totalPrice = 0;
        for (int i = 0; i < houseList.size(); i++){
            totalPrice = totalPrice + houseList.get(i).getPrice();
        }
        return totalPrice;
    }

    public long totalPriceVilla(List<Housing> villaList){
        long totalPrice = 0;
        for (int i = 0; i < villaList.size(); i++){
            totalPrice = totalPrice + villaList.get(i).getPrice();
        }
        return totalPrice;
    }

    public long totalPriceSummerhouse(List<Housing> summerhouseList){
        long totalPrice = 0;
        for (int i = 0; i < summerhouseList.size(); i++){
            totalPrice = totalPrice + summerhouseList.get(i).getPrice();
        }
        return totalPrice;
    }

    public long totalPriceHousing(List<Housing> housingList){
        long totalPrice = 0;
        for (int i = 0; i < housingList.size(); i++){
            totalPrice = totalPrice + housingList.get(i).getPrice();
        }
        return totalPrice;
    }

    public int averageSquareMeterHouse(List<Housing> houseList){
        int totalSquareMeter = 0;
        int averageSquareMeter = 0;
        for (int i = 0; i < houseList.size(); i++){
            totalSquareMeter = totalSquareMeter + houseList.get(i).getSize();
        }
        averageSquareMeter = totalSquareMeter / houseList.size();
        return averageSquareMeter;
    }

    public int averageSquareMeterVilla(List<Housing> villaList){
        int totalSquareMeter = 0;
        int averageSquareMeter = 0;
        for (int i = 0; i < villaList.size(); i++){
            totalSquareMeter = totalSquareMeter + villaList.get(i).getSize();
        }
        averageSquareMeter = totalSquareMeter / villaList.size();
        return averageSquareMeter;
    }

    public int averageSquareMeterSummerhouse(List<Housing> summerhouseList){
        int totalSquareMeter = 0;
        int averageSquareMeter = 0;
        for (int i = 0; i < summerhouseList.size(); i++){
            totalSquareMeter = totalSquareMeter + summerhouseList.get(i).getSize();
        }
        averageSquareMeter = totalSquareMeter / summerhouseList.size();
        return averageSquareMeter;
    }

    public int averageSquareMeterHousing(List<Housing> housingList){
        int totalSquareMeter = 0;
        int averageSquareMeter = 0;
        for (int i = 0; i < housingList.size(); i++){
            totalSquareMeter = totalSquareMeter + housingList.get(i).getSize();
        }
        averageSquareMeter = totalSquareMeter / housingList.size();
        return averageSquareMeter;
    }

    public List<Housing> filterHousing(List<Housing> housingList, String numberOfRooms){
        List<Housing> filterHousing = new ArrayList<>();
        for (int i = 0; i < housingList.size(); i++) {
            if (housingList.get(i).getNumberOfRooms() == numberOfRooms) {
                filterHousing.add(housingList.get(i));
            }
        }
        return filterHousing;
    }
}
