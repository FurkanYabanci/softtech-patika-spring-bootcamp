import model.House;
import model.Housing;
import model.Summerhouse;
import model.Villa;

import java.util.ArrayList;
import java.util.List;

public class HousingObject {

    Housing house1 = new House(1790000,200,"4+1","Ankara");
    Housing house2 = new House(1200000,156,"2+1","Bursa");
    Housing house3 = new House(525000,76,"1+1","Balıkesir");
    Housing house4 = new House(349000,115,"2+1","İstanbul");

    Housing summerhouse1 = new Summerhouse(719000,100,"3+1","Tekirdağ");
    Housing summerhouse2 = new Summerhouse(1450000,100,"3+1","Aydın");
    Housing summerhouse3 = new Summerhouse(369000,100,"1+1","Sakarya");
    Housing summerhouse4 = new Summerhouse(865000,100,"4+1","Niğde");

    Housing villa1 = new Villa(2750000,450,"6+1","Tekirdağ");
    Housing villa2 = new Villa(5370000,350,"5+2","İstanbul");
    Housing villa3 = new Villa(10000000,401,"6+2","İstanbul");
    Housing villa4 = new Villa(25000000,2000,"8+1","İzmir");

    public List<Housing> getHouseList(){
        List<Housing> houseList = new ArrayList<>();
        houseList.add(house1);
        houseList.add(house2);
        houseList.add(house3);
        houseList.add(house4);
        return  houseList;
    }
    public List<Housing> getSummerhouseList(){
        List<Housing> summerhouseList = new ArrayList<>();
        summerhouseList.add(summerhouse1);
        summerhouseList.add(summerhouse2);
        summerhouseList.add(summerhouse3);
        summerhouseList.add(summerhouse4);
        return  summerhouseList;
    }
    public List<Housing> getVillaList(){
        List<Housing> villaList = new ArrayList<>();
        villaList.add(villa1);
        villaList.add(villa2);
        villaList.add(villa3);
        villaList.add(villa4);
        return  villaList;
    }
    public List<Housing> getHousingList(){
        List<Housing> housingList = new ArrayList<>();
        for (int i = 0; i < getVillaList().size(); i++)
        {
            housingList.add(getVillaList().get(i));
        }
        for (int i = 0; i < getHouseList().size(); i++)
        {
            housingList.add(getHouseList().get(i));
        }
        for (int i = 0; i < getSummerhouseList().size(); i++)
        {
            housingList.add(getSummerhouseList().get(i));
        }
        return  housingList;
    }
}
